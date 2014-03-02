package com.nulldomain.sheet.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nulldomain.sheet.CharacterPreview;
import com.nulldomain.sheet.R;
import com.nulldomain.sheet.character.CharacterDetail;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Dustin on 3/1/14.
 */
public class CharacterListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader;
    private HashMap<String, List<CharacterListDetail>> _listDataChild;

    public CharacterListAdapter(Context context, List<String> listDataHeader,
                                HashMap<String, List<CharacterListDetail>> listDataChild) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listDataChild;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final CharacterListDetail child = (CharacterListDetail)getChild(groupPosition, childPosition);

        if(convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater)this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_characters_item, null);
        }

        LinearLayout charItem = (LinearLayout)convertView.findViewById(R.id.character_item);
        TextView charName = (TextView)convertView.findViewById(R.id.character_item_name);
        TextView dmName = (TextView)convertView.findViewById(R.id.character_item_dm);
        TextView modified = (TextView)convertView.findViewById(R.id.character_item_last_modified);
        TextView age = (TextView)convertView.findViewById(R.id.character_item_age);
        ImageView portrait = (ImageView)convertView.findViewById(R.id.character_item_portrait);

        charItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(_context, CharacterDetail.class);
                // TODO: add detail for character to display
                _context.startActivity(intent);
            }
        });

        portrait.setTag(new Integer(childPosition));
        portrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(_context, CharacterPreview.class);
                // TODO: add detail for character to display
                _context.startActivity(intent);
            }
        });

        charName.setText(child.getCharacterName());
        dmName.setText(child.getGameMaster());
        modified.setText(child.getLastModified());
        age.setText(child.getCharacterAge());
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataChild.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String)getGroup(groupPosition);
        if(convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater)this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_characters_group, null);
        }
        if(!isExpanded) {
            ((ExpandableListView)parent).expandGroup(groupPosition);
        }
        TextView lblListHeader = (TextView)convertView.findViewById(R.id.list_characters_header);
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
