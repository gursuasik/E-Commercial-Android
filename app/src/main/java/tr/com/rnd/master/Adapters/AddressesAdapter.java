package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tr.com.rnd.master.Model.Result.GetAddressListResult;
import tr.com.rnd.master.R;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {
    Context context;
    GetAddressListResult.GetAddressList getAddressListResult;

    AddressesAdapterListener addressesAdapterListener;

    public AddressesAdapter(Context context, GetAddressListResult.GetAddressList getAddressListResult, AddressesAdapterListener addressesAdapterListener) {
        this.context = context;
        this.getAddressListResult = getAddressListResult;
        this.addressesAdapterListener = addressesAdapterListener;
    }

    @Override
    public AddressesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_addresses, parent, false);
        AddressesAdapter.ViewHolder viewHolder = new AddressesAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AddressesAdapter.ViewHolder holder, final int position) {
        holder.nickName.setText(getAddressListResult.data.get(position).nickName);
        holder.addressText.setText(getAddressListResult.data.get(position).addressText);
        holder.area.setText(getAddressListResult.data.get(position).townName + " / " + getAddressListResult.data.get(position).cityName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addressesAdapterListener.addressesAdapterListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getAddressListResult.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView nickName;
        AppCompatTextView addressText;
        AppCompatTextView area;

        public ViewHolder(View itemView) {
            super(itemView);

            nickName = (AppCompatTextView) itemView.findViewById(R.id.nickName);
            addressText = (AppCompatTextView) itemView.findViewById(R.id.addressText);
            area = (AppCompatTextView) itemView.findViewById(R.id.area);
        }
    }

    public interface AddressesAdapterListener {
        void addressesAdapterListener(int position);
    }
}
