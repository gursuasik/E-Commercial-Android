package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.LayoutInflater;
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

import tr.com.rnd.master.Model.Request.RegisterRequest;
import tr.com.rnd.master.Model.Result.RegisterResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class SignupFragment extends Fragment implements ShowProgress {
    View progress;

    AppCompatEditText firstName;
    AppCompatEditText lastName;
    AppCompatEditText email;
    AppCompatEditText password;
    AppCompatSpinner gender;

    String news = "false";
    String licenceAgrement = "false";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_signup, container, false);

        ((LoginActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setHasOptionsMenu(true);

        progress = view.findViewById(R.id.progress);

        firstName = (AppCompatEditText) view.findViewById(R.id.firstName);
        lastName = (AppCompatEditText) view.findViewById(R.id.lastName);
        email = (AppCompatEditText) view.findViewById(R.id.email);
        password = (AppCompatEditText) view.findViewById(R.id.password);
        gender = (AppCompatSpinner) view.findViewById(R.id.gender);

        final AppCompatRadioButton newsCheck = (AppCompatRadioButton) view.findViewById(R.id.newsCheck);
        newsCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newsCheck.isSelected()) {
                    newsCheck.setSelected(false);
                    newsCheck.setChecked(false);

                    news = "false";
                }
                else {
                    newsCheck.setSelected(true);
                    newsCheck.setChecked(true);

                    news = "true";
                }
            }
        });

        final AppCompatRadioButton licenceAgrementCheck = (AppCompatRadioButton) view.findViewById(R.id.licenceAgrementCheck);
        licenceAgrementCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (licenceAgrementCheck.isSelected()) {
                    licenceAgrementCheck.setSelected(false);
                    licenceAgrementCheck.setChecked(false);

                    licenceAgrement = "false";
                }
                else {
                    licenceAgrementCheck.setSelected(true);
                    licenceAgrementCheck.setChecked(true);

                    licenceAgrement = "true";
                }
            }
        });

        AppCompatButton signUp = (AppCompatButton) view.findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (licenceAgrement == "false") {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setTitle("Hata");
                    alert.setMessage("Lütfen kullanıcı söxleşmesini onaylayınız!");
                    alert.setPositiveButton("Anladım", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    AlertDialog alertdialog = alert.create();
                    alertdialog.show();
                }
                else {
                    register();
                }
            }
        });

        return view;
    }

    void register() {
        showProgress(true);

        final RegisterRequest request = new RegisterRequest(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), password.getText().toString(), gender.getSelectedItem().toString(), "", "", news, licenceAgrement, "false");
        Log.d("TAG", "onClick: " + request.getParameters());
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(request.method, request.getURL(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showProgress(false);

                Log.d("TAG", "Register: " + response);

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                ((LoginActivity)getActivity()).registerResult = gson.fromJson(jsonObject.toString(), RegisterResult.Register.class);

                if (((LoginActivity)getActivity()).registerResult.success) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setTitle("Tebrikler");
                    alert.setMessage("Mailiniz başarılı bir şekilde oluşturuldu!");
                    alert.setPositiveButton("Anladım", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getActivity().onBackPressed();
                        }
                    });
                    AlertDialog alertdialog = alert.create();
                    alertdialog.show();
                }
                else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setTitle("Dikkat");
                    alert.setMessage(((LoginActivity)getActivity()).registerResult.message);
                    alert.setPositiveButton("Anladım", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    AlertDialog alertdialog = alert.create();
                    alertdialog.show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                showProgress(false);

                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Dikkat");
                alert.setMessage("E-mail formatı hatalı");
                alert.setPositiveButton("Anladım", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog alertdialog = alert.create();
                alertdialog.show();
            }
        }) {
            /*@Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return init.getHeaders();
            }
*/
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
