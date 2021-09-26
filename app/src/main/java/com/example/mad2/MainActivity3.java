package com.example.mad2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
    private Button total1;
    EditText txtName,txtPrice,txtSize,txtComposition;
    Button save,update,delete,view;


    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        txtName=findViewById(R.id.txtName);
        txtPrice=findViewById(R.id.txtPrice);
        txtSize=findViewById(R.id.txtSize);
        txtComposition=findViewById(R.id.txtComposition);

        save=findViewById(R.id.save);

        db= FirebaseDatabase.getInstance().getReference().child("Item");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStudentData();
            }
        });
    }

    private void insertStudentData(){
        try{
            if(TextUtils.isEmpty(txtName.getText().toString().trim())){
                Toast.makeText(getApplicationContext(),"Please enter the name",Toast.LENGTH_LONG).show();
            }else if(TextUtils.isEmpty(txtPrice.getText().toString().trim())){
                Toast.makeText(getApplicationContext(),"Please enter the price",Toast.LENGTH_LONG).show();
            }else if(TextUtils.isEmpty(txtSize.getText().toString().trim())){
                Toast.makeText(getApplicationContext(),"Please enter the size",Toast.LENGTH_LONG).show();
            }else if(TextUtils.isEmpty(txtComposition.getText().toString().trim())){
                Toast.makeText(getApplicationContext(),"Please enter the composition",Toast.LENGTH_LONG).show();
            }else{
        String Name= txtName.getText().toString();
        String Price= txtPrice.getText().toString();
        String Size= txtSize.getText().toString();
        String Composition= txtComposition.getText().toString();

        Item item=new Item(Name,Price,Size,Composition);

        db.push().setValue(item);
        Toast.makeText(MainActivity3.this,"suceessfully added",Toast.LENGTH_LONG).show();

    }
        }catch(NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Number Format Exception", Toast.LENGTH_LONG).show();
        }

    //public void save(View view) {
   // }
}}