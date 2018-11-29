package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import tr.com.rnd.master.Model.Config.DBHelper;
import tr.com.rnd.master.Model.Request.TokenRequest;
import tr.com.rnd.master.Model.Result.TokenResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class LoginFragment extends Fragment implements ShowProgress {
    View progress;
    AppCompatEditText email;
    AppCompatEditText password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ((LoginActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        setHasOptionsMenu(true);

        progress = view.findViewById(R.id.progress);

        email = (AppCompatEditText) view.findViewById(R.id.email);
        password = (AppCompatEditText) view.findViewById(R.id.password);

        AppCompatButton login = (AppCompatButton) view.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getToken(email.getText().toString(), password.getText().toString());
            }
        });

        AppCompatButton signup = (AppCompatButton) view.findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginActivity)getActivity()).loadFragment(new SignupFragment());
            }
        });

        if (((LoginActivity)getActivity()).registerResult != null) {
            getToken(((LoginActivity)getActivity()).registerResult.data.email, ((LoginActivity)getActivity()).registerResult.data.password);
        }

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.login, menu);
        super.onCreateOptionsMenu(menu, inflater);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.cancel) {
            getActivity().finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void getToken(String username, String password) {
        showProgress(true);

        final TokenRequest request = new TokenRequest(username, password);
        Log.d("TAG", "token: " + request.parameters());
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(request.method, request.url(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showProgress(false);

                Log.d("TAG", "token: " + response);

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                TokenResult.Token tokenResult = gson.fromJson(jsonObject.toString(), TokenResult.Token.class);

                Log.d("TAG", "token: " + tokenResult.accessToken);
                new DBHelper(getActivity()).insertToken(request);

                Intent intent = new Intent();
                intent.putExtra(TokenResult.class.getName(), response);
                intent.putExtra("emailAddress", email.getText().toString());
                intent.putExtra("openLogin", true);
                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                showProgress(false);

                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Hata");
                alert.setMessage("Kullanıcı adı veya şifre yanlış!");
                alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog alertdialog = alert.create();
                alertdialog.show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return request.parameters();
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
