package tr.com.rnd.master.Adapters;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
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

import tr.com.rnd.master.Model.Config.Config;
import tr.com.rnd.master.Model.Result.SearchResult;
import tr.com.rnd.master.ProductDescriptionFragment;
import tr.com.rnd.master.ProductsActivity;
import tr.com.rnd.master.R;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    Context context;
    List<SearchResult.Product> products;

    public ProductsAdapter(Context context, List<SearchResult.Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_products, parent, false);
        ProductsAdapter.ViewHolder viewHolder = new ProductsAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ProductsAdapter.ViewHolder holder, final int position) {
        showProgress(holder.progress, true);
        holder.productName.setText(products.get(position).name);
        holder.productPrice.setText(String.format("%.2f TL", products.get(position).price));

        final String url = new Config().PRODUCT_IMAGE_URL + products.get(position).imageList.get(0);
        Log.d("TAG", "onBindViewHolder: " + url);
        RequestQueue queue = Volley.newRequestQueue(context);
        ImageRequest ir = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                showProgress(holder.progress, false);

                holder.productImage.setImageBitmap(response);
            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                showProgress(holder.progress, false);
            }
        });
        queue.add(ir);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ProductsActivity) context).productCode = products.get(position).productCode;
                ((ProductsActivity) context).loadFragment(new ProductDescriptionFragment());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        View progress;
        AppCompatImageView productImage;
        AppCompatTextView productName;
        AppCompatTextView productPrice;

        public ViewHolder(View itemView) {
            super(itemView);

            progress = itemView.findViewById(R.id.progress);
            productImage = (AppCompatImageView) itemView.findViewById(R.id.productImage);
            productName = (AppCompatTextView) itemView.findViewById(R.id.productName);
            productPrice = (AppCompatTextView) itemView.findViewById(R.id.productPrice);
        }
    }

    public void showProgress(final View progress, final boolean show) {
        progress.setVisibility(show ? View.VISIBLE : View.GONE);

        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow for very easy animations. If available, use these APIs to fade-in the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = context.getResources().getInteger(android.R.integer.config_shortAnimTime);

            progress.animate().setDuration(shortAnimTime).alpha(show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progress.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        }
    }
}
