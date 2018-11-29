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
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Map;

import tr.com.rnd.master.Adapters.AccountAddressAdapter;
import tr.com.rnd.master.Model.AccountAddressRecyclerItemTouch;
import tr.com.rnd.master.Model.Request.DeleteAddressRequest;
import tr.com.rnd.master.Model.Request.GetAddressListRequest;
import tr.com.rnd.master.Model.Result.DeleteAddressResult;
import tr.com.rnd.master.Model.Result.GetAddressListResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class AccountAddressFragment extends Fragment implements ShowProgress, AccountAddressRecyclerItemTouch.RecyclerItemTouchHelperListener {
    View progress;

    RecyclerView table;

    AccountAddressAdapter accountAddressAdapter;
    GetAddressListResult.GetAddressList getAddressListResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_address, container, false);

        progress = view.findViewById(R.id.progress);

        table = (RecyclerView) view.findViewById(R.id.table);
        table.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        table.setHasFixedSize(true);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new AccountAddressRecyclerItemTouch(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(table);

        getAddressList();

        AppCompatButton addAddress = (AppCompatButton) view.findViewById(R.id.addAddress);
        addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AccountActivity) getActivity()).loadFragment(new AccountAddAddressFragment());
            }
        });

        return view;
    }

    AccountAddressAdapter.AccountAddressAdapterListener accountAddressAdapterListener = new AccountAddressAdapter.AccountAddressAdapterListener() {
        @Override
        public void accountAddressAdapterListener(final int position) {
            ((AccountActivity) getActivity()).addressId = getAddressListResult.data.get(position).id;

            ((AccountActivity) getActivity()).loadFragment(new GetAddressFragment());
        }
    };

    @Override
    public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof AccountAddressAdapter.ViewHolder) {
            final DeleteAddressRequest request = new DeleteAddressRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity) getActivity()).tokenResult.accessToken, ((AccountActivity) getActivity()).addressType, getAddressListResult.data.get(position).id);
            Log.d("TAG", "getOrder: " + request.getHeaders());
            Log.d("TAG", "getOrder: " + request.getParameters());
            showProgress(true);
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    showProgress(false);

                    Log.d("TAG", response.toString());

                    Gson gson = new Gson();
                    DeleteAddressResult.DeleteAddress deleteAddressResult = gson.fromJson(response.toString(), DeleteAddressResult.DeleteAddress.class);

                    Log.d("TAG", "response: " + deleteAddressResult.success);

                    if (deleteAddressResult.success) {
                        accountAddressAdapter.removeItem(viewHolder.getAdapterPosition());

                        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                        alert.setTitle("Tebrikler");
                        alert.setMessage("Adresiniz silindi!");
                        alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //accountAddressAdapter.notifyDataSetChanged();
                                getAddressList();
                            }
                        });
                        AlertDialog alertdialog = alert.create();
                        alertdialog.show();
                    } else {
                        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                        alert.setTitle("Dikkat");
                        alert.setMessage(deleteAddressResult.message);
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

    void getAddressList() {
        final GetAddressListRequest request = new GetAddressListRequest(((AccountActivity)getActivity()).tokenResult.tokenType, ((AccountActivity)getActivity()).tokenResult.accessToken, ((AccountActivity) getActivity()).addressType);
        Log.d("TAG", "getOrder: " + request.getHeaders());
        Log.d("TAG", "getOrder: " + request.getParameters());
        showProgress(true);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                showProgress(false);

                Log.d("TAG", response.toString());

                Gson gson = new Gson();
                getAddressListResult = gson.fromJson(response.toString(), GetAddressListResult.GetAddressList.class);

                //Log.d("TAG", "response: " + ((BasketActivity) getActivity()).getAddressListResult.success);

                accountAddressAdapter = new AccountAddressAdapter(getAddressListResult, accountAddressAdapterListener);
                table.setAdapter(accountAddressAdapter);
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
