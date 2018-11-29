package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tr.com.rnd.master.BasketActivity;
import tr.com.rnd.master.Model.Result.GetPaymentViewerResult;
import tr.com.rnd.master.OrderResultFragment;
import tr.com.rnd.master.R;

public class InstallmentsAdapter extends RecyclerView.Adapter<InstallmentsAdapter.ViewHolder> {
    Context context;
    GetPaymentViewerResult.GetPaymentViewer getPaymentViewerResult;

    public InstallmentsAdapter(Context context, GetPaymentViewerResult.GetPaymentViewer getPaymentViewerResult) {
        this.context = context;
        this.getPaymentViewerResult = getPaymentViewerResult;
    }

    @Override
    public InstallmentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_installments, parent, false);
        InstallmentsAdapter.ViewHolder viewHolder = new InstallmentsAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final InstallmentsAdapter.ViewHolder holder, final int position) {
        int inst = getPaymentViewerResult.data.creditCardBankList.get(0).installmentList.get(position).installment;
        holder.name.setText(inst + " Taksit");
        if (getPaymentViewerResult.data.creditCardBankList.get(0).installmentList.get(position).installment == 1) {
            holder.name.setText("Tek Çekim");
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int inst = getPaymentViewerResult.data.creditCardBankList.get(0).installmentList.get(position).installment;
                ((BasketActivity) context).cardPaymentRequest.installmentCount = inst;

                ((BasketActivity) context).loadFragment(new OrderResultFragment());
            }
        });
    }

    @Override
    public int getItemCount() {
        return getPaymentViewerResult.data.creditCardBankList.get(0).installmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (AppCompatTextView) itemView.findViewById(R.id.name);
        }
    }
}
