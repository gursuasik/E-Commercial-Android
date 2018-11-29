package tr.com.rnd.master.Adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tr.com.rnd.master.FastDeliveryFragment;
import tr.com.rnd.master.R;

public class FastDeliveryAdapter extends RecyclerView.Adapter<FastDeliveryAdapter.ViewHolder> {
    List<FastDeliveryFragment.FastDelivery> fastDeliverys;

    FastDeliveryAdapterListener fastDeliveryAdapterListener;

    public FastDeliveryAdapter(List<FastDeliveryFragment.FastDelivery> fastDeliverys, FastDeliveryAdapterListener fastDeliveryAdapterListener) {
        this.fastDeliverys = fastDeliverys;
        this.fastDeliveryAdapterListener = fastDeliveryAdapterListener;
    }

    @Override
    public FastDeliveryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_fast_delivery, parent, false);
        FastDeliveryAdapter.ViewHolder viewHolder = new FastDeliveryAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final FastDeliveryAdapter.ViewHolder holder, final int position) {
        holder.name.setText(fastDeliverys.get(position).name);
        holder.note.setText(fastDeliverys.get(position).note);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fastDeliveryAdapterListener.fastDeliveryAdapterListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return fastDeliverys.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView name;
        AppCompatTextView note;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (AppCompatTextView) itemView.findViewById(R.id.name);
            note = (AppCompatTextView) itemView.findViewById(R.id.note);
        }
    }

    public interface FastDeliveryAdapterListener {
        void fastDeliveryAdapterListener(int position);
    }
}
