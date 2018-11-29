package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tr.com.rnd.master.PaymentTypesFragment;
import tr.com.rnd.master.R;

public class PaymentTypesAdapter extends RecyclerView.Adapter<PaymentTypesAdapter.ViewHolder> {
    Context context;
    PaymentTypesFragment.PaymentTypesCell[] paymentTypeData;

    PaymentTypesAdapterListener paymentTypesAdapterListener;

    public PaymentTypesAdapter(Context context, PaymentTypesFragment.PaymentTypesCell[] paymentTypeData, PaymentTypesAdapterListener fastDeliveryAdapterListener) {
        this.context = context;
        this.paymentTypeData = paymentTypeData;
        this.paymentTypesAdapterListener = fastDeliveryAdapterListener;
    }

    @Override
    public PaymentTypesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_payment_types, parent, false);
        PaymentTypesAdapter.ViewHolder viewHolder = new PaymentTypesAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PaymentTypesAdapter.ViewHolder holder, final int position) {
        holder.paymentImageName.setImageResource(context.getResources().getIdentifier(paymentTypeData[position].image, "drawable", context.getPackageName()));
        holder.name.setText(paymentTypeData[position].name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paymentTypesAdapterListener.paymentTypesAdapterListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return paymentTypeData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView paymentImageName;
        AppCompatTextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            paymentImageName = (AppCompatImageView) itemView.findViewById(R.id.paymentImageName);
            name = (AppCompatTextView) itemView.findViewById(R.id.name);
        }
    }

    public interface PaymentTypesAdapterListener {
        void paymentTypesAdapterListener(int position);
    }
}
