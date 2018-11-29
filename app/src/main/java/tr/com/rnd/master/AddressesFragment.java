package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
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

import tr.com.rnd.master.Adapters.AddressesAdapter;
import tr.com.rnd.master.Model.Request.GetAddressListRequest;
import tr.com.rnd.master.Model.Request.SetOrderAddressRequest;
import tr.com.rnd.master.Model.Result.GetAddressListResult;
import tr.com.rnd.master.Model.Result.SetOrderAddressResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;


public class AddressesFragment extends Fragment implements ShowProgress {
    View progress;

    RecyclerView addresses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addresses, container, false);

        ((BasketActivity) getActivity()).toolbar.setNavigationIcon(R.drawable.back);
        ((BasketActivity) getActivity()).toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        progress = view.findViewById(R.id.progress);

        addresses = (RecyclerView) view.findViewById(R.id.table);
        addresses.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        addresses.setHasFixedSize(true);

        showProgress(true);

        final GetAddressListRequest request = new GetAddressListRequest(((BasketActivity)getActivity()).tokenResult.tokenType, ((BasketActivity)getActivity()).tokenResult.accessToken, 1);
        Log.d("TAG", "getOrder: " + request.getHeaders());
        Log.d("TAG", "getOrder: " + request.getParameters());
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                showProgress(false);

                Log.d("TAG", response.toString());

                Gson gson = new Gson();
                ((BasketActivity) getActivity()).getAddressListResult = gson.fromJson(response.toString(), GetAddressListResult.GetAddressList.class);

                Log.d("TAG", "response: " + ((BasketActivity) getActivity()).getAddressListResult.success);

                addresses.setAdapter(new AddressesAdapter(getActivity(), ((BasketActivity) getActivity()).getAddressListResult, addressesAdapterListener));
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

        return view;
    }

    AddressesAdapter.AddressesAdapterListener addressesAdapterListener = new AddressesAdapter.AddressesAdapterListener() {
        @Override
        public void addressesAdapterListener(final int position) {
            showProgress(true);

            final SetOrderAddressRequest request = new SetOrderAddressRequest(((BasketActivity)getActivity()).tokenResult.tokenType, ((BasketActivity)getActivity()).tokenResult.accessToken, false, ((BasketActivity) getActivity()).getAddressListResult.data.get(position).id, "true");
            Log.d("TAG", "getOrder: " + request.getHeaders());
            Log.d("TAG", "getOrder: " + request.getParameters());
            RequestQueue queue = Volley.newRequestQueue(getActivity());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    showProgress(false);

                    Log.d("TAG", "SetOrderAddressResponse: " + response.toString());

                    Gson gson = new Gson();
                    SetOrderAddressResult.SetOrderAddress setOrderAddressResult = gson.fromJson(response.toString(), SetOrderAddressResult.SetOrderAddress.class);

                    Log.d("TAG", "response: " + setOrderAddressResult.success);
                    if (((BasketActivity) getActivity()).getAddressListResult.data.get(position).areaId == null) {
                        ((BasketActivity) getActivity()).selectAreaId = 0;
                    }
                    else {
                        ((BasketActivity) getActivity()).selectAreaId = Integer.valueOf(((BasketActivity) getActivity()).getAddressListResult.data.get(position).areaId);
                    }
                    ((BasketActivity) getActivity()).selectAddressIndex = position;

                    ((BasketActivity) getActivity()).loadFragment(new FastDeliveryFragment());
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
    };

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
