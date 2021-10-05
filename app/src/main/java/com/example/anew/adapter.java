package com.example.anew;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    ArrayList<Item> list=new ArrayList<>();
    public adapter(Context ctx){

        this.context =ctx;
    }


    public void setItems(ArrayList<Item> emp){

        list.addAll(emp);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
     return new EmployeeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
          EmployeeVH vh =(EmployeeVH) holder;
          Item emp=list.get(position);
          vh.txtName.setText(emp.getName());
        vh.txtPrice.setText(emp.getPrice());
        vh.txtSize.setText(emp.getSize());
        vh.txtComposition.setText(emp.getComposition());
        vh.option.setOnClickListener(v ->{


            PopupMenu popupMenu=new PopupMenu(context,vh.option);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item ->{
             switch(item.getItemId()){


                 case R.id.edit:
                 Intent intent=new Intent(context,MainActivity2.class);
            intent.putExtra("edit", (Serializable) emp);
                 context.startActivity(intent);
                 break;
                 case R.id.remove:
                     DaoEmployee dao=new DaoEmployee();
                 dao.remove(emp.getKey()).addOnSuccessListener(suc->
                 {
                     Toast.makeText(context,"item is removed",Toast.LENGTH_SHORT).show();
                     notifyItemRemoved(position);
                 }).addOnFailureListener(er ->
                 {
                     Toast.makeText(context,"item is not inserted",Toast.LENGTH_SHORT).show();
                 });
                  break;
             }
             return false;
            });
            popupMenu.show();
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
