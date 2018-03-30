package com.example.root.codeknights;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SlideImageText extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_image_activity);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

    }


}
class MyPagerAdapter extends  FragmentPagerAdapter {
    private static int NUM_ITEMS = 7;

    public MyPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages.
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for a particular page.


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:findweather fw=new findweather();
                return CURRENTWEATHER.newInstance(fw.temp,fw.city,fw.humidity,fw.mintemp,fw.maxtemp,fw.description);
            case 1:
                return FragmentWithTwoImages.newInstance("CropInfp", R.drawable.splashimage, R.drawable.splashimage);
            case 2:
                return FragmentWithTwoImages.newInstance("CropInfp", R.drawable.splashimage, R.drawable.splashimage);
            default:
                return null;
        }
    }



    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab " + position;
    }

}
