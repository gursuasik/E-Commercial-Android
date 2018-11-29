package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tr.com.rnd.master.Model.Body;
import tr.com.rnd.master.R;

public class BodyCollectionAdapter extends RecyclerView.Adapter<BodyCollectionAdapter.ViewHolder> {
    Context context;
    List<Body> bodyData;
    int width;

    BodyCollectionAdapterListener bodyCollectionAdapterListener;

    public BodyCollectionAdapter(Context context, List<Body> bodyData, BodyCollectionAdapterListener bodyCollectionAdapterListener) {
        this.context = context;
        this.bodyData = bodyData;
        this.bodyCollectionAdapterListener = bodyCollectionAdapterListener;
    }

    @Override
    public BodyCollectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_body_collection, parent, false);
        BodyCollectionAdapter.ViewHolder viewHolder = new BodyCollectionAdapter.ViewHolder(view);

        width = ((RecyclerView) parent).getWidth();
        Log.d("TAG", "onCreateViewHolder: " + width);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BodyCollectionAdapter.ViewHolder holder, final int position) {
        holder.bodyButton.setText(bodyData.get(position).name);

        int devicewidth = width / getItemCount();
        holder.itemView.getLayoutParams().width = devicewidth;

        holder.bodyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bodyCollectionAdapterListener.bodyCountOpen(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bodyData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton bodyButton;

        public ViewHolder(View itemView) {
            super(itemView);

            bodyButton = (AppCompatButton) itemView.findViewById(R.id.bodyButton);
        }
    }

    public interface BodyCollectionAdapterListener {
        void bodyCountOpen(int item_id);
    }
}
