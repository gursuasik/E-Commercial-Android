package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tr.com.rnd.master.AccountFragment;
import tr.com.rnd.master.R;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {
    Context context;
    List<AccountFragment.Account> tableData;

    AccountAdapterListener paymentTypesAdapterListener;

    public AccountAdapter(Context context, List<AccountFragment.Account> tableData, AccountAdapterListener paymentTypesAdapterListener) {
        this.context = context;
        this.tableData = tableData;
        this.paymentTypesAdapterListener = paymentTypesAdapterListener;
    }

    @Override
    public AccountAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_account, parent, false);
        AccountAdapter.ViewHolder viewHolder = new AccountAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AccountAdapter.ViewHolder holder, final int position) {
        holder.imageName.setImageResource(context.getResources().getIdentifier(tableData.get(position).image, "drawable", context.getPackageName()));
        holder.name.setText(tableData.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paymentTypesAdapterListener.accountAdapterListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tableData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageName;
        AppCompatTextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            imageName = (AppCompatImageView) itemView.findViewById(R.id.imageName);
            name = (AppCompatTextView) itemView.findViewById(R.id.name);
        }
    }

    public interface AccountAdapterListener {
        void accountAdapterListener(int position);
    }
}
