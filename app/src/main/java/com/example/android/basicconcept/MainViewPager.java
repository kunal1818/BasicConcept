package com.example.android.basicconcept;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.android.basicconcept.Fragements.UpcomingAndPastFragement;
import com.example.android.basicconcept.constants.Constants;

/**
 * main view pager class where upcominf and PAST button is held
 */
public class MainViewPager extends AppCompatActivity implements Constants {
    private Button upcoming, past;
    private ViewPager vp;
    private Bundle extra;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_pager);
        Log.e("hello", "pess1");
        upcoming = (Button) findViewById(R.id.btn_upcoming);
        past = (Button) findViewById(R.id.btn_past);
        vp = (ViewPager) findViewById(R.id.viewpager);
        extra = getIntent().getExtras();
       /* UP_COMING.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                UP_COMING.setBackgroundResource(R.color.colorPrimaryDark);
                PAST.setBackgroundResource(R.color.colorAccent);
                vp.setCurrentItem(0);
            }
        });
        PAST.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                PAST.setBackgroundResource(R.color.colorAccent);
                UP_COMING.setBackgroundResource(R.color.colorPrimaryDark);
                vp.setCurrentItem(1);
            }
        });*/
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(final int position) {
                if (position == 0) {

                    upcoming.setBackgroundResource(R.color.colorPrimaryDark);
                    past.setBackgroundResource(R.color.colorAccent);
                } else {
                    past.setBackgroundResource(R.color.colorAccent);
                    upcoming.setBackgroundResource(R.color.colorPrimaryDark);


                }
            }

            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {

                    return new UpcomingAndPastFragement(Constants.UP_COMING, extra);
                } else {
                    return new UpcomingAndPastFragement(Constants.PAST, extra);

                }


            }

            @Override
            public int getCount() {
                return 2;
            }
        });


    }

    @Override
    public void extra() {

    }
}

