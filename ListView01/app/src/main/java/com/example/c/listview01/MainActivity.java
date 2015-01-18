package com.example.c.listview01;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

class MyData {
    int mImgIcon;
    String mTitle, mSubTitle;

    MyData(int imgIcon, String title, String subTitle) {
        mImgIcon = imgIcon;
        mTitle = title;
        mSubTitle = subTitle;
    }
}

public class MainActivity extends ActionBarActivity {


    ArrayList<MyData> list;
    MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<MyData>();
        list.add(new MyData(R.drawable.ic_launcher, "Title1", "SubTitle1"));
        list.add(new MyData(R.drawable.ic_launcher, "Title2", "SubTitle2"));
        list.add(new MyData(R.drawable.ic_launcher, "Title3", "SubTitle3"));
        list.add(new MyData(R.drawable.ic_launcher, "Title4", "SubTitle4"));
        list.add(new MyData(R.drawable.ic_launcher, "Title5", "SubTitle5"));
        list.add(new MyData(R.drawable.ic_launcher, "Title6", "SubTitle6"));
        list.add(new MyData(R.drawable.ic_launcher, "Title7", "SubTitle7"));
        list.add(new MyData(R.drawable.ic_launcher, "Title1", "SubTitle1"));
        list.add(new MyData(R.drawable.ic_launcher, "Title2", "SubTitle2"));
        list.add(new MyData(R.drawable.ic_launcher, "Title3", "SubTitle3"));
        list.add(new MyData(R.drawable.ic_launcher, "Title4", "SubTitle4"));
        list.add(new MyData(R.drawable.ic_launcher, "Title5", "SubTitle5"));
        list.add(new MyData(R.drawable.ic_launcher, "Title6", "SubTitle6"));
        list.add(new MyData(R.drawable.ic_launcher, "Title7", "SubTitle7"));
        list.add(new MyData(R.drawable.ic_launcher, "Title1", "SubTitle1"));
        list.add(new MyData(R.drawable.ic_launcher, "Title2", "SubTitle2"));
        list.add(new MyData(R.drawable.ic_launcher, "Title3", "SubTitle3"));
        list.add(new MyData(R.drawable.ic_launcher, "Title4", "SubTitle4"));
        list.add(new MyData(R.drawable.ic_launcher, "Title5", "SubTitle5"));
        list.add(new MyData(R.drawable.ic_launcher, "Title6", "SubTitle6"));
        list.add(new MyData(R.drawable.ic_launcher, "Title7", "SubTitle7"));


        ListView listView = (ListView)findViewById(R.id.listView);



        adapter = new MyCustomAdapter(this, R.layout.list_row, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //((TextView)view).getText().toString()
                Toast.makeText(MainActivity.this, list.get(position).mTitle, Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int count =totalItemCount - visibleItemCount;
                if(firstVisibleItem >=count){
                    list.add(new MyData(R.drawable.ic_launcher, "111Title3", "SubTitle3"));
                    list.add(new MyData(R.drawable.ic_launcher, "222Title4", "SubTitle4"));
                    list.add(new MyData(R.drawable.ic_launcher, "333Title5", "SubTitle5"));
                    list.add(new MyData(R.drawable.ic_launcher, "444Title6", "SubTitle6"));
                    list.add(new MyData(R.drawable.ic_launcher, "55Title7", "SubTitle7"));

                    adapter.notifyDataSetChanged();
                }
            }
        });

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
