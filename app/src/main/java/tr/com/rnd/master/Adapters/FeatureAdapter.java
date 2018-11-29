package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tr.com.rnd.master.Model.Result.HomePageResult;
import tr.com.rnd.master.R;

public class FeatureAdapter extends PagerAdapter {
    private Context context;
    private List<Bitmap> image;
    private List<HomePageResult.Slider> slider;

    public FeatureAdapter(Context context, List<Bitmap> image, List<HomePageResult.Slider> slider) {
        this.context = context;
        this.image = image;
        this.slider = slider;
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.adapter_feature, null);

        AppCompatImageView imageViewCompat = (AppCompatImageView) view.findViewById(R.id.imageView);
        AppCompatTextView textView = (AppCompatTextView) view.findViewById(R.id.textView);

        imageViewCompat.setImageBitmap(image.get(position));
        textView.setText(slider.get(position).getTitle());

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
