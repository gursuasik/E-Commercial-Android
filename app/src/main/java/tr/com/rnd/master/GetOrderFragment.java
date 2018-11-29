package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import tr.com.rnd.master.Adapters.GetOrderAdapter;
import tr.com.rnd.master.Model.Request.GetOrderRequest;
import tr.com.rnd.master.Model.Result.GetOrderResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class GetOrderFragment extends Fragment implements ShowProgress {
    View progress;

    AppCompatTextView saleCode;
    AppCompatTextView status;
    AppCompatTextView saleCreateDate;
    RecyclerView table;
    AppCompatTextView paymentType;
    AppCompatTextView addressType1;
    AppCompatTextView addressType2;
    AppCompatTextView sumPrice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_order, container, false);

        progress = view.findViewById(R.id.progress);

        saleCode = (AppCompatTextView) view.findViewById(R.id.saleCode);
        status = (AppCompatTextView) view.findViewById(R.id.status);
        saleCreateDate = (AppCompatTextView) view.findViewById(R.id.saleCreateDate);

        table = (RecyclerView) view.findViewById(R.id.table);
        table.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        table.setHasFixedSize(true);

        paymentType = (AppCompatTextView) view.findViewById(R.id.paymentType);
        addressType1 = (AppCompatTextView) view.findViewById(R.id.addressType1);
        addressType2 = (AppCompatTextView) view.findViewById(R.id.addressType2);
        sumPrice = (AppCompatTextView) view.findViewById(R.id.sumPrice);

        final GetOrderRequest request = new GetOrderRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity) getActivity()).tokenResult.accessToken, ((AccountActivity) getActivity()).saleCode);
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
                GetOrderResult.GetOrder getOrderResult = gson.fromJson(response.toString(), GetOrderResult.GetOrder.class);

                //Log.d("TAG", "response: " + deleteAddressResult.success);

                saleCode.setText(getOrderResult.data.saleCode + " Numaralı Siparişinizin Detayı");

                String statusString;
                switch (getOrderResult.data.status) {
                    case 1:
                        statusString = "Ödeme Bekliyor";

                        break;

                    case 2:
                        statusString = "Stok Bekliyor";

                        break;

                    case 3:
                        statusString = "Fatura Kes";

                        break;

                    case 4:
                        statusString = "Kargo Gönder";

                        break;

                    case 5:
                        statusString = "Sipariş Tamamlandı";

                        break;

                    case 6:
                        statusString = "Ürün İade Bekliyor";

                        break;

                    case 7:
                        statusString = "İade Faturası Bekliyor";

                        break;

                    case 8:
                        statusString = "Stok İade Bekliyor";

                        break;

                    case 9:
                        statusString = "Ödeme İade Bekliyor";

                        break;

                    case 10:
                        statusString = "İade Tamamlandı";

                        break;

                    default:
                        statusString = "Geçersiz";
                }
                status.setText(statusString);

                SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd.MM.yyyy / HH:mm");
                String data = null;
                try {
                    data = simpleDateFormat1.format(simpleDateFormat0.parse(getOrderResult.data.saleCreateDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                saleCreateDate.setText(data);

                table.setAdapter(new GetOrderAdapter(getActivity(), getOrderResult.data.details));

                for (GetOrderResult.Address item: getOrderResult.data.addresses) {
                    String address = item.nickName + " " + item.addressText + " " + item.townName + " / " + item.cityName;

                    switch (item.type) {
                        case 1:
                            addressType1.setText(address);

                            break;

                        case 2:
                            addressType2.setText(address);

                            break;

                        case 3:
                            addressType1.setText(address);
                            addressType2.setText(address);

                            break;
                    }
                }

                sumPrice.setText(String.format("%.2f TL", Double.valueOf(getOrderResult.data.grandTotal)));
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
