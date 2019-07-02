package com.example.chapter3.homework;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.chapter3.homework.Fragment.HelloFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {

    private static final int PAGE_COUNT = 2;
    private LottieAnimationView animationView;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);

        ViewPager pager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);



        animationView = findViewById(R.id.lottie_ex3);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,"alpha",1f,0f);
        animator1.setInterpolator(new LinearInterpolator());
        animator1.setDuration(5000);
        animator1.start();

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(pager,"alpha",0f,1f);
        animator2.setInterpolator(new LinearInterpolator());
        animator2.setDuration(5000);
        animator2.start();

        ObjectAnimator animator3 = ObjectAnimator.ofFloat(tabLayout,"alpha",0f,1f);
        animator3.setInterpolator(new LinearInterpolator());
        animator3.setDuration(5000);
        animator3.start();


//        animationView.setVisibility(View.GONE);

//        pager.setVisibility(View.VISIBLE);
//        tabLayout.setVisibility(View.VISIBLE);



        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                if(i == 0){
                    return new HelloFragment();
                }
                return new HelloFragment();
            }

            @Override
            public int getCount() {
                return PAGE_COUNT;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if(position == 0){
                    return "好友列表";
                }
                else {
                    return "我的好友";
                }
            }
        });
        tabLayout.setupWithViewPager(pager);


        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面



        // TODO: ex3-2, 添加 TabLayout 支持 Tab

    }
}
