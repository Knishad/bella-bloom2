package com.example.anew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    adapter adapter;
    private DaoEmployee dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);
        swipeRefreshLayout = findViewById(R.id.swip);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new adapter(this);
        recyclerView.setAdapter(adapter);

         dao=new DaoEmployee();
        loadData();


    }


    private void loadData() {


        dao.get().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Item> emps=new ArrayList<>();
                for(DataSnapshot data : snapshot.getChildren()){

                    Item emp=data.getValue(Item.class);
                    emp.setKey(data.getKey());
                    boolean add = emps.add(emp);
                    String key = data.getKey();
                }
                adapter.setItems(emps);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}