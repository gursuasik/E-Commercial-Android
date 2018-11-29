package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

import tr.com.rnd.master.Model.Result.HomePageResult;
import tr.com.rnd.master.R;

/**
 * Created by gursuasik on 25/11/2017.
 */

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {
    Context context;
    List<HomePageResult.Banner> banner;

    public BannerAdapter(Context context, List<HomePageResult.Banner> banner) {
        this.context = context;
        this.banner = banner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_banner, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final String url = banner.get(position).field.value;
        Log.d("TAG", "onBindViewHolder: " + url);
        RequestQueue queue = Volley.newRequestQueue(context);
        ImageRequest ir = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                holder.imageBanner.setImageBitmap(response);
                holder.value.setText(banner.get(position).parentFields.get(0).value);
            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //errorImage.error(productName, error.networkResponse.statusCode, "Android", "No Post");
            }
        });
        queue.add(ir);
    }

    @Override
    public int getItemCount() {
        return banner.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView value;
        AppCompatImageView imageBanner;

        public ViewHolder(View itemView) {
            super(itemView);

            value = (AppCompatTextView) itemView.findViewById(R.id.value);
            imageBanner = (AppCompatImageView) itemView.findViewById(R.id.imageBanner);
        }
    }
}