package tr.com.rnd.master;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tr.com.rnd.master.Adapters.AccountAdapter;
import tr.com.rnd.master.Model.Config.DBHelper;
import tr.com.rnd.master.Model.Result.TokenResult;

public class AccountFragment extends Fragment {
    RecyclerView table;

    List<Account> tableData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        getActivity().findViewById(R.id.appBar).setVisibility(View.GONE);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("Hoş Geldin!");
        toolbar.setTitleTextColor(Color.WHITE);
        ((AccountActivity) getActivity()).setSupportActionBar(toolbar);

        setHasOptionsMenu(true);

        table = (RecyclerView) view.findViewById(R.id.table);
        table.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        table.setHasFixedSize(true);

        tableData = new ArrayList<Account>();
        tableData.add(new Account("detail", "Bilgilerim"));
        tableData.add(new Account("address", "Adreslerim"));
        tableData.add(new Account("package1", "Siparişlerim"));
        tableData.add(new Account("heart2", "Favorilerim"));
        tableData.add(new Account("tag", "Kuponlarım"));

        table.setAdapter(new AccountAdapter(getActivity(), tableData, accountAdapterListener));

        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.cancel:
                        Intent intent = new Intent();
                        intent.putExtra(TokenResult.class.getName(), ((AccountActivity) getActivity()).token);
                        intent.putExtra("openLogin", false);
                        getActivity().setResult(Activity.RESULT_OK, intent);
                        getActivity().finish();
                        return true;

                    case R.id.myFavorites:
                        Log.d("TAG", "onNavigationItemSelected: myFavorites");
                        return true;

                    case R.id.myAccount:
                        Log.d("TAG", "onNavigationItemSelected: myAccount");
                        return true;
                }

                return false;
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.account, menu);
        super.onCreateOptionsMenu(menu, inflater);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout) {
            new DBHelper(getActivity().getApplicationContext()).deleteUser();

            String token = null;
            Intent intent = new Intent();
            intent.putExtra(TokenResult.class.getName(), token);
            intent.putExtra("openLogin", false);
            getActivity().setResult(Activity.RESULT_OK, intent);
            getActivity().finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    AccountAdapter.AccountAdapterListener accountAdapterListener = new AccountAdapter.AccountAdapterListener() {
        @Override
        public void accountAdapterListener(final int position) {
            Log.d("TAG", "accountAdapterListener: " + position);

            switch (position) {
                case 0:
                    ((AccountActivity) getActivity()).loadFragment(new UpdateContactFragment());

                    break;

                case 1:
                    ((AccountActivity) getActivity()).loadFragment(new AddressTypesFragment());

                    break;

                case 2:
                    ((AccountActivity) getActivity()).loadFragment(new GetOrdersFragment());

                    break;

                case 4:
                    ((AccountActivity) getActivity()).loadFragment(new GetDiscountCouponListFragment());

                    break;

                default:
            }
        }
    };

    public class Account {
        public String image, name;

        public Account(String image, String name) {
            this.image = image;
            this.name = name;
        }
    }
}
