package com.example.anew;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeVH extends RecyclerView.ViewHolder {

    public TextView txtName,txtPrice,txtSize,txtComposition,option;

    public EmployeeVH(@NonNull View itemView) {
        super(itemView);
         txtName=itemView.findViewById(R.id.txtName);
         txtPrice=itemView.findViewById(R.id.txtPrice);
         txtSize=itemView.findViewById(R.id.txtSize);
         txtComposition=itemView.findViewById(R.id.txtComposition);
         option=itemView.findViewById(R.id.option);
    }
}
