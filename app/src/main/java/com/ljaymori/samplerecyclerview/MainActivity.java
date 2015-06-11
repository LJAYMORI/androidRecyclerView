package com.ljaymori.samplerecyclerview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;


public class MainActivity extends ActionBarActivity {

    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    MyRecyclerViewAdapter mAdapter;
//  GridLayoutManager mLayoutManager;
//  StaggeredGridLayoutManager mLayoutManager;

    EditText etTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
//        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyRecyclerViewAdapter(this, initData());

        // adapter animation(scroll)
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
        ScaleInAnimationAdapter scaleAdapter = new ScaleInAnimationAdapter(alphaAdapter);
        scaleAdapter.setFirstOnly(false);
        scaleAdapter.setDuration(500);
        scaleAdapter.setInterpolator(new OvershootInterpolator());

        // item animation(item add, remove)
        mRecyclerView.setItemAnimator(new SlideInLeftAnimator());
        mRecyclerView.getItemAnimator().setAddDuration(300);
        mRecyclerView.getItemAnimator().setRemoveDuration(300);

        mRecyclerView.setAdapter(mAdapter);

        etTitle = (EditText) findViewById(R.id.edit_title);
        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                ItemData id = new ItemData();
                id.setImageId(R.drawable.ic_launcher);
                id.setTitle(title);
                id.setDescription(title + "'s Description");

                mAdapter.add(id, 1);
                Toast.makeText(MainActivity.this, title + " Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<ItemData> initData() {
        ArrayList<ItemData> list = new ArrayList<ItemData>();

        for(int i=0; i<10; i++) {
            ItemData id = new ItemData();
            id.setImageId(R.drawable.ic_launcher);
            id.setTitle("Title_" + i);
            id.setDescription("Description_" + i);

            list.add(id);
        }

        return list;
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
