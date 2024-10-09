package com.example.bottom_navigation;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import com.example.bottom_navigation.R;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {
    private ViewPager2 v_page;
    private BottomNavigationView bt_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        v_page=findViewById(R.id.view);
        bt_navigation=findViewById(R.id.bottom1);

        Fragment[] fragments = new Fragment[]{
                new HomeFragment(),
                new NewFragment(),
                new AccountFragment()
        };
        ViewpageAdapter adapter = new ViewpageAdapter(this, fragments);
        v_page.setAdapter(adapter);
        v_page.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bt_navigation.getMenu().findItem(R.id.menu_home1).setChecked(true);
                        break;
                    case 1:
                        bt_navigation.getMenu().findItem(R.id.menu_news1).setChecked(true);
                        break;
                    case 2:
                        bt_navigation.getMenu().findItem(R.id.menu_account1).setChecked(true);
                        break;
                }
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bt_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menu_home1) {
                    v_page.setCurrentItem(0);
                } else if (itemId == R.id.menu_news1) {
                    v_page.setCurrentItem(1);
                } else if (itemId == R.id.menu_account1) {
                    v_page.setCurrentItem(2);
                } else {
                    return false;  
                }

                return true;
            }
        });


    }
}