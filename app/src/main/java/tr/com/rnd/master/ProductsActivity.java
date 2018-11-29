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

import tr.com.rnd.master.Model.Result.SearchResult;
import tr.com.rnd.master.Model.Result.TokenResult;

public class ProductsActivity extends AppCompatActivity {
    Fragment fragment;

    Toolbar toolbar;

    String token;
    public TokenResult.Token tokenResult;
    String emailAddress;

    SearchResult.Search searchResult;
    String url;
    String s = "";
    String o = "";
    String k = "";
    String t = "";
    public String productCode;

    Boolean openLogin;
    public String open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

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
        url = getIntent().getStringExtra("url");

        if (savedInstanceState == null) {
            loadFragment(new ProductsFragment());
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //if (fragment != null) {//signout yapıldığında hata vermemesi için
        if (fragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, "fragment", fragment);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        fragment = getSupportFragmentManager().getFragment(savedInstanceState, "fragment");
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.basket) {
            Log.d("TAG", "onClick: basket");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
/*
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("TAG", "onActivityResult: ProductsActivity");
        switch(requestCode) {
            case LOGIN_RESULT:
                if (resultCode == Activity.RESULT_OK) {
                    token = data.getStringExtra(TokenResult.class.getName());

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(token);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Gson gson = new Gson();
                    tokenResult = gson.fromJson(jsonObject.toString(), TokenResult.Token.class);
                    //Log.d("TAG", "onActivityResult: " + tokenResult.accessToken);
                    emailAddress = data.getStringExtra("emailAddress");
                    openLogin = data.getBooleanExtra("openLogin", false);

                    if (openLogin) {
                        if (open.equals("Account")) {
                            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                        }
                        else if (open.equals("Basket")) {
                            startActivity(new Intent(getApplicationContext(), BasketActivity.class));
                        }

                        openLogin = false;
                        open = "";
                    }
                }

                break;

            case ACCOUNT_RESULT:
                if (resultCode == Activity.RESULT_OK) {
                    if (data.getStringExtra(TokenResult.class.getName()) == null) {
                        token = null;
                        tokenResult = null;
                    }

                    openLogin = data.getBooleanExtra("openLogin", false);
                }

                break;
        }
    }*/

    public void loadFragment(Fragment fragment) {
        this.fragment = fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
