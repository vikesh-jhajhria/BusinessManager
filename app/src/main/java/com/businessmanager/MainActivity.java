package com.businessmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.businessmanager.fragments.HomeFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String HOME = "HOME";
    public static final String CUSTOMER = "CUSTOMER";
    public static final String PAYMENT = "PAYMENT";
    public static final String EXPENSE = "EXPENSE";
    public static final String SERVICE = "SERVICE";
    public static final String WORK = "WORK";
    public static final String REPORT = "REPORT";
    public static final String REMINDER = "REMINDER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setCurrentDate();
    }

    private void setCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy");
        String dateText = dateFormat.format(calendar.getTime());
        ((TextView)findViewById(R.id.txt_date)).setText(dateText);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void addFragment(String name) {
        /*Fragment fragment;
        switch (name) {
            case HOME:
                fragment = HomeFragment.newInstance("");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frame_main, fragment, "home_fragment")
                        .commit();
                break;
            case CUSTOMER:
                fragment = HomeFragment.newInstance("");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frame_main, fragment, "customer_fragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case PAYMENT:
                fragment = HomeFragment.newInstance("");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frame_main, fragment, "payment_fragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case EXPENSE:
                fragment = HomeFragment.newInstance("");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frame_main, fragment, "expense_fragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case SERVICE:
                fragment = HomeFragment.newInstance("");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frame_main, fragment, "service_fragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case WORK:
                fragment = HomeFragment.newInstance("");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frame_main, fragment, "work_fragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case REPORT:
                fragment = HomeFragment.newInstance("");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frame_main, fragment, "report_fragment")
                        .addToBackStack(null)
                        .commit();
                break;
            case REMINDER:
                fragment = HomeFragment.newInstance("");
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.frame_main, fragment, "reminder_fragment")
                        .addToBackStack(null)
                        .commit();
                break;

        }*/
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                addFragment(HOME);
                break;
            case R.id.nav_customers:
                addFragment(CUSTOMER);
                break;
            case R.id.nav_payments:
                addFragment(PAYMENT);
                break;
            case R.id.nav_expenses:
                addFragment(EXPENSE);
                break;
            case R.id.nav_services:
                addFragment(SERVICE);
                break;
            case R.id.nav_work:
                addFragment(WORK);
                break;
            case R.id.nav_reports:
                addFragment(REPORT);
                break;
            case R.id.nav_reminder:
                addFragment(REMINDER);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
