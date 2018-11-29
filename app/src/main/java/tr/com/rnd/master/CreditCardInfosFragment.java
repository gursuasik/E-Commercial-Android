package tr.com.rnd.master;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tr.com.rnd.master.Model.Request.CardPaymentRequest;

public class CreditCardInfosFragment extends Fragment {
    AppCompatEditText cardOwner;
    AppCompatEditText cardNumber;
    AppCompatEditText expirationMonth;
    AppCompatEditText expireYear;
    AppCompatEditText cvv;
    AppCompatButton next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credit_card_infos, container, false);

        ((BasketActivity) getActivity()).getSupportActionBar().setTitle("Ödeme");

        cardOwner = (AppCompatEditText) view.findViewById(R.id.cardOwner);
        cardNumber = (AppCompatEditText) view.findViewById(R.id.cardNumber);
        expirationMonth = (AppCompatEditText) view.findViewById(R.id.expirationMonth);
        expireYear = (AppCompatEditText) view.findViewById(R.id.expireYear);
        cvv = (AppCompatEditText) view.findViewById(R.id.cvv);
        next = (AppCompatButton) view.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardOwner.getText().toString().isEmpty()) {
                    showAlert("Kart sahibini giriniz!");
                }
                else if (cardNumber.getText().toString().isEmpty()) {
                    showAlert("Kart numarasını giriniz!");
                }
                else if (expirationMonth.getText().toString().isEmpty()) {
                    showAlert("Son kullanma tarihinin ay bilgisini giriniz!");
                }
                else if (expireYear.getText().toString().isEmpty()) {
                    showAlert("Son kullanma tarihinin yıl bilgisini giriniz!");
                }
                else if (cvv.getText().toString().isEmpty()) {
                    showAlert("CVV kodunu giriniz!");
                }
                else if (cardNumber.getText().toString().length() != 16) {
                    showAlert("Kart numarasını doğru giriniz!");
                }
                else {
                    ((BasketActivity) getActivity()).cardPaymentRequest = new CardPaymentRequest(((BasketActivity) getActivity()).tokenResult.tokenType, ((BasketActivity) getActivity()).tokenResult.accessToken, ((BasketActivity) getActivity()).emailAddress, cardOwner.getText().toString(), cardNumber.getText().toString(), expirationMonth.getText().toString(), expireYear.getText().toString(), cvv.getText().toString(), "123.234.222.111", 0);
                    ((BasketActivity) getActivity()).data = cardNumber.getText().toString();

                    ((BasketActivity) getActivity()).loadFragment(new InstallmentsFragment());
                }
            }
        });

        return view;
    }

    void showAlert(String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Dikkat!");
        alert.setMessage(message);
        alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertdialog = alert.create();
        alertdialog.show();
    }
}
