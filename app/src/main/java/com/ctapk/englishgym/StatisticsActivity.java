package com.ctapk.englishgym;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StatisticsActivity extends AppCompatActivity {

//    private TextView mTextMessage;
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.navigation_learn:
//                    mTextMessage.setText(R.string.title_learn);
//                    return true;
//                case R.id.navigation_stories:
//                    mTextMessage.setText(R.string.title_stories);
//                    return true;
//                case R.id.navigation_statistics:
//                    mTextMessage.setText(R.string.title_statistics);
//                    return true;
//                case R.id.navigation_settings:
//                    mTextMessage.setText(R.string.title_settings);
//                    return true;
//            }
//            return false;
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        setAppBarTitle(R.string.title_activity_statistics);
        setDayWeekIcons();
        setTodayValues();
//        BottomNavigationView navView = findViewById(R.id.bottom_nav);
//        mTextMessage = findViewById(R.id.message);
//        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // Т.к layout простой - pager можно не использовать

        final TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Today"));
        tabLayout.addTab(tabLayout.newTab().setText("Total"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            // можно просто устанавливать нужные значение, но лучше добавить еще лэйаут карт
            // и просто менять видимость
            public void onTabSelected(TabLayout.Tab tab) {
                if (tabLayout.getSelectedTabPosition() == 0) {
                    setTodayValues();
                    Toast.makeText(StatisticsActivity.this, "Tab " + tabLayout.getSelectedTabPosition(), Toast.LENGTH_LONG).show();
                } else {
                    setTotalValues();
                    Toast.makeText(StatisticsActivity.this, "Tab " + tabLayout.getSelectedTabPosition(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void setDayWeekIcons() {
    }

    private void setTotalValues() {
    }

    private void setTodayValues() {
    }

    public void setAppBarTitle(int title) {
        TextView textView = new TextView(this);
        textView.setText(title);
        textView.setTextSize(20);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.white));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(textView);
        getSupportActionBar().setElevation(0);
    }

}
