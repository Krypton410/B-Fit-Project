package com.b_fit.application.b_fit;

import android.content.Context;
import android.media.Image;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewGroupCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Maxwell on 6/25/2017.
 */

public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resource = {R.drawable.picture1,R.drawable.picture2,R.drawable.picture3};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public CustomSwipeAdapter(Context ctx)

    {
        this.ctx = ctx;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.imageView1);
        imageView.setImageResource(image_resource[position]);
        container.addView(item_view);
        return item_view;
    }




    @Override
    public int getCount() {

        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view==object);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       try{
        container.removeView((LinearLayout)object);
        super.destroyItem(container, position, object);}
       catch (Exception e){



       }


    }


}
