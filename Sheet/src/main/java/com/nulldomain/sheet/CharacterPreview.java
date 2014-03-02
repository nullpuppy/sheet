package com.nulldomain.sheet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nulldomain.sheet.util.ClassListAdapter;
import com.nulldomain.sheet.util.ClassListDetail;

import java.util.ArrayList;
import java.util.List;

public class CharacterPreview extends Activity implements View.OnClickListener {
    ListAdapter _class_list_adapter;
    ListView _class_list;
    List<ClassListDetail> _classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_character_preview);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        _classes = new ArrayList<ClassListDetail>();
        _classes.add(new ClassListDetail("Class 1", true, "Core", "PHB", ""));
        _classes.add(new ClassListDetail("Class 2", false, "Base", "PHB", ""));
        _classes.add(new ClassListDetail("Class 1", true, "Core", "PHB", ""));
        _classes.add(new ClassListDetail("Class 1", true, "Core", "PHB", ""));
        _classes.add(new ClassListDetail("Class 3", false, "Core", "PHB", ""));
        _classes.add(new ClassListDetail("Class 2", false, "Base", "PHB", ""));

        _class_list = (ListView)findViewById(R.id.character_preview_classes);
        _class_list_adapter = new ClassListAdapter(this, R.layout.list_class_item, _classes);
        _class_list.setAdapter(_class_list_adapter);

        ImageView portrait = (ImageView)findViewById(R.id.character_preview_portrait);
        portrait.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT);
        finishActivity(1);
    }
}
