package tr.com.rnd.master.Adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import tr.com.rnd.master.Model.Result.GetAddressListResult;
import tr.com.rnd.master.R;

public class AccountAddressAdapter extends RecyclerView.Adapter<AccountAddressAdapter.ViewHolder> {
    GetAddressListResult.GetAddressList getAddressListResult;

    AccountAddressAdapterListener AccountAddressAdapterRequestListener;

    public AccountAddressAdapter(GetAddressListResult.GetAddressList getAddressListResult, AccountAddressAdapterListener AccountAddressAdapterListener) {
        this.getAddressListResult = getAddressListResult;
        this.AccountAddressAdapterRequestListener = AccountAddressAdapterListener;
    }

    @Override
    public AccountAddressAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_account_address, parent, false);
        AccountAddressAdapter.ViewHolder viewHolder = new AccountAddressAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AccountAddressAdapter.ViewHolder holder, final int position) {
        holder.nickName.setText(getAddressListResult.data.get(position).nickName);
        holder.addressText.setText(getAddressListResult.data.get(position).addressText);
        holder.area.setText(getAddressListResult.data.get(position).townName + " / " + getAddressListResult.data.get(position).cityName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountAddressAdapterRequestListener.accountAddressAdapterListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getAddressListResult.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout viewForeground;
        AppCompatTextView nickName;
        AppCompatTextView addressText;
        AppCompatTextView area;

        public ViewHolder(View itemView) {
            super(itemView);

            viewForeground = (LinearLayout) itemView.findViewById(R.id.view_foreground);
            nickName = (AppCompatTextView) itemView.findViewById(R.id.nickName);
            addressText = (AppCompatTextView) itemView.findViewById(R.id.addressText);
            area = (AppCompatTextView) itemView.findViewById(R.id.area);
        }
    }

    public interface AccountAddressAdapterListener {
        void accountAddressAdapterListener(int position);
    }

    public void removeItem(int position) {
        getAddressListResult.data.remove(position);

        notifyItemRemoved(position);
    }
}
