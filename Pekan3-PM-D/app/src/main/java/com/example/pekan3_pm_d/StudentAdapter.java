package com.example.pekan3_pm_d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private final ArrayList<Student> students;

    public StudentAdapter(ArrayList<Student> students) {
        this.students = students;
    }


    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position) {
        Student student = students.get(position);

        holder.ivImage.setImageResource(student.getImage());
        holder.tvName.setText(student.getName());
        holder.tvUniv.setText(student.getUniversity());
        holder.main.setOnClickListener(v->{
            Toast.makeText(holder.itemView.getContext(), student.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout main;
        TextView tvName, tvUniv;
        ImageView ivImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvUniv = itemView.findViewById(R.id.tv_univ);
            ivImage = itemView.findViewById(R.id.iv_image);
            main = itemView.findViewById(R.id.main);

        }
    }
}
