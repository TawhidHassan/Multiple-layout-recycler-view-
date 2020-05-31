package com.example.multiple_layout_recyclerviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView2);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        List<ModelClass> modelClassesList=new ArrayList<>();

        modelClassesList.add(new ModelClass(0,R.drawable.ic_launcher_background,"sifat","sssssssss ss sss ssss sss sss"));
        modelClassesList.add(new ModelClass(1,"sifat ad"));
        modelClassesList.add(new ModelClass(0,R.drawable.ic_launcher_background,"sifat","sssssssss ss sss ssss sss sss"));
        modelClassesList.add(new ModelClass(2, R.drawable.ic_launcher_background));
        modelClassesList.add(new ModelClass(0,R.drawable.ic_launcher_background,"sifat","sssssssss ss sss ssss sss sss"));
        modelClassesList.add(new ModelClass(0,R.drawable.ic_launcher_background,"sifat","sssssssss ss sss ssss sss sss"));
        modelClassesList.add(new ModelClass(1,"sifat ad"));


        Adapter adapter=new Adapter(modelClassesList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
