/**
 * FullImageActivity displays a full-screen image using a ViewPager.
 * This activity is launched when a user taps on an image in the gallery from MainPage.
 * It retrieves the position of the tapped image from the intent and uses a custom
 * PagerAdapter (CustomPagerAdapter) to show the selected image in a ViewPager.
 */
package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

public class FullImageActivity extends AppCompatActivity {

    // ViewPager for displaying images in a swipeable manner
    private ViewPager viewPager;

    // Adapter for managing the images in the ViewPager
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to the layout defined in activity_full_image2.xml
        setContentView(R.layout.activity_full_image2);

        // Retrieve the position of the selected image from the intent
        Intent intent = getIntent();
        int position = Objects.requireNonNull(intent.getExtras()).getInt("id");

        // Create an instance of the ImageAdapter
        adapter = new ImageAdapter(this);

        // Initialize the ViewPager and set its adapter to a CustomPagerAdapter
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomPagerAdapter());

        // Set the current item of the ViewPager to the selected position
        viewPager.setCurrentItem(position);
    }

    // CustomPagerAdapter is responsible for managing the image views in the ViewPager
    private class CustomPagerAdapter extends PagerAdapter {

        // Returns the total number of images in the adapter
        @Override
        public int getCount() {
            return adapter.getCount();
        }

        // Determines whether a page View is associated with a specific key object
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        // Creates the page for the given position, instantiating an ImageView for each image
        @Override
        public Object instantiateItem(View container, int position) {
            ImageView imageView = new ImageView(FullImageActivity.this);

            // Set the image resource for the ImageView from the adapter's images array
            imageView.setImageResource(adapter.images[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            // Add the ImageView to the ViewPager's container
            ((ViewPager) container).addView(imageView, 0);
            return imageView;
        }

        // Removes the page for the given position from the container
        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);
        }
    }
}
