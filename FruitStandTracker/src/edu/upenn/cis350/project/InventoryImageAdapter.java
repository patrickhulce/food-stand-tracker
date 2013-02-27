package edu.upenn.cis350.project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class InventoryImageAdapter extends BaseAdapter {
	private Context mContext;

    public InventoryImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView textView;

        if (convertView == null) { // if it's not recycled, initialize some attributes
        	
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
		
		imageView.setImageResource(mThumbIds[position]);
		return imageView;
        
//        // image boxes
//    	if ((position % 4 == 0) || (position % 4 == 1)){ 
//    		if (convertView == null) { // if it's not recycled, initialize some attributes
//    	
//                imageView = new ImageView(mContext);
//                imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                imageView.setPadding(8, 8, 8, 8);
//            } else {
//                imageView = (ImageView) convertView;
//            }
//    		
//    		imageView.setImageResource(mThumbIds[position]);
//    		return imageView;
//    		
//    	// test boxes	
//    	} else { 
//    		if (convertView == null) { // if it's not recycled, initialize some attributes
//    	    	
//                textView = new TextView(mContext);
//                textView.setLayoutParams(new GridView.LayoutParams(85, 85));
//            } else {
//                textView = (TextView) convertView;
//            }
//    		
//    		textView.setText(qty[position-2*(position/4+1)]);
//    		return textView;
//    	}
        
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.apple, R.drawable.pear,
            R.drawable.orange, R.drawable.grapes,
            R.drawable.kiwi, R.drawable.banana,
            R.drawable.granola, R.drawable.smoothie,
    };
    
    private String[] qty = {
    		"0","1","2","3","4","5","6","7"
    };
}
