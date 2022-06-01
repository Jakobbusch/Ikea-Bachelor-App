package com.example.ikeabachelorapp.Model;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.ikeabachelorapp.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> titleList;
    private HashMap<String, List<String>> list;

    /**
     * ExpandableListAdapter Constructor
     * @param context
     * @param titleList
     * @param list
     */
    public ExpandableListAdapter(Context context, List<String> titleList,
                                 HashMap<String, List<String>> list) {
        this.context = context;
        this.titleList = titleList;
        this.list = list;
    }

    /**
     * Get Child
     * @param lstPsn
     * @param expanded_ListPosition
     * @return this.list.get(this.titleList.get(lstPsn)).get(expanded_ListPosition)
     */
    @Override
    public Object getChild(int lstPsn, int expanded_ListPosition) {
        return this.list.get(this.titleList.get(lstPsn)).get(expanded_ListPosition);
    }

    /**
     * Get Child Id
     * @return expanded_ListPositio
     */
    @Override
    public long getChildId(int listPosition, int expanded_ListPosition) {
        return expanded_ListPosition;
    }

    /**
     * Get Child View
     * @param lstPsn
     * @param expanded_ListPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return convertView
     */
    @Override
    public View getChildView(int lstPsn, final int expanded_ListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(lstPsn, expanded_ListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }
        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setTextColor(Color.parseColor("#280071"));
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    /**
     * Get Number of Children
     * @param listPosition
     * @return this.list.get(this.titleList.get(listPosition)).size()
     */
    @Override
    public int getChildrenCount(int listPosition) {
        return this.list.get(this.titleList.get(listPosition)).size();
    }

    /**
     * Get Group
     * @param listPosition
     * @return this.titleList.get(listPosition)
     */
    @Override
    public Object getGroup(int listPosition) {
        return this.titleList.get(listPosition);
    }

    /**
     * Get Group size
     * @return this.titleList.size()
     */
    @Override
    // Gets the number of groups.
    public int getGroupCount() {
        return this.titleList.size();
    }

    /**
     * Get Group Id
     * @param listPosition
     * @return listPosition
     */
    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    /**
     * Get View of Group
     * @param listPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return convertView
     */
    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        if(isExpanded){
            listTitleTextView.setTextColor(Color.parseColor("#FFCD00"));
        }else{
            listTitleTextView.setTextColor(Color.BLACK);
        }
        return convertView;
    }

    /**
     * Has Stable Ids
     * @return false
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * Can child be selected
     * @param listPosition
     * @param expandedListPosition
     * @return true
     */
    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
