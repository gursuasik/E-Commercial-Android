package tr.com.rnd.master;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import tr.com.rnd.master.Adapters.AddressTypesAdapter;

public class AddressTypesFragment extends Fragment {
    RecyclerView table;

    List<String> tableData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address_types, container, false);

        getActivity().findViewById(R.id.appBar).setVisibility(View.VISIBLE);

        table = (RecyclerView) view.findViewById(R.id.table);
        table.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        table.setHasFixedSize(true);

        tableData = new ArrayList<String>();
        tableData.add("Fatura Adresim");
        tableData.add("Teslimat Adresim");

        table.setAdapter(new AddressTypesAdapter(tableData, accountAdapterListener));

        return view;
    }

    AddressTypesAdapter.AddressTypesAdapterListener accountAdapterListener = new AddressTypesAdapter.AddressTypesAdapterListener() {
        @Override
        public void addressTypesAdapterListener(final int position) {
            Log.d("TAG", "addressTypesAdapterListener: " + position);

            ((AccountActivity) getActivity()).addressType = position + 1;

            ((AccountActivity) getActivity()).loadFragment(new AccountAddressFragment());
        }
    };
}
