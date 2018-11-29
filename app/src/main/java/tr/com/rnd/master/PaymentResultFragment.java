package tr.com.rnd.master;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PaymentResultFragment extends Fragment {
    AppCompatTextView message;
    AppCompatTextView data;
    AppCompatTextView price;
    AppCompatButton closeBasket;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_result, container, false);

        message = (AppCompatTextView) view.findViewById(R.id.message);
        data = (AppCompatTextView) view.findViewById(R.id.data);
        price = (AppCompatTextView) view.findViewById(R.id.price);
        closeBasket = (AppCompatButton) view.findViewById(R.id.closeBasket);

        message.setText(((BasketActivity) getActivity()).cardPaymentResult.message);
        if (((BasketActivity) getActivity()).cardPaymentResult.success) {
            data.setText(((BasketActivity) getActivity()).cardPaymentResult.data + "'nolu siparişiniz oluşturulmuştur!");
            message.setTextColor(Color.argb(255,40,211,108));
        }

        price.setText(String.format("%.2f TL", Double.valueOf(((BasketActivity) getActivity()).getOrderBasketResult.data.grandTotal)));

        closeBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return view;
    }

}
