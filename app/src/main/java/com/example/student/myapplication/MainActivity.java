package com.example.student.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final int REQUEST_CODE_ADD =321;
    ArrayList<String> datalist = new ArrayList();
    ArrayAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    lv =(ListView)findViewById(R.id.listView);
       adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,datalist);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view ,int i ,long l){
                datalist.remove(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });


        lv.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add)
        {
            Intent it = new Intent(MainActivity.this, AddActivity.class);
            startActivityForResult(it, REQUEST_CODE_ADD);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD)
        {
            if (resultCode == RESULT_OK)
            {
                String str = data.getStringExtra("data");
                datalist.add(str);
                adapter.notifyDataSetChanged();

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

