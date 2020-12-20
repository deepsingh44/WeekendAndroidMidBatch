package com.deepsingh44.demotutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdaptyer extends RecyclerView.Adapter<MyAdaptyer.MyViewHolder> {
    private List<Student> students;
    private int myview;
    DeepListener deepListener;

    public MyAdaptyer(List<Student> students, int myview) {
        this.students = students;
        this.myview = myview;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(myview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student std = students.get(position);
        holder.tname.setText(std.getName());
        holder.troll.setText(String.valueOf(std.getRoll()));
        holder.tmarks.setText(String.valueOf(std.getMarks()));
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tname, tmarks, troll;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tname = itemView.findViewById(R.id.name);
            troll = itemView.findViewById(R.id.roll);
            tmarks = itemView.findViewById(R.id.marks);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            deepListener.studentItemClick(v, getAdapterPosition());
        }
    }

    public void setDeepListener(DeepListener deepListener) {
        this.deepListener = deepListener;
    }

    public interface DeepListener {
        void studentItemClick(View view, int position);
    }
}
