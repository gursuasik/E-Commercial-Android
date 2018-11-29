package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;

import java.util.List;

import tr.com.rnd.master.FilterFragment;
import tr.com.rnd.master.R;

/**
 * Created by gursuasik on 22/12/17.
 */

public class FilterExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<FilterFragment.FilterParent> filters;

    public FilterExpandableListAdapter(Context context, List<FilterFragment.FilterParent> filters) {
        this.context = context;
        this.filters = filters;
    }

    @Override
    public FilterFragment.FilterChild getChild(int groupPosition, int childPosititon) {
        return filters.get(groupPosition).filterChildren.get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.filter_child, null);
        }

        final LinearLayout child = convertView.findViewById(R.id.child);
        final AppCompatTextView name = convertView.findViewById(R.id.name);
        final AppCompatImageView checked = convertView.findViewById(R.id.checked);

        name.setText(getChild(groupPosition, childPosition).name);

        if (getChild(groupPosition, childPosition).select) {
            child.setBackgroundColor(Color.rgb(220, 220, 220));
            checked.setVisibility(View.VISIBLE);
        }
        else {
            child.setBackgroundColor(Color.WHITE);
            checked.setVisibility(View.GONE);
        }

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return filters.get(groupPosition).filterChildren.size();
    }

    @Override
    public FilterFragment.FilterParent getGroup(int groupPosition) {
        return filters.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return filters.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = getGroup(groupPosition).name;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.filter_header, null);
        }

        AppCompatTextView name = convertView.findViewById(R.id.name);
        name.setTypeface(null, Typeface.BOLD);
        name.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}