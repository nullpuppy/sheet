package com.nulldomain.sheet.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nulldomain.sheet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dustin on 3/2/14.
 */
public class ClassListAdapter extends ArrayAdapter<ClassListDetail> {
    private Context _context;
    private List<ClassListDetail> _class_list;

    public ClassListAdapter(Context context, int resource_id, List<ClassListDetail> class_list) {
        super(context, resource_id, class_list);
        this._context = context;
        this._class_list = class_list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater vi = (LayoutInflater)_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.list_class_item, null);
        }

        TextView class_name = (TextView)convertView.findViewById(R.id.class_name);
        TextView class_type = (TextView)convertView.findViewById(R.id.class_type);
        TextView class_favored = (TextView)convertView.findViewById(R.id.favored_class);
        TextView class_resource = (TextView)convertView.findViewById(R.id.class_resource);

        //TODO add image loading from user data
        //ImageView class_icon = (TextView)convertView.findViewById(R.id.class_icon);

        class_name.setText(_class_list.get(position).getClassName());
        class_type.setText(_class_list.get(position).getClassType());
        class_favored.setText(_class_list.get(position).isFavoredClass() ? "Favored Class" : "");
        class_resource.setText(_class_list.get(position).getClassResource());
        //class_icon.setImageBitmap();

        return convertView;
    }
}
