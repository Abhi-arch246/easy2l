package com.abhitech.easy2l;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Slider2Adapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public Slider2Adapter(Context context) {
        this.context = context;
    }

    //    Array for images
    public int[] slide_images = {
            R.drawable.image_6,
            R.drawable.image_7,
            R.drawable.two_students
    };
    //    Array from titles
    public String[] slide_titles = {
            "Exams on Board",
            "Quizes and lot more",
            "Explore the content all over the app",
    };
    //    Array for subtitles
    public String[] slide_subtitles = {
            "Learning journeys are mapped to a student's grade & syllabus. Each chapter comprises small concepts that are stitched together with adaptive questions as per the relevant syllabus.",
            "Clearer concepts lead to higher scores!Crafted this all-new feature will develop student's critical thinking abilities and strengthen their understanding of core concept.",
            "Adaptive, interactive tests that help students master each chapter. Recommended videos prompt students to correct mistakes in a practice session, enabling long lasting learning."
    };


    @Override
    public int getCount() {
        return slide_titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageview=(ImageView) view.findViewById(R.id.image);
        TextView slideTitle=(TextView) view.findViewById(R.id.title);
        TextView slideSubtitle=(TextView) view.findViewById(R.id.subtitle);

        slideImageview.setImageResource(slide_images[position]);
        slideTitle.setText(slide_titles[position]);
        slideSubtitle.setText(slide_subtitles[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
