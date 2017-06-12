package dongting.bwei.com.weekonea.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dongting.bwei.com.weekonea.fragment.AFragment;
import dongting.bwei.com.weekonea.fragment.BFragment;

/**
 * 作者:${董婷}
 * 日期:2017/6/10
 * 描述:
 */

public class TabAdapter extends FragmentPagerAdapter {
    String[] titles=new String[]{"一","二","三","四","五","六","七","八","九","十"};

    public TabAdapter(FragmentManager fragmentManager){
        super(fragmentManager);

    }

    @Override
    public Fragment getItem(final int position) {

        if(position==0){
            return new AFragment();
        }else if(position==1){
            return new BFragment();
        }
        return new AFragment();
    }

    @Override
    public int getCount() {

            return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

            return titles[position];

    }
}
