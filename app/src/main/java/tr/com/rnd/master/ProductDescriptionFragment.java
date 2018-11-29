package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tr.com.rnd.master.Adapters.BodyCollectionAdapter;
import tr.com.rnd.master.Adapters.ProductDescriptionAdapter;
import tr.com.rnd.master.Adapters.SlideAdapter;
import tr.com.rnd.master.Model.Body;
import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Request.AddProductRequest;
import tr.com.rnd.master.Model.Request.GetProductDescriptionRequest;
import tr.com.rnd.master.Model.Result.AddProductResult;
import tr.com.rnd.master.Model.Result.GetProductDescriptionResult;
import tr.com.rnd.master.Model.Result.TokenResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class ProductDescriptionFragment extends Fragment implements ShowProgress {
    View progress;
    ViewPager viewPager;
    TabLayout indicator;
    AppCompatTextView name;
    AppCompatTextView oldPrice;
    AppCompatTextView price;
    LinearLayout bodyCountView;
    AppCompatButton body;
    AppCompatTextView count;
    AppCompatButton reduce;
    AppCompatButton increment;
    RecyclerView bodyCollectionView;
    RecyclerView table;
    AppCompatButton addBasket;

    GetProductDescriptionResult.GetProductDescription getProductDescriptionResult;
    List<Bitmap> slides;
    int bodySelectIndex;
    List<Body> bodyData = new ArrayList<Body>();
    List<String> randomTexts = new ArrayList<String>();
    SelectProduct selectProduct;
    Boolean addProductStatus = false;

    final int LOGIN_RESULT = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_description, container, false);

        ((ProductsActivity) getActivity()).toolbar.setNavigationIcon(R.drawable.back);
        ((ProductsActivity) getActivity()).toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        setHasOptionsMenu(true);

        progress = view.findViewById(R.id.progress);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        indicator = (TabLayout) view.findViewById(R.id.indicator);
        name = (AppCompatTextView) view.findViewById(R.id.name);
        oldPrice = (AppCompatTextView) view.findViewById(R.id.oldPrice);
        price = (AppCompatTextView) view.findViewById(R.id.price);

        bodyCollectionView = (RecyclerView) view.findViewById(R.id.bodyCollectionView);
        //bodyCollectionView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        bodyCollectionView.setHasFixedSize(true);
        bodyCollectionView.setFocusable(false);

        bodyCountView = (LinearLayout) view.findViewById(R.id.bodyCountView);
        bodyCountView.setVisibility(View.GONE);

        table = (RecyclerView) view.findViewById(R.id.table);
        //table.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        table.setHasFixedSize(true);
        table.setFocusable(false);

        body = (AppCompatButton) view.findViewById(R.id.body);
        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bodyCountView.setVisibility(View.GONE);
                bodyCollectionView.setVisibility(View.VISIBLE);
            }
        });

        count = (AppCompatTextView) view.findViewById(R.id.count);

        reduce = (AppCompatButton) view.findViewById(R.id.reduce);
        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bodyData.get(bodySelectIndex).select > 0) {
                    bodyData.get(bodySelectIndex).select -= 1;
                }

                selectProduct.quantity = String.valueOf(bodyData.get(bodySelectIndex).select);

                count.setText(String.valueOf(bodyData.get(bodySelectIndex).select));
            }
        });

        increment = (AppCompatButton) view.findViewById(R.id.increment);
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bodyData.get(bodySelectIndex).select += 1;

                selectProduct.quantity = String.valueOf(bodyData.get(bodySelectIndex).select);

                count.setText(String.valueOf(bodyData.get(bodySelectIndex).select));
            }
        });

        addBasket = (AppCompatButton) view.findViewById(R.id.addBasket);
        addBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectProduct != null) {
                    if (((ProductsActivity) getActivity()).tokenResult == null) {
                        addProductStatus = true;
                        ((ProductsActivity) getActivity()).open = "";

                        startActivityForResult(new Intent(getActivity(), LoginActivity.class), LOGIN_RESULT);
                    }
                    else {
                        addProduct();
                    }
                }
                else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setTitle("Dikkat");
                    alert.setMessage("Önce beden seçiniz!");
                    alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    AlertDialog alertdialog = alert.create();
                    alertdialog.show();
                }
            }
        });

        final GetProductDescriptionRequest request = new GetProductDescriptionRequest(((ProductsActivity)getActivity()).productCode);
        Log.d("TAG", "productCode: " + request.getParameters());

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        showProgress(true);
        StringRequest stringRequest = new StringRequest(request.method, request.getURL(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showProgress(false);

                Log.d("TAG", "GetProductDescription: " + response);

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                getProductDescriptionResult = gson.fromJson(jsonObject.toString(), GetProductDescriptionResult.GetProductDescription.class);

                Log.d("TAG", "getProductDescriptionResult: " + getProductDescriptionResult.getSuccess());
                slides = new ArrayList<Bitmap>();

                RequestQueue queueImage = Volley.newRequestQueue(getActivity());
                for (GetProductDescriptionResult.Image image: getProductDescriptionResult.data.images) {
                    //Log.d("TAG", "slideHome: " + slider.getSmallImage());
                    ImageRequest imageRequest = new ImageRequest(new Config().PRODUCT_IMAGE_URL + image.fileName, new Response.Listener<Bitmap>() {
                        @Override
                        public void onResponse(Bitmap data) {
                            slides.add(data);
                        }
                    }, 0, 0, null, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("TAG", "onErrorResponse: " + error.networkResponse.statusCode);
                        }
                    });
                    queueImage.add(imageRequest);
                }

                final int[] queue = {0};
                queueImage.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<ImageRequest>() {
                    @Override
                    public void onRequestFinished(Request<ImageRequest> request) {
                        queue[0]++;
                        if (queue[0] == getProductDescriptionResult.data.images.size()) {
                            viewPager.setAdapter(new SlideAdapter(getActivity(), slides));
                            indicator.setupWithViewPager(viewPager, true);

                            Log.d("TAG", "onRequestFinished: " + getProductDescriptionResult.data.images.get(0).fileName);
                        }
                    }
                });

                name.setText(getProductDescriptionResult.data.name);
                String attributeString = String.format("%.2f TL", Double.valueOf(getProductDescriptionResult.data.oldPrice));
                oldPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                oldPrice.setText(attributeString);
                price.setText(String.format("%.2f TL", Double.valueOf(getProductDescriptionResult.data.price)));

                int m = getProductDescriptionResult.data.products.size();
                for (int i = 0; i < m; i++){
                    Body body = new Body();
                    body.name = getProductDescriptionResult.data.products.get(i).body;
                    bodyData.add(body);
                }
                bodyCollectionView.setAdapter(new BodyCollectionAdapter(getActivity(), bodyData, bodyCollectionAdapterListener));

                String explaination1 = "";
                if (getProductDescriptionResult.data.reference3 != null) {
                    explaination1 = getProductDescriptionResult.data.reference3;
                }
                if (getProductDescriptionResult.data.explaination != null) {
                    explaination1 += "<br>" + getProductDescriptionResult.data.explaination;
                }
                if (explaination1 != "") {
                    randomTexts.add(explaination1);
                }

                String explaination2 = "";
                if (getProductDescriptionResult.data.secondExplaination != null) {
                    explaination2 = getProductDescriptionResult.data.secondExplaination;
                }
                if (getProductDescriptionResult.data.fourthExplaination != null) {
                    explaination2 += "<br>" + getProductDescriptionResult.data.fourthExplaination;
                }
                if (explaination2 != "") {
                    randomTexts.add(explaination2);
                }

                table.setAdapter(new ProductDescriptionAdapter(getActivity(), randomTexts));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                showProgress(false);

                Log.d("TAG", "onErrorResponse: " + String.valueOf(error.getMessage()));
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return request.getParameters();
            }
        };
        queue.add(stringRequest);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.products, menu);
        super.onCreateOptionsMenu(menu, inflater);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.showBasket) {
            if (((ProductsActivity) getActivity()).tokenResult != null) {
                Intent intent = new Intent(getActivity(), BasketActivity.class);
                intent.putExtra(TokenResult.class.getName(), ((ProductsActivity) getActivity()).token);
                intent.putExtra("emailAddress", ((ProductsActivity) getActivity()).emailAddress);
                startActivity(intent);
            }
            else {
                ((ProductsActivity) getActivity()).open = "Basket";

                startActivityForResult(new Intent(getActivity(), LoginActivity.class), LOGIN_RESULT);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("TAG", "onActivityResult: ProductDescription");
        switch(requestCode) {
            case LOGIN_RESULT:
                if (resultCode == Activity.RESULT_OK) {
                    ((ProductsActivity) getActivity()).token = data.getStringExtra(TokenResult.class.getName());

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(((ProductsActivity) getActivity()).token);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Gson gson = new Gson();
                    ((ProductsActivity) getActivity()).tokenResult = gson.fromJson(jsonObject.toString(), TokenResult.Token.class);
                    ((ProductsActivity) getActivity()).emailAddress = data.getStringExtra("emailAddress");
                    ((ProductsActivity) getActivity()).openLogin = data.getBooleanExtra("openLogin", false);

                    if (((ProductsActivity) getActivity()).tokenResult != null && addProductStatus) {
                        addProduct();
                    }

                    if (((ProductsActivity) getActivity()).openLogin) {
                        if (((ProductsActivity) getActivity()).open.equals("Basket")) {
                            Intent intent = new Intent(getActivity(), BasketActivity.class);
                            intent.putExtra(TokenResult.class.getName(), ((ProductsActivity) getActivity()).token);
                            startActivity(intent);
                        }

                        ((ProductsActivity) getActivity()).openLogin = false;
                        ((ProductsActivity) getActivity()).open = "";
                    }
                }

                break;
        }
    }

    BodyCollectionAdapter.BodyCollectionAdapterListener bodyCollectionAdapterListener = new BodyCollectionAdapter.BodyCollectionAdapterListener() {
        @Override
        public void bodyCountOpen(int tag) {
            Log.d("TAG", "bodyCountOpen: " + tag);
            for (int i = 0; i < bodyData.size(); i++) {
                bodyData.get(i).select = 0;
            }

            bodySelectIndex = tag;

            bodyData.get(bodySelectIndex).select = 1;

            selectProduct = new SelectProduct(getProductDescriptionResult.data.products.get(bodySelectIndex).barcode, "false", false, String.valueOf(bodyData.get(bodySelectIndex).select));

            body.setText(bodyData.get(bodySelectIndex).name);
            count.setText("1");

            bodyCountView.setVisibility(View.VISIBLE);
            bodyCollectionView.setVisibility(View.GONE);
        }
    };

    void addProduct() {
        showProgress(true);

        final AddProductRequest request = new AddProductRequest(((ProductsActivity) getActivity()).tokenResult.tokenType, ((ProductsActivity) getActivity()).tokenResult.accessToken, selectProduct.barcode, selectProduct.isUpdate, selectProduct.isAddedBySnapBuy, selectProduct.quantity);
        Log.d("TAG", "addProductRequest: " + request.getParameters());
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
                AddProductResult.AddProduct addProductResult = gson.fromJson(jsonObject.toString(), AddProductResult.AddProduct.class);

                if (addProductResult.success) {
                    addProductStatus = false;

                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setTitle("Tebrikler");
                    alert.setMessage("Ürün sepete eklendi!");
                    alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    AlertDialog alertdialog = alert.create();
                    alertdialog.show();
                }
                else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setTitle("Dikkat");
                    alert.setMessage(addProductResult.message);
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

            @Override
            protected Map<String, String> getParams() {
                return request.getParameters();
            }
        };
        queue.add(stringRequest);
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

    class SelectProduct {
        String barcode;
        String isUpdate;
        Boolean isAddedBySnapBuy;
        String quantity;

        public SelectProduct(String barcode, String isUpdate, Boolean isAddedBySnapBuy, String quantity) {
            this.barcode = barcode;
            this.isUpdate = isUpdate;
            this.isAddedBySnapBuy = isAddedBySnapBuy;
            this.quantity = quantity;
        }
    }
}
