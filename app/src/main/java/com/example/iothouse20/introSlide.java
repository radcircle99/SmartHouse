package com.example.iothouse20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.iothouse20.Adapter.MpagerAdapteur;
import com.example.iothouse20.Adapter.PreferenceManager;

public class introSlide extends AppCompatActivity implements View.OnClickListener{

 private ViewPager mPager;
 private int [] layouts = {R.layout.first_slide,R.layout.second_slide};
 private MpagerAdapteur mpagerAdapteur;

 private LinearLayout Dots_Layout;
 private ImageView[] dots;
private Button BtnNxt,BtnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(new PreferenceManager(this).checkPreferences())
        {
            loadHome();
        }

        if (Build.VERSION.SDK_INT >=19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else
        {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setContentView(R.layout.activity_intro_slide);

        mPager = (ViewPager)findViewById(R.id.viewPager);
        mpagerAdapteur =new MpagerAdapteur(layouts,this);
        mPager.setAdapter(mpagerAdapteur);

        Dots_Layout=(LinearLayout)findViewById(R.id.dotsLayout);
        createDots(0);
        BtnNxt=(Button) findViewById(R.id.btnNext);
        BtnSkip=(Button)findViewById(R.id.btnSkip);
        BtnSkip.setOnClickListener(this);
        BtnNxt.setOnClickListener(this);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
                if(position == layouts.length-1)
                {
                    BtnNxt.setText("Lancer");
                    BtnSkip.setVisibility(View.INVISIBLE);
                }
                else
                {
                    BtnNxt.setText("Suivant");
                    BtnSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createDots(int current_position)
    {
        if(Dots_Layout!=null)
            Dots_Layout.removeAllViews();
        dots =new ImageView[layouts.length];
        for (int i=0;i<layouts.length;i++)
        {
            dots[i] =new ImageView(this);
            if(i==current_position)
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dots_selected));
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.dots_default));
            }
            LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);

            Dots_Layout.addView(dots[i],params);
        }
    }

    @Override
    public void onClick(View v) {
        switch ((v.getId()))
        {
            case R.id.btnNext:
                loadNextSlide();
                break;
            case R.id.btnSkip:
                loadHome();
                new PreferenceManager(this).writePreference();
                break;
        }
    }
    private void loadHome()
    {
        startActivity(new Intent(this,Activity1.class));
        finish();
    }
    private void loadNextSlide()
    {
        int next_slide = mPager.getCurrentItem()+1;

        if(next_slide<layouts.length)
        {
            mPager.setCurrentItem(next_slide);
        }
        else
        {
            loadHome();
            new PreferenceManager(this).writePreference();
        }
    }
}
