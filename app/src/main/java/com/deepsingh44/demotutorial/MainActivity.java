package com.deepsingh44.demotutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get object of recyclerview
        recyclerView = findViewById(R.id.myrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        dummyData();
        MyAdaptyer myAdaptyer = new MyAdaptyer(students, R.layout.list_item);
        myAdaptyer.setDeepListener(new MyAdaptyer.DeepListener() {
            @Override
            public void studentItemClick(View view, int position) {
                Student std = students.get(position);
                Toast.makeText(MainActivity.this, std.getMarks() + "", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdaptyer);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.deep, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.list:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new MyAdaptyer(students, R.layout.list_item));
                break;
            case R.id.grid:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                recyclerView.setAdapter(new MyAdaptyer(students, R.layout.grid_item));
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    List<Student> students;

    private void dummyData() {
        students = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Student s1 = new Student();
            s1.setRoll(i + 1);
            s1.setName("Deep Singh" + i);
            s1.setMarks(67.8f + i);
            students.add(s1);
        }


    }


}
