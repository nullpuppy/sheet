package com.nulldomain.sheet;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.nulldomain.sheet.util.CharacterListAdapter;
import com.nulldomain.sheet.util.CharacterListDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dashboard extends ActionBarActivity {

    CharacterListAdapter _characterListAdapter;
    ExpandableListView _characterList;
    List<String> _characterListDataHeader;
    HashMap<String, List<CharacterListDetail>> _characterListDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // get the listview
        _characterList = (ExpandableListView)findViewById(R.id.character_list_view);

        // preparing list data
        prepareListData();

        _characterListAdapter = new CharacterListAdapter(this, _characterListDataHeader,
                _characterListDataChild);

        _characterList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), _characterListDataHeader.get(groupPosition)
                        + ":" + v + ":" + _characterListDataChild.get(_characterListDataHeader
                        .get(groupPosition)).get(childPosition).getCharacterName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        _characterList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });

        // setting list adapter
        _characterList.setAdapter(_characterListAdapter);
//        _characterList.expandGroup(0);
//        _characterList.expandGroup(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Toast.makeText(this, "Selected " + item.getTitle(), Toast.LENGTH_SHORT).show();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void prepareListData() {
        _characterListDataHeader = new ArrayList<String>();
        _characterListDataChild = new HashMap<String, List<CharacterListDetail>>();

        // Adding child data
        _characterListDataHeader.add("Recent");
        _characterListDataHeader.add("Game Type 1");
        _characterListDataHeader.add("Game Type 2");
        _characterListDataHeader.add("Game Type 3");

        List<CharacterListDetail> pathfinder = new ArrayList<CharacterListDetail>();
        pathfinder.add(new CharacterListDetail("Character 1", "Dungeon Master", null, "Aug 01", "10 years"));
        pathfinder.add(new CharacterListDetail("Character 2", "DM Bob", null, "Last Thursday", "10 Months"));
        pathfinder.add(new CharacterListDetail("Character 3", "DM Bob", null, "Yesterday", "7 days"));
        pathfinder.add(new CharacterListDetail("Character 4", "Jill", null, "Today", "3 minutes"));

        List<CharacterListDetail> dnd35 = new ArrayList<CharacterListDetail>();
        dnd35.add(new CharacterListDetail("Character 5", "", null, "Feb 13", "2 months"));
        dnd35.add(new CharacterListDetail("Character 6", "Nobody", null, "Jan 29", "3 months"));

        List<CharacterListDetail> other = new ArrayList<CharacterListDetail>();
        other.add(new CharacterListDetail("Character 7", "Me", null, "Today", "3 minutes"));

        _characterListDataChild.put(_characterListDataHeader.get(0), new ArrayList<CharacterListDetail>());
        _characterListDataChild.put(_characterListDataHeader.get(1), pathfinder);
        _characterListDataChild.put(_characterListDataHeader.get(2), dnd35);
        _characterListDataChild.put(_characterListDataHeader.get(3), other);
    }
}
