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

import tr.com.rnd.master.Adapters.GetOrdersAdapter;
import tr.com.rnd.master.Model.Request.GetOrdersRequest;
import tr.com.rnd.master.Model.Result.GetOrdersResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class GetOrdersFragment extends Fragment implements ShowProgress {
    View progress;

    RecyclerView table;

    GetOrdersResult.GetOrders getOrdersResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_orders, container, false);

        getActivity().findViewById(R.id.appBar).setVisibility(View.VISIBLE);

        progress = view.findViewById(R.id.progress);

        table = (RecyclerView) view.findViewById(R.id.table);
        table.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        table.setHasFixedSize(true);

        final GetOrdersRequest request = new GetOrdersRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity) getActivity()).tokenResult.accessToken, 10000);
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
                getOrdersResult = gson.fromJson(response.toString(), GetOrdersResult.GetOrders.class);

                //Log.d("TAG", "response: " + deleteAddressResult.success);

                table.setAdapter(new GetOrdersAdapter(getOrdersResult, getOrdersAdapterListener));
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

    GetOrdersAdapter.GetOrdersAdapterListener getOrdersAdapterListener = new GetOrdersAdapter.GetOrdersAdapterListener() {
        @Override
        public void getOrdersAdapterListener(final int position) {
            ((AccountActivity) getActivity()).saleCode = getOrdersResult.data.get(position).saleCode;

            ((AccountActivity) getActivity()).loadFragment(new GetOrderFragment());
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
