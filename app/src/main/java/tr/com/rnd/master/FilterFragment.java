package tr.com.rnd.master;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import tr.com.rnd.master.Adapters.FilterExpandableListAdapter;
import tr.com.rnd.master.Model.Result.SearchResult;

public class FilterFragment extends Fragment {
    ExpandableListView expandableListView;
    AppCompatButton onFilter;

    List<FilterParent> filters;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);

        ((ProductsActivity) getActivity()).toolbar.setNavigationIcon(R.drawable.back);
        ((ProductsActivity) getActivity()).toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        expandableListView = view.findViewById(R.id.expandableListView);
        onFilter = (AppCompatButton) view.findViewById(R.id.onFilter);

        List<FilterChild> filterSections = new ArrayList<FilterChild>();
        filterSections.add(new FilterChild("Artan fiyat", "1", false));
        filterSections.add(new FilterChild("Azalan fiyat", "4", false));
        filterSections.add(new FilterChild("En yeniler", "21", false));
        filterSections.add(new FilterChild("En çok satan", "8", false));
        filterSections.add(new FilterChild("A'dan Z'ye", "9", false));
        filterSections.add(new FilterChild("Öne çıkan", "5", false));
        filters = new ArrayList<FilterParent>();
        filters.add(new FilterParent(false, "Sırala", filterSections));

        for (SearchResult.TagGroup group: ((ProductsActivity) getActivity()).searchResult.data.tagGroup) {
            filterSections = new ArrayList<FilterChild>();

            for (SearchResult.List__ list: group.list) {
                filterSections.add(new FilterChild(list.name, list.id, false));
            }

            filters.add(new FilterParent(false, group.name, filterSections));
        }

        for (SearchResult.SpecGroup group: ((ProductsActivity) getActivity()).searchResult.data.specGroup) {
            filterSections = new ArrayList<FilterChild>();

            for (SearchResult.List_ list: group.list) {
                filterSections.add(new FilterChild(list.name, list.id, false));
            }

            filters.add(new FilterParent(false, group.name, filterSections));
        }

        FilterMenu();

        onFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> oArray = new ArrayList<>();
                for (int i = 0; i < 6; i++) {
                    if (filters.get(0).filterChildren.get(i).select) {
                        oArray.add(filters.get(0).filterChildren.get(i).value);
                    }
                }

                List<String> tArray = new ArrayList<>();
                int tagGroupCount = ((ProductsActivity) getActivity()).searchResult.data.tagGroup.size();
                for (int i = 0; i < tagGroupCount; i++) {
                    for (int j = 0; j < ((ProductsActivity) getActivity()).searchResult.data.tagGroup.get(i).list.size(); j++) {
                        if (filters.get(i + 1).filterChildren.get(j).select) {
                            tArray.add(filters.get(i + 1).filterChildren.get(j).value);
                        }
                    }
                }

                List<String> sArray = new ArrayList<>();
                int specGroupCount = ((ProductsActivity) getActivity()).searchResult.data.specGroup.size();
                for (int i = 0; i < specGroupCount; i++) {
                    for (int j = 0; j < ((ProductsActivity) getActivity()).searchResult.data.specGroup.get(i).list.size(); j++) {
                        if (filters.get(tagGroupCount + 1).filterChildren.get(j).select) {
                            sArray.add(filters.get(i + 1).filterChildren.get(j).value);
                        }
                    }
                }

                ((ProductsActivity) getActivity()).o = TextUtils.join(", ", oArray);
                ((ProductsActivity) getActivity()).t = TextUtils.join(", ", tArray);
                ((ProductsActivity) getActivity()).s = TextUtils.join(", ", sArray);
                ((ProductsActivity) getActivity()).loadFragment(new ProductsFragment());
            }
        });

        return view;
    }

    private void FilterMenu() {
        final FilterExpandableListAdapter filterExpandableListAdapter = new FilterExpandableListAdapter(getActivity(), filters);
        expandableListView.setAdapter(filterExpandableListAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //Log.d("TAG", "onChildClick: " + "childList.get(" + groupPosition + ").get(" + childPosition + ")." + childList.get(headerList.get(groupPosition)).get(childPosition).selectStatus);
                Boolean tempSelect = filters.get(groupPosition).filterChildren.get(childPosition).select;

                if (groupPosition == 0) {
                    for (int i = 0; i < filters.get(0).filterChildren.size(); i++) {
                        filters.get(0).filterChildren.get(i).select = false;
                    }
                }

                filters.get(groupPosition).filterChildren.get(childPosition).select = !tempSelect;
                //Log.d("TAG", "onChildClick: " + "childList.get(" + groupPosition + ").get(" + childPosition + ")." + childList.get(headerList.get(groupPosition)).get(childPosition).selectStatus);

                filterExpandableListAdapter.notifyDataSetChanged();

                return false;
            }
        });
    }

    public class FilterParent {
        Boolean open;
        public String name;
        public List<FilterChild> filterChildren = new ArrayList<>();

        public FilterParent(Boolean open, String name, List<FilterChild> filterChildren) {
            this.open = open;
            this.name = name;
            this.filterChildren = filterChildren;
        }
    }

    public class FilterChild {
        public String name;
        String value;
        public Boolean select;

        public FilterChild(String name, String value, Boolean select) {
            this.name = name;
            this.value = value;
            this.select = select;
        }
    }
}
