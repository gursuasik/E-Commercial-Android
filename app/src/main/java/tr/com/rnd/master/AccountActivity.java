package tr.com.rnd.master;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import tr.com.rnd.master.Model.Result.TokenResult;

public class AccountActivity extends AppCompatActivity {
    Fragment fragment;

    String token;
    TokenResult.Token tokenResult;

    int addressType;
    int addressId;

    String saleCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bilgilerim");
        toolbar.setNavigationIcon(R.drawable.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if (savedInstanceState == null) {
            loadFragment(new AccountFragment());
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
