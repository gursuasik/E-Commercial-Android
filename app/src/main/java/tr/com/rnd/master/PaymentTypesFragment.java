package tr.com.rnd.master;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tr.com.rnd.master.Adapters.PaymentTypesAdapter;

public class PaymentTypesFragment extends Fragment {
    RecyclerView table;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment_types, container, false);

        ((BasketActivity) getActivity()).paymentTypeData = new PaymentTypesCell[] {new PaymentTypesCell("visa", "Kredi Kartı"), new PaymentTypesCell("bkm", "BKM Express"), new PaymentTypesCell("havale", "Havale")};

        table = (RecyclerView) view.findViewById(R.id.table);
        table.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        table.setHasFixedSize(true);
        table.setAdapter(new PaymentTypesAdapter(getActivity(), ((BasketActivity) getActivity()).paymentTypeData, paymentTypesAdapterListener));

        return view;
    }

    PaymentTypesAdapter.PaymentTypesAdapterListener paymentTypesAdapterListener = new PaymentTypesAdapter.PaymentTypesAdapterListener() {
        @Override
        public void paymentTypesAdapterListener(final int position) {
            Log.d("TAG", "paymentTypesAdapterListener: " + position);
            ((BasketActivity) getActivity()).selectPaymentTypeIndex = position;

            ((BasketActivity) getActivity()).loadFragment(new CreditCardInfosFragment());
        }
    };

    public class PaymentTypesCell {
        public String image;
        public String name;

        public PaymentTypesCell(String image, String name) {
            this.image = image;
            this.name = name;
        }
    }
}
