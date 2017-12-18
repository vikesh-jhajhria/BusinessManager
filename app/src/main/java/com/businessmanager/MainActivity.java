package com.businessmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.businessmanager.utils.Config.CUSTOMER;
import static com.businessmanager.utils.Config.EXPENSE;
import static com.businessmanager.utils.Config.PAYMENT;
import static com.businessmanager.utils.Config.REMINDER;
import static com.businessmanager.utils.Config.REPORT;
import static com.businessmanager.utils.Config.SERVICE;
import static com.businessmanager.utils.Config.WORK;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
        ((TextView) navigationView.getHeaderView(0).findViewById(R.id.txt_user_name)).setText(getIntent().getStringExtra("NAME"));
        ((TextView) navigationView.getHeaderView(0).findViewById(R.id.txt_contact)).setText(getIntent().getStringExtra("MOBILE"));

        setCurrentDate();
    }

    private void setCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMM, yyyy");
        String dateText = dateFormat.format(calendar.getTime());
        ((TextView) findViewById(R.id.txt_date)).setText(dateText);
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


    private void changeScreen(String name) {
        switch (name) {
            case CUSTOMER:
                startActivity(new Intent(MainActivity.this,CustomerActivity.class));
                break;
            case PAYMENT:
                startActivity(new Intent(MainActivity.this,PaymentActivity.class));
                break;
            case EXPENSE:
                startActivity(new Intent(MainActivity.this,ExpenseActivity.class));
                break;
            case SERVICE:
                startActivity(new Intent(MainActivity.this,ServicesActivity.class));
                break;
            case WORK:
                startActivity(new Intent(MainActivity.this,WorkActivity.class));
                break;
            case REPORT:
                startActivity(new Intent(MainActivity.this,ReportActivity.class));
                break;
            case REMINDER:
                startActivity(new Intent(MainActivity.this,ReminderActivity.class));
                break;
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_customers:
                changeScreen(CUSTOMER);
                break;
            case R.id.nav_payments:
                changeScreen(PAYMENT);
                break;
            case R.id.nav_expenses:
                changeScreen(EXPENSE);
                break;
            case R.id.nav_services:
                changeScreen(SERVICE);
                break;
            case R.id.nav_work:
                changeScreen(WORK);
                break;
            case R.id.nav_reports:
                changeScreen(REPORT);
                break;
            case R.id.nav_reminder:
                changeScreen(REMINDER);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
