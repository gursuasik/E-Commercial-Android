package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
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

import tr.com.rnd.master.Model.Request.CardPaymentRequest;
import tr.com.rnd.master.Model.Result.CardPaymentResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class OrderResultFragment extends Fragment implements ShowProgress {
    View progress;

    AppCompatTextView delivery;
    AppCompatTextView deliveryMessage;
    AppCompatTextView address;
    AppCompatTextView addressMessage;
    AppCompatImageView paymentIcon;
    AppCompatTextView cardName;
    AppCompatTextView installment;
    AppCompatTextView price;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_result, container, false);

        progress = view.findViewById(R.id.progress);

        AppCompatButton cancel = (AppCompatButton) view.findViewById(R.id.cancel);
        delivery = (AppCompatTextView) view.findViewById(R.id.delivery);
        deliveryMessage = (AppCompatTextView) view.findViewById(R.id.deliveryMessage);
        address = (AppCompatTextView) view.findViewById(R.id.address);
        addressMessage = (AppCompatTextView) view.findViewById(R.id.addressMessage);
        paymentIcon = (AppCompatImageView) view.findViewById(R.id.paymentIcon);
        cardName = (AppCompatTextView) view.findViewById(R.id.cardName);
        installment = (AppCompatTextView) view.findViewById(R.id.installment);
        price = (AppCompatTextView) view.findViewById(R.id.price);
        AppCompatButton payment = (AppCompatButton) view.findViewById(R.id.payment);

        delivery.setText(((BasketActivity) getActivity()).fastDeliverys.get(((BasketActivity) getActivity()).selectFastDeliveryIndex).name);
        deliveryMessage.setText(((BasketActivity) getActivity()).fastDeliverys.get(((BasketActivity) getActivity()).selectFastDeliveryIndex).note);
        address.setText(((BasketActivity) getActivity()).getAddressListResult.data.get(((BasketActivity) getActivity()).selectAddressIndex).nickName);
        addressMessage.setText(((BasketActivity) getActivity()).getAddressListResult.data.get(((BasketActivity) getActivity()).selectAddressIndex).addressText);
        paymentIcon.setImageResource(getActivity().getResources().getIdentifier(((BasketActivity) getActivity()).paymentTypeData[((BasketActivity) getActivity()).selectPaymentTypeIndex].image, "drawable", getActivity().getPackageName()));
        cardName.setText(((BasketActivity) getActivity()).cardPaymentRequest.name);
        installment.setText(String.valueOf(((BasketActivity) getActivity()).cardPaymentRequest.installmentCount));
        int inst = ((BasketActivity) getActivity()).cardPaymentRequest.installmentCount;
        installment.setText(inst + " Taksit");
        if (((BasketActivity) getActivity()).cardPaymentRequest.installmentCount == 1) {
            installment.setText("Tek Çekim");
        }
        price.setText(String.format("%.2f TL", Double.valueOf(((BasketActivity) getActivity()).getOrderBasketResult.data.grandTotal)));

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onClick: No WiFi address");

                showProgress(true);

                final CardPaymentRequest request = new CardPaymentRequest(((BasketActivity)getActivity()).tokenResult.tokenType, ((BasketActivity)getActivity()).tokenResult.accessToken, ((BasketActivity) getActivity()).cardPaymentRequest.email, ((BasketActivity)getActivity()).cardPaymentRequest.name, ((BasketActivity)getActivity()).cardPaymentRequest.cardNo, ((BasketActivity)getActivity()).cardPaymentRequest.expireMonth, ((BasketActivity)getActivity()).cardPaymentRequest.expireYear, ((BasketActivity)getActivity()).cardPaymentRequest.cvv2, "123.234.222.111", ((BasketActivity) getActivity()).cardPaymentRequest.installmentCount);
                Log.d("TAG", "cardPayment: " + request.getHeaders());
                Log.d("TAG", "cardPayment: " + request.getParameters());
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        showProgress(false);

                        Log.d("TAG", "CardPaymentResponse: " + response.toString());

                        Gson gson = new Gson();
                        ((BasketActivity) getActivity()).cardPaymentResult = gson.fromJson(response.toString(), CardPaymentResult.CardPayment.class);

                        Log.d("TAG", "response: " + ((BasketActivity) getActivity()).cardPaymentResult.success);

                        ((BasketActivity) getActivity()).loadFragment(new PaymentResultFragment());
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
        });


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
