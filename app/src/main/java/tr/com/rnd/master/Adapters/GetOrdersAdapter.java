package tr.com.rnd.master.Adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import tr.com.rnd.master.Model.Result.GetOrdersResult;
import tr.com.rnd.master.R;

public class GetOrdersAdapter extends RecyclerView.Adapter<GetOrdersAdapter.ViewHolder> {
    GetOrdersResult.GetOrders getOrdersResult;

    GetOrdersAdapterListener getOrdersAdapterListener;

    public GetOrdersAdapter(GetOrdersResult.GetOrders getOrdersResult, GetOrdersAdapterListener getOrdersAdapterListener) {
        this.getOrdersResult = getOrdersResult;
        this.getOrdersAdapterListener = getOrdersAdapterListener;
    }

    @Override
    public GetOrdersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_get_orders, parent, false);
        GetOrdersAdapter.ViewHolder viewHolder = new GetOrdersAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final GetOrdersAdapter.ViewHolder holder, final int position) {
        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String data = null;
        try {
            data = simpleDateFormat1.format(simpleDateFormat0.parse(getOrdersResult.data.get(position).saleCreateDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String status;
        switch (getOrdersResult.data.get(position).status) {
            case 1:
                status = "Ödeme Bekliyor";

                break;

            case 2:
                status = "Stok Bekliyor";

                break;

            case 3:
                status = "Fatura Kes";

                break;

            case 4:
                status = "Kargo Gönder";

                break;

            case 5:
                status = "Sipariş Tamamlandı";

                break;

            case 6:
                status = "Ürün İade Bekliyor";

                break;

            case 7:
                status = "İade Faturası Bekliyor";

                break;

            case 8:
                status = "Stok İade Bekliyor";

                break;

            case 9:
                status = "Ödeme İade Bekliyor";

                break;

            case 10:
                status = "İade Tamamlandı";

                break;

            default:
                status = "Geçersiz";
        }

        holder.saleCode.setText(getOrdersResult.data.get(position).saleCode);
        holder.saleCreateDate.setText(data);
        holder.status.setText(status);
        holder.grandTotal.setText(String.format("%.2f TL", Double.valueOf(getOrdersResult.data.get(position).grandTotal)));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOrdersAdapterListener.getOrdersAdapterListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getOrdersResult.data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView saleCode;
        AppCompatTextView saleCreateDate;
        AppCompatTextView status;
        AppCompatTextView grandTotal;

        public ViewHolder(View itemView) {
            super(itemView);

            saleCode = (AppCompatTextView) itemView.findViewById(R.id.saleCode);
            saleCreateDate = (AppCompatTextView) itemView.findViewById(R.id.saleCreateDate);
            status = (AppCompatTextView) itemView.findViewById(R.id.endDate);
            grandTotal = (AppCompatTextView) itemView.findViewById(R.id.discountPrice);
        }
    }

    public interface GetOrdersAdapterListener {
        void getOrdersAdapterListener(int position);
    }
}
