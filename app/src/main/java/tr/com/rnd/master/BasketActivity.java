package tr.com.rnd.master;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import tr.com.rnd.master.Model.Request.CardPaymentRequest;
import tr.com.rnd.master.Model.Result.CardPaymentResult;
import tr.com.rnd.master.Model.Result.GetAddressListResult;
import tr.com.rnd.master.Model.Result.GetOrderBasketResult;
import tr.com.rnd.master.Model.Result.TokenResult;

public class BasketActivity extends AppCompatActivity {
    Fragment fragment;

    Toolbar toolbar;

    String token;
    TokenResult.Token tokenResult;

    GetOrderBasketResult.GetOrderBasket getOrderBasketResult;
    GetAddressListResult.GetAddressList getAddressListResult;
    int selectAddressIndex;
    int selectAreaId;
    List<FastDeliveryFragment.FastDelivery> fastDeliverys = null;
    int selectFastDeliveryIndex;
    PaymentTypesFragment.PaymentTypesCell[] paymentTypeData;
    int selectPaymentTypeIndex;
    public CardPaymentRequest cardPaymentRequest;
    String emailAddress;
    String data;
    CardPaymentResult.CardPayment cardPaymentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        token = getIntent().getStringExtra(TokenResult.class.getName());
        if (token != null) {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(token);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Gson gson = new Gson();
            tokenResult = gson.fromJson(jsonObject.toString(), TokenResult.Token.class);
        }
        emailAddress = getIntent().getStringExtra("emailAddress");

        if (savedInstanceState == null) {
            loadFragment(new BasketFragment());
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (fragment != null) {//signout yapıldığında hata vermemesi için
            getSupportFragmentManager().putFragment(outState, "fragment", fragment);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        fragment = getSupportFragmentManager().getFragment(savedInstanceState, "fragment");
    }

    public void loadFragment(Fragment fragment) {
        this.fragment = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
