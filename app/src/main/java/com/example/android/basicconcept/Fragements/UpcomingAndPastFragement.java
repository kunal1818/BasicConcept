package com.example.android.basicconcept.Fragements;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.basicconcept.R;
import com.example.android.basicconcept.constants.Constants;

/**
 * Created by mark63 on 20/4/17.
 */

public class UpcomingAndPastFragement extends Fragment implements Constants {

    private Button btnLeft, btnRight;
    private ViewPager viewPager;
    private String mMode;

    /**
     * @param mMode to set mode or set string UP_COMING or PAST.
     */
    public UpcomingAndPastFragement(final String mMode) {
        this.mMode = mMode;
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.up_coming_and_past, container, false);
        btnLeft = (Button) view.findViewById(R.id.btn_first);
        btnRight = (Button) view.findViewById(R.id.btn_second);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager1);
/*
        btnLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                btnLeft.setBackgroundResource(R.color.colorPrimaryDark);
                btnRight.setBackgroundResource(R.color.colorPrimaryDark);
                viewPager.setCurrentItem(0);

            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                btnRight.setBackgroundResource(R.color.colorPrimaryDark);
                btnLeft.setBackgroundResource(R.color.colorPrimaryDark);
                viewPager.setCurrentItem(1);

            }
        });
*/
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(final int position) {
                if (position == 0) {

                    btnLeft.setText("Pending");
                    btnRight.setText("Accepted");
                    btnLeft.setBackgroundResource(R.color.colorPrimary);
                    btnRight.setBackgroundResource(R.color.colorPrimaryDark);
                } else {
                    btnLeft.setText("Canceled");
                    btnRight.setText("Completed");
                    btnLeft.setBackgroundResource(R.color.colorPrimaryDark);
                    btnRight.setBackgroundResource(R.color.colorPrimary);

                }
            }


            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                    return new PendingAcceptandCompleteCancel(UP_COMING);
                } else {
                    return new PendingAcceptandCompleteCancel(PAST);
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        });


        return view;
    }
}