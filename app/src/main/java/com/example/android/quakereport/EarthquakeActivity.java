
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {


    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);


        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        earthquakeListView.setAdapter(adapter);


        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Earthquake currentEarthquake = adapter.getItem(position);


                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());


                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);


                startActivity(websiteIntent);
            }
        });
    }
}


