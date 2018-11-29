package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetBuilder;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetMenuDialog;
import com.github.rubensousa.bottomsheetbuilder.adapter.BottomSheetItemClickListener;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tr.com.rnd.master.Model.Request.GetAddressRequest;
import tr.com.rnd.master.Model.Request.GetAreaListRequest;
import tr.com.rnd.master.Model.Request.GetCityListRequest;
import tr.com.rnd.master.Model.Request.GetContactRequest;
import tr.com.rnd.master.Model.Request.GetTownListRequest;
import tr.com.rnd.master.Model.Request.SaveAddressRequest;
import tr.com.rnd.master.Model.Result.GetAddressResult;
import tr.com.rnd.master.Model.Result.GetAreaListResult;
import tr.com.rnd.master.Model.Result.GetCityListResult;
import tr.com.rnd.master.Model.Result.GetContactResult;
import tr.com.rnd.master.Model.Result.SaveAddressResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class GetAddressFragment extends Fragment implements ShowProgress {
    View progress;

    AppCompatButton head;
    AppCompatEditText name;
    AppCompatEditText surname;
    AppCompatButton province;
    AppCompatButton district;
    AppCompatButton area;
    AppCompatEditText address;
    AppCompatEditText phone;
    AppCompatButton save;

    int headSelect;
    int provinceId;
    List<Integer> provinceIds;
    List<String> provinces;
    int districtId;
    List<Integer> districtIds;
    List<String> districts;
    int areaId;
    List<Integer> areaIds;
    List<String> areas;

    Menu headMenu;
    Menu provinceMenu;
    Menu districtMenu;
    Menu areaMenu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_address, container, false);

        progress = view.findViewById(R.id.progress);

        head = (AppCompatButton) view.findViewById(R.id.head);
        name = (AppCompatEditText) view.findViewById(R.id.name);
        surname = (AppCompatEditText) view.findViewById(R.id.surname);
        province = (AppCompatButton) view.findViewById(R.id.province);
        district = (AppCompatButton) view.findViewById(R.id.district);
        area = (AppCompatButton) view.findViewById(R.id.area);
        address = (AppCompatEditText) view.findViewById(R.id.address);
        phone = (AppCompatEditText) view.findViewById(R.id.phone);
        save = (AppCompatButton) view.findViewById(R.id.save);

        final List<String> heads = new ArrayList<String>();
        heads.add("Ev Adresi");
        heads.add("İş Adresi");
        heads.add("Diğer Adres");
        headSelect = -1;

        provinceIds = new ArrayList<Integer>();
        provinces = new ArrayList<String>();

        districtIds = new ArrayList<Integer>();
        districts = new ArrayList<String>();

        areaIds = new ArrayList<Integer>();
        areas = new ArrayList<String>();

        final GetAddressRequest request = new GetAddressRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity)getActivity()).tokenResult.accessToken, ((AccountActivity) getActivity()).addressType, ((AccountActivity) getActivity()).addressId);
        Log.d("TAG", "getOrder: " + request.getHeaders());
        Log.d("TAG", "getOrder: " + request.getParameters());
        showProgress(true);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onResponse(JSONObject response) {
                showProgress(false);

                Log.d("TAG", response.toString());

                Gson gson = new Gson();
                GetAddressResult.GetAddress getAddressResult = gson.fromJson(response.toString(), GetAddressResult.GetAddress.class);

                //Log.d("TAG", "response: " + getContactResult.success);

                head.setText(getAddressResult.data.nickName);
                name.setText(getAddressResult.data.name);
                surname.setText(getAddressResult.data.surname);
                provinceId = getAddressResult.data.cityId;
                province.setText(getAddressResult.data.cityName);
                districtId = getAddressResult.data.townId;
                district.setText(getAddressResult.data.townName);
                areaId = getAddressResult.data.areaId;
                area.setText(getAddressResult.data.areaName);
                address.setText(getAddressResult.data.addressText);
                phone.setText(getAddressResult.data.phone);

                final GetCityListRequest request = new GetCityListRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity)getActivity()).tokenResult.accessToken, "90");
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
                        GetCityListResult.GetCityList getCityListResult = gson.fromJson(response.toString(), GetCityListResult.GetCityList.class);

                        //Log.d("TAG", "response: " + getContactResult.success);

                        for (GetCityListResult.Data item: getCityListResult.data) {
                            provinceIds.add(item.id);
                            provinces.add(item.name);
                        }

                        setProvince();
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

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                headMenu = new MenuBuilder(getActivity());
                for (int i = 0; i < heads.size(); i++) {
                    headMenu.add(0, i, 0, heads.get(i));
                }
                BottomSheetMenuDialog dialog = new BottomSheetBuilder(getActivity(), R.style.AppTheme_BottomSheetDialog)
                        .expandOnStart(false)
                        .setMode(BottomSheetBuilder.MODE_LIST)
                        .addTitleItem("Trial")
                        .setMenu(headMenu)
                        .setItemClickListener(new BottomSheetItemClickListener() {
                            @Override
                            public void onBottomSheetItemClick(MenuItem item) {
                                Log.d("TAG", "onBottomSheetItemClick: getItemId: " + item.getItemId() + " getTitle: " + item.getTitle());

                                headSelect = item.getItemId();
                                head.setText(item.getTitle());
                            }
                        })
                        .createDialog();
                dialog.show();
            }
        });

        province.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                provinceMenu = new MenuBuilder(getActivity());
                for (int i = 0; i < provinces.size(); i++) {
                    provinceMenu.add(0, i, 0, provinces.get(i));
                }
                BottomSheetMenuDialog dialog = new BottomSheetBuilder(getActivity(), R.style.AppTheme_BottomSheetDialog)
                        .expandOnStart(false)
                        .setMode(BottomSheetBuilder.MODE_LIST)
                        .addTitleItem("Trial")
                        .setMenu(provinceMenu)
                        .setItemClickListener(new BottomSheetItemClickListener() {
                            @Override
                            public void onBottomSheetItemClick(MenuItem item) {
                                Log.d("TAG", "onBottomSheetItemClick: getItemId: " + item.getItemId() + " getTitle: " + item.getTitle());

                                provinceId = provinceIds.get(item.getItemId());
                                province.setText(provinces.get(item.getItemId()));

                                districtId = 0;
                                areaId = -1;

                                district.setText("");
                                area.setText("");

                                setProvince();
                            }
                        })
                        .createDialog();
                dialog.show();
            }
        });

        district.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                districtMenu = new MenuBuilder(getActivity());
                for (int i = 0; i < districts.size(); i++) {
                    districtMenu.add(0, i, 0, districts.get(i));
                }
                BottomSheetMenuDialog dialog = new BottomSheetBuilder(getActivity(), R.style.AppTheme_BottomSheetDialog)
                        .expandOnStart(false)
                        .setMode(BottomSheetBuilder.MODE_LIST)
                        .addTitleItem("Trial")
                        .setMenu(districtMenu)
                        .setItemClickListener(new BottomSheetItemClickListener() {
                            @Override
                            public void onBottomSheetItemClick(MenuItem item) {
                                Log.d("TAG", "onBottomSheetItemClick: getItemId: " + item.getItemId() + " getTitle: " + item.getTitle());

                                districtId = districtIds.get(item.getItemId());
                                district.setText(districts.get(item.getItemId()));

                                areaId = -1;

                                area.setText("");

                                setDistrict();
                            }
                        })
                        .createDialog();
                dialog.show();
            }
        });

        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                areaMenu = new MenuBuilder(getActivity());
                for (int i = 0; i < areas.size(); i++) {
                    areaMenu.add(0, i, 0, areas.get(i));
                }
                BottomSheetMenuDialog dialog = new BottomSheetBuilder(getActivity(), R.style.AppTheme_BottomSheetDialog)
                        .expandOnStart(false)
                        .setMode(BottomSheetBuilder.MODE_LIST)
                        .addTitleItem("Trial")
                        .setMenu(areaMenu)
                        .setItemClickListener(new BottomSheetItemClickListener() {
                            @Override
                            public void onBottomSheetItemClick(MenuItem item) {
                                Log.d("TAG", "onBottomSheetItemClick: getItemId: " + item.getItemId() + " getTitle: " + item.getTitle());

                                areaId = areaIds.get(item.getItemId());
                                area.setText(areas.get(item.getItemId()));
                            }
                        })
                        .createDialog();
                dialog.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (head.getText().toString() == "") {
                    showAlert("Başlık seçiniz!");
                }
                else if (name.getText().toString().isEmpty()) {
                    showAlert("Ad giriniz!");
                }
                else if (surname.getText().toString().isEmpty()) {
                    showAlert("Soyad giriniz!");
                }
                else if (province.getText().toString() == "") {
                    showAlert("İli seçiniz!");
                }
                else if (district.getText().toString() == "") {
                    showAlert("İlçeyi seçiniz!");
                }
                else if (area.getText().toString() == "" && areaIds.size() != 0) {
                    showAlert("Semt seçiniz!");
                }
                else if (address.getText().toString().isEmpty()) {
                    showAlert("Adres giriniz!");
                }
                else if (phone.getText().toString().isEmpty()) {
                    showAlert("Telefon numaranızı giriniz!");
                }
                else {
                    final GetContactRequest request = new GetContactRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity)getActivity()).tokenResult.accessToken);
                    Log.d("TAG", "request: " + request.getHeaders());
                    Log.d("TAG", "request: " + request.getParameters());
                    showProgress(true);
                    RequestQueue queue = Volley.newRequestQueue(getActivity());
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            showProgress(false);

                            Log.d("TAG", response.toString());

                            Gson gson = new Gson();
                            GetContactResult.GetContact getContactResult = gson.fromJson(response.toString(), GetContactResult.GetContact.class);

                            //Log.d("TAG", "response: " + getContactResult.success);

                            String areaIdString;
                            if (areaId == -1) {
                                areaIdString = "";
                            }
                            else {
                                areaIdString = String.valueOf(areaId);
                            }

                            final SaveAddressRequest request = new SaveAddressRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity)getActivity()).tokenResult.accessToken, ((AccountActivity) getActivity()).addressType, getContactResult.data.segments.get(0).contactId, head.getText().toString(), name.getText().toString(), surname.getText().toString(), 90, provinceId, province.getText().toString(), districtId, district.getText().toString(), areaIdString, "", "", address.getText().toString(), phone.getText().toString(), "", "", ((AccountActivity) getActivity()).addressId, "");
                            Log.d("TAG", "request: " + request.getHeaders());
                            Log.d("TAG", "request: " + request.getParameters());
                            showProgress(true);
                            RequestQueue queue = Volley.newRequestQueue(getActivity());
                            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(request.method, request.getURL(), request.getParameters(), new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    showProgress(false);

                                    Log.d("TAG", response.toString());

                                    Gson gson = new Gson();
                                    SaveAddressResult.SaveAddress saveAddressResult = gson.fromJson(response.toString(), SaveAddressResult.SaveAddress.class);

                                    //Log.d("TAG", "response: " + getContactResult.success);

                                    if (saveAddressResult.success) {
                                        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                                        alert.setTitle("Tebrikler!");
                                        alert.setMessage("Adres güncellendi!");
                                        alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
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
                                        alert.setTitle("Hata!");
                                        alert.setMessage("Adres güncellenmedi!");
                                        alert.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
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
            }
        });

        return view;
    }

    void setProvince() {
        districtIds = new ArrayList<Integer>();
        districts = new ArrayList<String>();

        areaIds = new ArrayList<Integer>();
        areas = new ArrayList<String>();

        final GetTownListRequest request = new GetTownListRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity)getActivity()).tokenResult.accessToken, provinceId);
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
                GetCityListResult.GetCityList getCityListResult = gson.fromJson(response.toString(), GetCityListResult.GetCityList.class);

                //Log.d("TAG", "response: " + getContactResult.success);

                for (GetCityListResult.Data item: getCityListResult.data) {
                    districtIds.add(item.id);
                    districts.add(item.name);
                }

                setDistrict();
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

    void setDistrict() {
        areaIds = new ArrayList<Integer>();
        areas = new ArrayList<String>();

        final GetAreaListRequest request = new GetAreaListRequest(((AccountActivity) getActivity()).tokenResult.tokenType, ((AccountActivity)getActivity()).tokenResult.accessToken, districtId);
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
                GetAreaListResult.GetAreaList getAreaListResult = gson.fromJson(response.toString(), GetAreaListResult.GetAreaList.class);

                //Log.d("TAG", "response: " + getContactResult.success);

                for (GetAreaListResult.Data item: getAreaListResult.data) {
                    areaIds.add(item.id);
                    areas.add(item.name);
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
