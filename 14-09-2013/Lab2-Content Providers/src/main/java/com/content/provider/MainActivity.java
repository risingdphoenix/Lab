package com.content.provider;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    private ListView detailListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        c.moveToFirst();
        String[] detailList = new String[c.getColumnCount()];
        for (int i=0; i < c.getColumnCount(); i++) {
            detailList[i] = c.getColumnName(i) + " : " + c.getString(i);
        }
        c.close();

        detailListView = (ListView) findViewById(R.id.detail_list);
        detailListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, detailList));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
