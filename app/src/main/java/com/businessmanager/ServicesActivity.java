package com.businessmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.businessmanager.adapter.ServiceAdapter;
import com.businessmanager.model.ServiceModel;

import java.util.ArrayList;

public class ServicesActivity extends BaseActivity {

    private ArrayList<ServiceModel> serviceList;
    private ServiceAdapter serviceAdapter;
    private RecyclerView recyclerView;
    private RelativeLayout emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("Service");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(ServicesActivity.this, AddServiceActivity.class),100);
            }
        });

        emptyView = findViewById(R.id.empty_view);

        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        serviceList = new ArrayList<>();
        serviceAdapter = new ServiceAdapter(this, serviceList);
        recyclerView.setAdapter(serviceAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < 20; i++) {
            ServiceModel model = new ServiceModel();
            model.setName("name" + i);
            model.setUnit("unit" + i);
            model.setRate("100" + i);
            model.setValidityFrom("01/01/201" + i);
            if (i % 2 == 0) {
                model.setValidityTo("01/01/201" + i);
                model.setActive(false);
            } else {
                model.setActive(true);
            }
            serviceList.add(model);
        }
        if (serviceList.size() > 0) {
            emptyView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            emptyView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
        serviceAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
