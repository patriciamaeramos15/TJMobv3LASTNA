package ramos.pat.com.vieweventsfragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //list view per tab

    ListView list;
    String dates [] = {"Jan 01", "Jan 02", "Jan 14", "Feb 03", "Feb 14", "Feb 30", "Mar 03", "Mar 05"};
    String titles[] = {"Title One", "Title Two", "Title Three", "Title Four","Title Five","Title Six","Title Seven","Title Eight"};
    String descriptions[] = {"Description One...", "Description Two...", "Description Three...", "Description Four...","Description Five...","Description Six...","Description Seven...","Description Eight..."};


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private ViewPagerAdapter adapter;
    private TabLayout mTablayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create list view
        mTablayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.container);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        list = findViewById(R.id.list1);

        //create instance of class MyAdapter
        adapter.AddFragment(new Tab1(), "");
        adapter.AddFragment(new Tab2(), "");
        adapter.AddFragment(new Tab3(), "");
//        MyAdapter adapter = new MyAdapter(this, dates, titles, descriptions);
        mViewPager.setAdapter(adapter);
        mTablayout.setupWithViewPager(mViewPager);

        mTablayout.getTabAt(0);
        mTablayout.getTabAt(1);
        mTablayout.getTabAt(2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);


//        list.setAdapter(adapter);


        //handle item clicks
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position==0){
                    Toast.makeText(MainActivity.this, "Item One Clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position==1){
                    Toast.makeText(MainActivity.this, "Item Two Clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(MainActivity.this, "Item Three Clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position==3){
                    Toast.makeText(MainActivity.this, "Item Four Clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position==4){
                    Toast.makeText(MainActivity.this, "Item Five Clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position==5){
                    Toast.makeText(MainActivity.this, "Item Six Clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position==6){
                    Toast.makeText(MainActivity.this, "Item Seven Clicked...", Toast.LENGTH_SHORT).show();
                }
                if (position==7){
                    Toast.makeText(MainActivity.this, "Item Eight Clicked...", Toast.LENGTH_SHORT).show();
                }
            }
        });




        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
//        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    // list view adapter

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myDates[];
        String myTitles[];
        String myDescriptions[];

        MyAdapter(Context c, String[] dates, String[] titles, String[] descriptions){
            super(c,R.layout.row, R.id.text1, titles);
            this.context=c;
            this.myDates=dates;
            this.myTitles=titles;
            this.myDescriptions=descriptions;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            Button myDate = row.findViewById(R.id.button1);
            TextView myTitle = row.findViewById(R.id.text1);
            TextView myDescription = row.findViewById(R.id.text2);
            myDate.setText(dates[position]);
            myTitle.setText(titles[position]);
            myDescription.setText(descriptions[position]);
            return row;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   //deleted PlaceholderFragment class from here

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //Returning the current tabs
            switch (position) {
                case 0:
                    Tab1 tab1 = new Tab1();
                    return tab1;
                case 1:
                    Tab2 tab2 = new Tab2();
                    return tab2;
                case 2:
                    Tab3 tab3 = new Tab3();
                    return tab3;
                default:
                    return null;
            }
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "EVENTS";
                case 1:
                    return "UPCOMING";
                case 2:
                    return "ATTENDED";
            }
            return null;
        }
    }
}
