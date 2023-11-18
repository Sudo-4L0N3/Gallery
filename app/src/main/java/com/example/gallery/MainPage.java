/**
 * MainPage is the main activity of the gallery app, displaying a grid of images in a GridView.
 * It uses the ImageAdapter to populate the GridView with images.
 * On item click, it launches the FullImageActivity to display the selected image in full screen.
 */
package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainPage extends AppCompatActivity {

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to the layout defined in activity_main_page.xml
        setContentView(R.layout.activity_main_page);

        // Initialize the GridView from the layout
        GridView gridView = findViewById(R.id.gridView);

        // Set the adapter for the GridView using the custom ImageAdapter
        gridView.setAdapter(new ImageAdapter(this));

        // Set an item click listener for the GridView
        gridView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            // Create an intent to launch FullImageActivity and pass the selected position
            Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
            i.putExtra("id", position);

            // Start the FullImageActivity
            startActivity(i);
        });
    }
}
