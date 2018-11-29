package tr.com.rnd.master;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import tr.com.rnd.master.Adapters.BannerAdapter;
import tr.com.rnd.master.Adapters.ExpandableListAdapter;
import tr.com.rnd.master.Adapters.FeatureAdapter;
import tr.com.rnd.master.Model.CellData;
import tr.com.rnd.master.Model.Result.HomePageResult;
import tr.com.rnd.master.Model.Result.TokenResult;
import tr.com.rnd.master.Model.interfaces.ShowProgress;

public class HomeActivity extends AppCompatActivity implements ShowProgress, NavigationView.OnNavigationItemSelectedListener {
    View progress;
    ViewPager viewPager;
    TabLayout indicator;
    RecyclerView table;
    NavigationView navigationView;
    ExpandableListView expandableListView;

    String homePage;
    HomePageResult.HomePage homePageResult;
    String token;
    TokenResult.Token tokenResult;
    String emailAddress;

    List<Bitmap> slideHomeData;

    Boolean openLogin;
    String open;

    final int LOGIN_RESULT = 0;
    final int ACCOUNT_RESULT = 1;
    final int PRODUCTS_RESULT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homePage = getIntent().getStringExtra(HomePageResult.class.getName());
        token = getIntent().getStringExtra(TokenResult.class.getName());
        emailAddress = getIntent().getStringExtra("emailAddress");

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(homePage);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        homePageResult = gson.fromJson(jsonObject.toString(), HomePageResult.HomePage.class);

        if (token != null) {
            try {
                jsonObject = new JSONObject(token);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            tokenResult = gson.fromJson(jsonObject.toString(), TokenResult.Token.class);
            Log.d("Token", "Token: " + tokenResult.accessToken);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        openLogin = false;
        open = "";

        /*final Drawable upArrow = getResources().getDrawable(R.drawable.basket);
        upArrow.setColorFilter(Color.parseColor("#FF0000"), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);*/

        progress = findViewById(R.id.progress);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        indicator = (TabLayout) findViewById(R.id.indicator);

        table = (RecyclerView) findViewById(R.id.table);
        table.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        table.setHasFixedSize(true);
        table.setAdapter(new BannerAdapter(getApplicationContext(), homePageResult.data.banner));
        table.setFocusable(false);

        slideHome();

        /* Set custom font programatic
        Typeface typeface = ResourcesCompat.getFont(this, R.font.beautiful_lovers);
        textView.setTypeface(typeface); */

        ////////////////////////////////////////////////////////////// DL
        expandableListView = findViewById(R.id.expandableListView);
        leftMenu();
        //////////////////////////////////////////////////////////////

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cancel:
                        Log.d("TAG", "onNavigationItemSelected: Ana Sayfa");
                        return true;

                    case R.id.myFavorites:
                        Log.d("TAG", "onNavigationItemSelected: Favorilerim");
                        return true;

                    case R.id.myAccount:
                        if (tokenResult != null) {
                            Intent intent = new Intent(getApplicationContext(), AccountActivity.class);
                            intent.putExtra(TokenResult.class.getName(), token);
                            startActivityForResult(intent, ACCOUNT_RESULT);
                        }
                        else {
                            open = "Account";

                            startActivityForResult(new Intent(getApplicationContext(), LoginActivity.class), LOGIN_RESULT);
                        }

                        return true;
                }

                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.showBasket) {
            if (tokenResult != null) {
                Intent intent = new Intent(getBaseContext(), BasketActivity.class);
                intent.putExtra(TokenResult.class.getName(), token);
                intent.putExtra("emailAddress", emailAddress);
                startActivity(intent);
            }
            else {
                open = "Basket";

                startActivityForResult(new Intent(getApplicationContext(), LoginActivity.class), LOGIN_RESULT);
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        /*if (id == menu.getItem(1).getSubMenu().getItem(1).getItemId()) {
            Log.d("TAG", "onNavigationItemSelected: OK");
        }
        else {
            Log.d("TAG", "onNavigationItemSelected: NO");
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
                    token = data.getStringExtra(TokenResult.class.getName());

                    if (token == null) {
                        tokenResult = null;
                    }

                    openLogin = data.getBooleanExtra("openLogin", false);
                }

                break;

            case PRODUCTS_RESULT:
                if (resultCode == Activity.RESULT_OK) {
                    token = data.getStringExtra(TokenResult.class.getName());

                    if (token == null) {
                        tokenResult = null;
                    }
                    else {
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(token);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Gson gson = new Gson();
                        tokenResult = gson.fromJson(jsonObject.toString(), TokenResult.Token.class);
                        //Log.d("TAG", "onActivityResult: " + tokenResult.accessToken);
                        emailAddress = data.getStringExtra("emailAddress");
                    }

                    openLogin = data.getBooleanExtra("openLogin", false);
                }

                break;

        }
    }

    void slideHome() {
        showProgress(true);

        slideHomeData = new ArrayList<Bitmap>();

        RequestQueue queueImage = Volley.newRequestQueue(getApplicationContext());
        for (HomePageResult.Slider slider: homePageResult.data.slider) {
            //Log.d("TAG", "slideHome: " + slider.getSmallImage());
            ImageRequest imageRequest = new ImageRequest(slider.getSmallImage(), new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap data) {
                    slideHomeData.add(data);
                }
            }, 0, 0, null, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("TAG", "onErrorResponse: " + error.networkResponse.statusCode);
                }
            });
            queueImage.add(imageRequest);
        }

        final int[] queue = {0};
        queueImage.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<ImageRequest>() {
            @Override
            public void onRequestFinished(Request<ImageRequest> request) {
                queue[0]++;
                if (queue[0] == homePageResult.getData().getSlider().size()) {
                    showProgress(false);

                    viewPager.setAdapter(new FeatureAdapter(getApplicationContext(), slideHomeData, homePageResult.data.slider));
                    indicator.setupWithViewPager(viewPager, true);

                    Timer timer = new Timer();
                    timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);

                    Log.d("TAG", "onRequestFinished: " + homePageResult.data.getSlider().get(0).getTitle());
                }
            }
        });
    }

    private class SliderTimer extends TimerTask {
        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < homePageResult.getData().getSlider().size() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
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

    private void leftMenu() {
        final List<CellData> headerList = new ArrayList<>();
        final HashMap<CellData, List<CellData>> childList = new HashMap<>();
        for (int i = 0; i < homePageResult.data.leftMenu.size(); i++) {
            if (homePageResult.data.leftMenu.get(i).parentFields.size() == 0) {
                CellData cellData = new CellData(homePageResult.data.leftMenu.get(i).field.name, true, false, homePageResult.data.leftMenu.get(i).field.value);
                headerList.add(cellData);
                if (!cellData.hasChildren) {
                    childList.put(cellData, null);
                }
            }
            else {
                CellData cellData = new CellData("+ " + homePageResult.data.leftMenu.get(i).field.name, true, true, "");
                headerList.add(cellData);
                List<CellData> childModelsList = new ArrayList<>();
                for (int j = 0; j < homePageResult.data.leftMenu.get(i).parentFields.size(); j++) {
                    CellData childModel = new CellData(homePageResult.data.leftMenu.get(i).parentFields.get(j).name, false, false, homePageResult.data.leftMenu.get(i).parentFields.get(j).value);
                    childModelsList.add(childModel);
                }
                if (cellData.hasChildren) {
                    childList.put(cellData, childModelsList);
                }
            }
        }

        ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {
                        Log.d("TAG", "onGroupClick: " + headerList.get(groupPosition).value);

                        Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                        intent.putExtra(TokenResult.class.getName(), token);
                        intent.putExtra("emailAddress", emailAddress);
                        intent.putExtra("url", headerList.get(groupPosition).value);
                        startActivityForResult(intent, PRODUCTS_RESULT);

                        onBackPressed();
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (childList.get(headerList.get(groupPosition)) != null) {
                    CellData cellData = childList.get(headerList.get(groupPosition)).get(childPosition);
                    if (cellData.value.length() > 0) {
                        Intent intent = new Intent(getApplicationContext(), ProductsActivity.class);
                        intent.putExtra(TokenResult.class.getName(), token);
                        intent.putExtra("emailAddress", emailAddress);
                        intent.putExtra("url", cellData.value);
                        startActivity(intent);

                        onBackPressed();
                    }
                }

                return false;
            }
        });
    }
}
