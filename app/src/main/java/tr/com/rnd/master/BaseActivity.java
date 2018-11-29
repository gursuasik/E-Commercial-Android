package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

import tr.com.rnd.master.Model.Config.DBHelper;
import tr.com.rnd.master.Model.Request.HomePageRequest;
import tr.com.rnd.master.Model.Request.TokenRequest;
import tr.com.rnd.master.Model.Result.HomePageResult;
import tr.com.rnd.master.Model.Result.TokenResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class BaseActivity extends AppCompatActivity implements ShowProgress {
    View progress;

    String tokenResult;
    String emailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        progress = findViewById(R.id.progress);

        final TokenRequest request = new DBHelper(getApplicationContext()).selectUser();
        if (request != null) {
            Log.d("TAG", "Login: OK");
            showProgress(true);
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(request.method, request.url(), new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    showProgress(false);

                    tokenResult = response;

                    emailAddress = request.username;

                    getHomePage(getApplicationContext());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    getHomePage(getApplicationContext());
                }
            }) {
                @Override
                protected Map<String, String> getParams() {
                    return request.parameters();
                }
            };
            queue.add(stringRequest);
        }
        else {
            Log.d("TAG", "Login: NO");
            getHomePage(getApplicationContext());
        }
    }

    private void getHomePage(final Context context) {
        showProgress(true);

        HomePageRequest request = new HomePageRequest();

        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(request.method, request.getURL(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showProgress(false);

                //Log.d("TAG", "onCreate: " + response);

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra(HomePageResult.class.getName(), response);
                intent.putExtra(TokenResult.class.getName(), tokenResult);
                intent.putExtra("emailAddress", emailAddress);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                showProgress(false);

                Log.d("TAG", "onErrorResponse: " + String.valueOf(error.getMessage()));
            }
        }) {
            /*@Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return init.getHeaders();
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                params.put("os_name", init.getOsName());
                params.put("app_version", init.getAppVersion());
                params.put("lang", getString(R.string.lang));

                params.put("api_version", init.apiVersion);

                post[0] = params.toString();
                Log.d("TAG", "getHomePage: " + post[0]);
                return params;
            }*/
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
