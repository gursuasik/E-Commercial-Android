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

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import tr.com.rnd.master.Model.Config.DBHelper;
import tr.com.rnd.master.Model.Request.GetContactRequest;
import tr.com.rnd.master.Model.Request.TokenRequest;
import tr.com.rnd.master.Model.Request.UpdateContactRequest;
import tr.com.rnd.master.Model.Result.GetContactResult;
import tr.com.rnd.master.Model.Result.TokenResult;
import tr.com.rnd.master.Model.Result.UpdateContactResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class UpdateContactFragment extends Fragment implements ShowProgress {
    View progress;

    AppCompatEditText firstName;
    AppCompatEditText lastName;
    AppCompatEditText email;
    AppCompatEditText password;
    AppCompatSpinner gender;
    AppCompatRadioButton newsCheck;

    int contactId;
    String uniqNo;
    String birthDay;
    String mobile;
    String news;
    String isValid;
    String workingStatus;
    String identityNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_contact, container, false);

        getActivity().findViewById(R.id.appBar).setVisibility(View.VISIBLE);

        progress = view.findViewById(R.id.progress);

        firstName = (AppCompatEditText) view.findViewById(R.id.firstName);
        lastName = (AppCompatEditText) view.findViewById(R.id.lastName);
        email = (AppCompatEditText) view.findViewById(R.id.email);
        password = (AppCompatEditText) view.findViewById(R.id.password);
        gender = (AppCompatSpinner) view.findViewById(R.id.gender);
        newsCheck = (AppCompatRadioButton) view.findViewById(R.id.newsCheck);

        final GetContactRequest request = new GetContactRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity)getActivity()).tokenResult.accessToken);
        Log.d("TAG", "getOrder: " + request.getHeaders());
        Log.d("TAG", "getOrder: " + request.getParameters());
        showProgress(true);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                showProgress(false);

                Log.d("TAG", response.toString());

                Gson gson = new Gson();
                GetContactResult.GetContact getContactResult = gson.fromJson(response.toString(), GetContactResult.GetContact.class);

                Log.d("TAG", "response: " + getContactResult.success);
                contactId = getContactResult.data.segments.get(0).contactId;
                uniqNo = getContactResult.data.uniqNo;

                firstName.setText(getContactResult.data.name);
                lastName.setText(getContactResult.data.surname);
                email.setText(getContactResult.data.email);
                for(int i= 0; i < gender.getAdapter().getCount(); i++) {
                    if(gender.getAdapter().getItem(i).toString().contains(getContactResult.data.gender)) {
                        gender.setSelection(i);
                    }
                }
                birthDay = getContactResult.data.birthDay;
                mobile = getContactResult.data.mobile;
                newsCheck.setChecked(getContactResult.data.wantsNewsletter);
                workingStatus = getContactResult.data.workingStatus;
                identityNumber = getContactResult.data.identityNumber;

                password.setText(new DBHelper(getActivity()).selectUser().password);

                news = "false";
                if (newsCheck.isSelected()) {
                    news = "true";
                }

                isValid = "false";
                if (getContactResult.data.isValid) {
                    isValid = "true";
                }
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

        AppCompatButton update = (AppCompatButton) view.findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgress(true);

                final UpdateContactRequest request = new UpdateContactRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity)getActivity()).tokenResult.accessToken, contactId, uniqNo, firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), password.getText().toString(), gender.getSelectedItem().toString(), birthDay, mobile, news, isValid, workingStatus, identityNumber);
                Log.d("TAG", "getOrder: " + request.getHeaders());
                Log.d("TAG", "getOrder: " + request.getParameters());
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        showProgress(false);

                        Log.d("TAG", response.toString());

                        Gson gson = new Gson();
                        UpdateContactResult.UpdateContact updateContactResult = gson.fromJson(response.toString(), UpdateContactResult.UpdateContact.class);

                        Log.d("TAG", "response: " + updateContactResult.success);
                        if (updateContactResult.success) {
                            new DBHelper(getActivity()).deleteUser();

                            final TokenRequest request = new TokenRequest(email.getText().toString(), password.getText().toString());
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

                                    ((AccountActivity) getActivity()).tokenResult = tokenResult;
                                    ((AccountActivity) getActivity()).token = response;

                                    new DBHelper(getActivity()).insertToken(request);

                                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                                    alert.setTitle("Tebrikler");
                                    alert.setMessage("Profiliniz güncellendi!");
                                    alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            getActivity().onBackPressed();
                                        }
                                    });
                                    AlertDialog alertdialog = alert.create();
                                    alertdialog.show();
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
                        else {
                            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                            alert.setTitle("Dikkat");
                            alert.setMessage("Hata oluştu!");
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
