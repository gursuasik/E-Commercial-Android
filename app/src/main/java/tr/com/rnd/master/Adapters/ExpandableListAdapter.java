package tr.com.rnd.master.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.HashMap;
import java.util.List;

import tr.com.rnd.master.Model.CellData;
import tr.com.rnd.master.R;

/**
 * Created by gursuasik on 22/12/17.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<CellData> headers;
    private HashMap<CellData, List<CellData>> children;

    public ExpandableListAdapter(Context context, List<CellData> headers, HashMap<CellData, List<CellData>> children) {
        this.context = context;
        this.headers = headers;
        this.children = children;
    }

    @Override
    public CellData getChild(int groupPosition, int childPosititon) {
        return this.children.get(this.headers.get(groupPosition)).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.left_menu_child, null);
        }

        AppCompatTextView txtListChild = convertView.findViewById(R.id.name);

        txtListChild.setText(getChild(groupPosition, childPosition).name);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (this.children.get(this.headers.get(groupPosition)) == null)
            return 0;
        else
            return this.children.get(this.headers.get(groupPosition)).size();
    }

    @Override
    public CellData getGroup(int groupPosition) {
        return this.headers.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.headers.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = getGroup(groupPosition).name;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.left_menu_header, null);
        }

        AppCompatTextView lblListHeader = convertView.findViewById(R.id.name);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

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