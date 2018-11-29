package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tr.com.rnd.master.R;

public class ProductDescriptionAdapter extends RecyclerView.Adapter<ProductDescriptionAdapter.ViewHolder> {
    Context context;
    List<String> randomTexts;

    public ProductDescriptionAdapter(Context context, List<String> randomTexts) {
        this.context = context;
        this.randomTexts = randomTexts;
    }

    @Override
    public ProductDescriptionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_product_description, parent, false);
        ProductDescriptionAdapter.ViewHolder viewHolder = new ProductDescriptionAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ProductDescriptionAdapter.ViewHolder holder, final int position) {
        holder.headerLabel.setText("Ürün Açıklaması");
        if (position == 1) {
            holder.headerLabel.setText("Diğer Özellikler");
        }
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        //    holder.descriptionLabel.setText(Html.fromHtml(randomTexts.get(position), Html.FROM_HTML_MODE_COMPACT));
        //} else {
            holder.descriptionLabel.setText(Html.fromHtml(randomTexts.get(position)));
        //}
    }

    @Override
    public int getItemCount() {
        return randomTexts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView headerLabel;
        AppCompatTextView descriptionLabel;

        public ViewHolder(View itemView) {
            super(itemView);

            headerLabel = (AppCompatTextView) itemView.findViewById(R.id.headerLabel);
            descriptionLabel = (AppCompatTextView) itemView.findViewById(R.id.descriptionLabel);
        }
    }
}
