package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

import tr.com.rnd.master.Model.Result.GetOrderBasketResult;
import tr.com.rnd.master.R;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.ViewHolder> {
    Context context;
    List<GetOrderBasketResult.Detail> details;

    public BasketAdapter(Context context, List<GetOrderBasketResult.Detail> details) {
        this.context = context;
        this.details = details;
    }

    @Override
    public BasketAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_basket, parent, false);
        BasketAdapter.ViewHolder viewHolder = new BasketAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BasketAdapter.ViewHolder holder, final int position) {
        RequestQueue queue = Volley.newRequestQueue(context);
        ImageRequest ir = new ImageRequest(details.get(position).imagePath, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                holder.imageProduct.setImageBitmap(response);
            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //errorImage.error(productName, error.networkResponse.statusCode, "Android", "No Post");
            }
        });
        queue.add(ir);

        holder.name.setText(details.get(position).name);
        holder.price.setText(String.format("%.2f TL", Double.valueOf(details.get(position).price)));
        holder.color.setText(details.get(position).color);
        holder.body.setText(details.get(position).body);
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout viewForeground;
        AppCompatImageView imageProduct;
        AppCompatTextView name;
        AppCompatTextView price;
        AppCompatTextView color;
        AppCompatTextView body;

        public ViewHolder(View itemView) {
            super(itemView);

            viewForeground = (LinearLayout) itemView.findViewById(R.id.view_foreground);
            imageProduct = (AppCompatImageView) itemView.findViewById(R.id.imageProduct);
            name = (AppCompatTextView) itemView.findViewById(R.id.name);
            price = (AppCompatTextView) itemView.findViewById(R.id.price);
            color = (AppCompatTextView) itemView.findViewById(R.id.color);
            body = (AppCompatTextView) itemView.findViewById(R.id.body);
        }
    }

    public void removeItem(int position) {
        details.remove(position);

        notifyItemRemoved(position);
    }
}
