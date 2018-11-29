package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import tr.com.rnd.master.Adapters.ProductsAdapter;
import tr.com.rnd.master.Model.Request.SearchRequest;
import tr.com.rnd.master.Model.Result.SearchResult;
import tr.com.rnd.master.Model.Result.TokenResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class ProductsFragment extends Fragment implements ShowProgress {
    View progress;
    AppCompatEditText searchText;
    AppCompatImageButton search;
    RecyclerView table;

    final int LOGIN_RESULT = 0;
    final int ACCOUNT_RESULT = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        ((ProductsActivity) getActivity()).toolbar.setNavigationIcon(R.drawable.filter);
        ((ProductsActivity) getActivity()).toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ProductsActivity) getActivity()).loadFragment(new FilterFragment());
            }
        });

        setHasOptionsMenu(true);

        progress = view.findViewById(R.id.progress);
        searchText = (AppCompatEditText) view.findViewById(R.id.searchText);
        //searchText.setFocusable(false);
        search = (AppCompatImageButton) view.findViewById(R.id.search);
        table = (RecyclerView) view.findViewById(R.id.table);
        table.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        table.setHasFixedSize(true);
        table.setFocusable(false);

        search();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchText.getText().length() != 0) {
                    ((ProductsActivity) getActivity()).url = "";
                    ((ProductsActivity) getActivity()).k = searchText.getText().toString();
                    search();
                }

                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getView().getWindowToken(), 0);
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cancel:
                        Intent intent = new Intent();

                        intent.putExtra(TokenResult.class.getName(), ((ProductsActivity) getActivity()).token);
                        intent.putExtra("emailAddress", ((ProductsActivity) getActivity()).emailAddress);
                        intent.putExtra("openLogin", true);
                        getActivity().setResult(Activity.RESULT_OK, intent);
                        getActivity().finish();
                        return true;

                    case R.id.myFavorites:
                        Log.d("TAG", "onNavigationItemSelected: myFavorites");
                        return true;

                    case R.id.myAccount:
                        if (((ProductsActivity) getActivity()).tokenResult != null) {
                            startActivityForResult(new Intent(getActivity().getBaseContext(), AccountActivity.class), ACCOUNT_RESULT);
                        }
                        else {
                            ((ProductsActivity) getActivity()).open = "Account";

                            startActivityForResult(new Intent((ProductsActivity)getActivity(), LoginActivity.class), LOGIN_RESULT);
                        }
                        return true;
                }

                return false;
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.products, menu);
        super.onCreateOptionsMenu(menu, inflater);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.showBasket) {
            if (((ProductsActivity) getActivity()).tokenResult != null) {
                Intent intent = new Intent(getActivity(), BasketActivity.class);
                intent.putExtra(TokenResult.class.getName(), ((ProductsActivity) getActivity()).token);
                intent.putExtra("emailAddress", ((ProductsActivity) getActivity()).emailAddress);
                startActivity(intent);
            }
            else {
                ((ProductsActivity) getActivity()).open = "Basket";
                Log.d("TAG", "onOptionsItemSelected: " + LOGIN_RESULT);
                startActivityForResult(new Intent(getActivity(), LoginActivity.class), LOGIN_RESULT);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("TAG", "onActivityResult: ProductsFragment");
        switch(requestCode) {
            case LOGIN_RESULT:
                if (resultCode == Activity.RESULT_OK) {
                    ((ProductsActivity) getActivity()).token = data.getStringExtra(TokenResult.class.getName());

                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(((ProductsActivity) getActivity()).token);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Gson gson = new Gson();
                    ((ProductsActivity) getActivity()).tokenResult = gson.fromJson(jsonObject.toString(), TokenResult.Token.class);
                    //Log.d("TAG", "onActivityResult: " + tokenResult.accessToken);
                    ((ProductsActivity) getActivity()).emailAddress = data.getStringExtra("emailAddress");
                    ((ProductsActivity) getActivity()).openLogin = data.getBooleanExtra("openLogin", false);

                    if (((ProductsActivity) getActivity()).openLogin) {
                        if (((ProductsActivity) getActivity()).open.equals("Account")) {
                            startActivity(new Intent(getActivity(), AccountActivity.class));
                        }
                        else if (((ProductsActivity) getActivity()).open.equals("Basket")) {
                            Intent intent = new Intent(getActivity(), BasketActivity.class);
                            intent.putExtra(TokenResult.class.getName(), ((ProductsActivity) getActivity()).token);
                            startActivity(intent);
                        }

                        ((ProductsActivity) getActivity()).openLogin = false;
                        ((ProductsActivity) getActivity()).open = "";
                    }
                }

                break;

            case ACCOUNT_RESULT:
                if (resultCode == Activity.RESULT_OK) {
                    if (data.getStringExtra(TokenResult.class.getName()) == null) {
                        ((ProductsActivity) getActivity()).token = null;
                        ((ProductsActivity) getActivity()).tokenResult = null;
                    }

                    ((ProductsActivity) getActivity()).openLogin = data.getBooleanExtra("openLogin", false);
                }

                break;
        }
    }

    void search() {
        final SearchRequest request = new SearchRequest(((ProductsActivity)getActivity()).url, "1", "20", ((ProductsActivity)getActivity()).s, ((ProductsActivity)getActivity()).o, ((ProductsActivity)getActivity()).k, ((ProductsActivity)getActivity()).t);
        Log.d("TAG", "search: " + request.getParameters());
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        showProgress(true);
        StringRequest stringRequest = new StringRequest(request.method, request.getURL(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showProgress(false);

                Log.d("TAG", "search: " + response);

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                ((ProductsActivity) getActivity()).searchResult = gson.fromJson(jsonObject.toString(), SearchResult.Search.class);

                table.setAdapter(new ProductsAdapter(getActivity(), ((ProductsActivity) getActivity()).searchResult.data.products));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                showProgress(false);

                Log.d("TAG", "onErrorResponse: " + String.valueOf(error.getMessage()));
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return request.getParameters();
            }
        };
        queue.add(stringRequest);
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
