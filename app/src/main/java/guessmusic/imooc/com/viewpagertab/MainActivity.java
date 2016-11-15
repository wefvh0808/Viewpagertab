package guessmusic.imooc.com.viewpagertab;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<PageView> pageList ;
    private TabLayout mtablelayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initdata();//初始化數據pageList
        InitView();//初始化view

    }

    private void Initdata() {
        pageList = new ArrayList<>();
        pageList.add(new PageOne(MainActivity.this));
        pageList.add(new PageTwo(MainActivity.this));
        pageList.add(new PageThree(MainActivity.this));
    }

    private void InitView() {
        mtablelayout = (TabLayout) findViewById(R.id.tabs);
        mtablelayout.addTab(mtablelayout.newTab().setText("pager one"));
        mtablelayout.addTab(mtablelayout.newTab().setText("pager two"));
        mtablelayout.addTab(mtablelayout.newTab().setText("pager three"));

        mViewPager= (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new adapter());//extends pageradapter
        initListener();
    }
    private void initListener() {
        mtablelayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());//viewpager畫面
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtablelayout));
    }
    private class adapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;//
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pageList.get(position));
            return pageList.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
}




