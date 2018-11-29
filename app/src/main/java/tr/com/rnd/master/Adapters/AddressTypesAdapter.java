package tr.com.rnd.master.Adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tr.com.rnd.master.R;

public class AddressTypesAdapter extends RecyclerView.Adapter<AddressTypesAdapter.ViewHolder> {
    List<String> tableData;

    AddressTypesAdapterListener addressTypesAdapterListener;

    public AddressTypesAdapter(List<String> tableData, AddressTypesAdapterListener addressTypesAdapterListener) {
        this.tableData = tableData;
        this.addressTypesAdapterListener = addressTypesAdapterListener;
    }

    @Override
    public AddressTypesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_address_types, parent, false);
        AddressTypesAdapter.ViewHolder viewHolder = new AddressTypesAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AddressTypesAdapter.ViewHolder holder, final int position) {
        holder.name.setText(tableData.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addressTypesAdapterListener.addressTypesAdapterListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tableData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (AppCompatTextView) itemView.findViewById(R.id.name);
        }
    }

    public interface AddressTypesAdapterListener {
        void addressTypesAdapterListener(int position);
    }
}
