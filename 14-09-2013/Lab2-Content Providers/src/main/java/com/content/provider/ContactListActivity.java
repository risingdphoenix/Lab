package com.content.provider;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactListActivity extends Activity {
    private ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        String[] contactList = null;

        /*
        * get column display_name of all rows and insert to contactList
        * it's take time, should do it in another thread :)
        */

        contactListView = (ListView) findViewById(R.id.contact_list);
        contactListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactList));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contact_list, menu);
        return true;
    }
    
}
