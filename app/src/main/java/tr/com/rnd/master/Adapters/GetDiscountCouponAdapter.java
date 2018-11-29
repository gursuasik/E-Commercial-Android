package tr.com.rnd.master.Adapters;

import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import tr.com.rnd.master.Model.Result.GetDiscountCouponListResult;
import tr.com.rnd.master.R;

public class GetDiscountCouponAdapter extends RecyclerView.Adapter<GetDiscountCouponAdapter.ViewHolder> {
    List<GetDiscountCouponListResult.Data> data;

    public GetDiscountCouponAdapter(List<GetDiscountCouponListResult.Data> data) {
        this.data = data;
    }

    @Override
    public GetDiscountCouponAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_get_discount_coupon_list, parent, false);
        GetDiscountCouponAdapter.ViewHolder viewHolder = new GetDiscountCouponAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final GetDiscountCouponAdapter.ViewHolder holder, final int position) {
        holder.code.setText(data.get(position).code);

        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
        String date = null;

        try {
            date = simpleDateFormat1.format(simpleDateFormat0.parse(data.get(position).startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.startDate.setText(date);

        try {
            date = simpleDateFormat1.format(simpleDateFormat0.parse(data.get(position).endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.endDate.setText(date);

        holder.discountPrice.setText(String.format("%.2f TL", data.get(position).discountPrice));

        holder.isValid.setText("Geçersiz");
        if (data.get(position).isValid) {
            holder.isValid.setText("Geçerli");
            holder.isValid.setTextColor(Color.argb(255,40,211,108));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView code;
        AppCompatTextView startDate;
        AppCompatTextView endDate;
        AppCompatTextView discountPrice;
        AppCompatTextView isValid;

        public ViewHolder(View itemView) {
            super(itemView);

            code = (AppCompatTextView) itemView.findViewById(R.id.code);
            startDate = (AppCompatTextView) itemView.findViewById(R.id.startDate);
            endDate = (AppCompatTextView) itemView.findViewById(R.id.endDate);
            discountPrice = (AppCompatTextView) itemView.findViewById(R.id.discountPrice);
            isValid = (AppCompatTextView) itemView.findViewById(R.id.isValid);
        }
    }

    public interface GetOrdersAdapterListener {
        void getOrdersAdapterListener(int position);
    }
}
