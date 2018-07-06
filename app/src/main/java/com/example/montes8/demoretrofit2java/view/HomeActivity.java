package com.example.montes8.demoretrofit2java.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.montes8.demoretrofit2java.R;
import com.example.montes8.demoretrofit2java.adapter.ListaproductosAdapter;
import com.example.montes8.demoretrofit2java.model.Producto;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<Producto> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListaproductosAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        recyclerView = (RecyclerView) findViewById(R.id.homeToolbar);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);


        mAdapter.addList();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
