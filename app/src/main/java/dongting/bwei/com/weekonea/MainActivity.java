package dongting.bwei.com.weekonea;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import dongting.bwei.com.weekonea.adapter.TabAdapter;

/**
 * 作者:${董婷}
 * 日期:2017/6/10
 * 描述:
 */
public class MainActivity extends FragmentActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        upwith();
    }

    private void upwith() {
        TabAdapter tabAdapter =new TabAdapter(getSupportFragmentManager());

        viewPager.setAdapter(tabAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors
                (getResources().getColor(R.color.title_color),getResources().getColor(R.color.colorAccent));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
