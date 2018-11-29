package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import tr.com.rnd.master.Adapters.BasketAdapter;
import tr.com.rnd.master.Model.BasketRecyclerItemTouch;
import tr.com.rnd.master.Model.Request.DeleteProductRequest;
import tr.com.rnd.master.Model.Request.GetOrderBasketRequest;
import tr.com.rnd.master.Model.Result.DeleteProductResult;
import tr.com.rnd.master.Model.Result.GetOrderBasketResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class BasketFragment extends Fragment implements ShowProgress, BasketRecyclerItemTouch.RecyclerItemTouchHelperListener {
    View progress;

    RecyclerView products;
    AppCompatTextView sumPrice;
    AppCompatButton completeOrder;

    BasketAdapter basketAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basket, container, false);

        ((BasketActivity) getActivity()).toolbar.setNavigationIcon(R.drawable.cancel);
        ((BasketActivity) getActivity()).toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        progress = view.findViewById(R.id.progress);

        products = (RecyclerView) view.findViewById(R.id.products);
        products.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        products.setItemAnimator(new DefaultItemAnimator());
        products.setHasFixedSize(true);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new BasketRecyclerItemTouch(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(products);

        sumPrice = (AppCompatTextView) view.findViewById(R.id.sumPrice);

        getOrder();

        completeOrder = (AppCompatButton) view.findViewById(R.id.completeOrder);
        completeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((BasketActivity) getActivity()).loadFragment(new AddressesFragment());
            }
        });

        return view;
    }

    void getOrder() {
        showProgress(true);

        final GetOrderBasketRequest request = new GetOrderBasketRequest(((BasketActivity)getActivity()).tokenResult.tokenType, ((BasketActivity)getActivity()).tokenResult.accessToken);
        Log.d("TAG", "getOrder: " + request.getHeaders());
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(request.method, request.getURL(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showProgress(false);

                Log.d("TAG", "response: " + response);

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                ((BasketActivity) getActivity()).getOrderBasketResult = gson.fromJson(jsonObject.toString(), GetOrderBasketResult.GetOrderBasket.class);

                Log.d("TAG", "response: " + ((BasketActivity) getActivity()).getOrderBasketResult.success);

                if (((BasketActivity) getActivity()).getOrderBasketResult.data.details.size() == 0) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setTitle("Dikkat");
                    alert.setMessage("Sepetinizde ürün yok! Sepetinize ürün eklemelisiniz.");
                    alert.setPositiveButton("Anladım", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getActivity().finish();
                        }
                    });
                    AlertDialog alertdialog = alert.create();
                    alertdialog.show();
                }
                else {
                    Log.d("TAG", "Product In Basket: " + ((BasketActivity) getActivity()).getOrderBasketResult.data.details.get(0).uniqNo);
                    basketAdapter = new BasketAdapter(getActivity(), ((BasketActivity) getActivity()).getOrderBasketResult.data.details);
                    products.setAdapter(basketAdapter);

                    sumPrice.setText(String.format("%.2f TL", Double.valueOf(((BasketActivity) getActivity()).getOrderBasketResult.data.grandTotal)));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                showProgress(false);

                Log.d("TAG", "onErrorResponse: " + String.valueOf(error.getMessage()));
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return request.getHeaders();
            }
/*
            @Override
            protected Map<String, String> getParams() {
                return request.getParameters();
            }*/
        };
        queue.add(stringRequest);
    }

    @Override
    public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof BasketAdapter.ViewHolder) {
            showProgress(true);

            final DeleteProductRequest request = new DeleteProductRequest(((BasketActivity)getActivity()).tokenResult.tokenType, ((BasketActivity)getActivity()).tokenResult.accessToken, ((BasketActivity) getActivity()).getOrderBasketResult.data.details.get(viewHolder.getAdapterPosition()).uniqNo);
            Log.d("TAG", "getOrder: " + request.getHeaders());
            Log.d("TAG", "getOrder: " + request.getParameters());
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        showProgress(false);

                        Log.d("TAG", response.toString());

                        Gson gson = new Gson();
                        DeleteProductResult.DeleteProduct deleteProductResult = gson.fromJson(response.toString(), DeleteProductResult.DeleteProduct.class);

                        Log.d("TAG", "response: " + deleteProductResult.success);

                        if (deleteProductResult.success) {
                            basketAdapter.removeItem(viewHolder.getAdapterPosition());

                            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                            alert.setTitle("Tebrikler");
                            alert.setMessage("Ürününüz sepetten çıkarıldı!");
                            alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    getOrder();
                                }
                            });
                            AlertDialog alertdialog = alert.create();
                            alertdialog.show();
                        }
                        else {
                            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                            alert.setTitle("Dikkat");
                            alert.setMessage(deleteProductResult.message);
                            alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
                            AlertDialog alertdialog = alert.create();
                            alertdialog.show();
                        }
                    }
                }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    showProgress(false);

                    Log.d("TAG", "onErrorResponse: " + String.valueOf(error.getMessage()));
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    return request.getHeaders();
                }
            };
            queue.add(jsonObjectRequest);
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    @Override
    public void showProgress(final boolean show) {
        progress.setVisibility(show ? View.VISIBLE : View.GONE);

        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow for very easy animations. If available, use these APIs to fade-in the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            progress.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progress.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        }
    }
}
