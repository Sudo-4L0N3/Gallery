/**
 * ImageAdapter is a custom BaseAdapter used to populate the GridView with images in the gallery.
 * It provides the necessary methods for adapting the data set (array of image resources) to the GridView.
 */
package com.example.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    // Context to be passed to the adapter
    private final Context context;

    // Array of image resources representing the gallery images
    public Integer[] images = {
            R.drawable.pic_1, R.drawable.pic_2,
            R.drawable.pic_3, R.drawable.pic_4,
            R.drawable.pic_5, R.drawable.pic_8,
            R.drawable.pic_6, R.drawable.pic_9,
            R.drawable.pic_7, R.drawable.pic_10,
            R.drawable.pic_1, R.drawable.pic_2,
            R.drawable.pic_3, R.drawable.pic_4,
            R.drawable.pic_5, R.drawable.pic_8,
            R.drawable.pic_6, R.drawable.pic_9,
            R.drawable.pic_7, R.drawable.pic_10,
            R.drawable.pic_1, R.drawable.pic_2,
            R.drawable.pic_3, R.drawable.pic_4,
            R.drawable.pic_5, R.drawable.pic_8,
            R.drawable.pic_6, R.drawable.pic_9,
            R.drawable.pic_7, R.drawable.pic_10
    };

    // Constructor that initializes the context
    public ImageAdapter(Context c) {
        context = c;
    }

    // Returns the total number of images in the adapter
    @Override
    public int getCount() {
        return images.length;
    }

    // Returns the image resource at the specified position
    @Override
    public Object getItem(int position) {
        return images[position];
    }

    // Returns the item ID at the specified position
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Creates and returns a View for each item in the data set
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Create a new ImageView
        ImageView imageView = new ImageView(context);

        // Set the image resource for the ImageView from the adapter's images array
        imageView.setImageResource(images[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // Set layout parameters for the ImageView within the GridView
        imageView.setLayoutParams(new GridView.LayoutParams(330, 350));

        return imageView;
    }
}
