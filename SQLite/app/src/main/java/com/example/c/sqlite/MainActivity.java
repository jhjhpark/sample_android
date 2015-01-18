package com.example.c.sqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        MySQLiteHandler myHandler = new MySQLiteHandler(this);
        myHandler.insert("kim", 20, "seoul");
        myHandler.insert("lee", 21, "seoul");
        myHandler.insert("park", 22, "incheon");
        myHandler.insert("kim2", 23, "busan");

        myHandler.updateAge("lee",25);
        myHandler.delete("park");

        textViewResult.setText(myHandler.getAllData());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
