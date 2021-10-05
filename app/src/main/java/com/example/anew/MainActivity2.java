package com.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText txtName=findViewById(R.id.txtName);
        final EditText  txtPrice=findViewById(R.id.txtPrice);
        final  EditText txtSize=findViewById(R.id.txtSize);
        final EditText txtComposition=findViewById(R.id.txtComposition);

        Button submit=findViewById(R.id.submit);
        Button open=findViewById(R.id.open);
        open.setOnClickListener(V ->{
            Intent intent= new Intent (MainActivity2.this,RVActivity.class);
            startActivity(intent);
        });
        DaoEmployee dao=new DaoEmployee();
        Item edit = (Item) getIntent().getSerializableExtra("edit");


        if(edit!=null){
            submit.setText("update");
            txtName.setText(edit.getName());
            txtPrice.setText(edit.getPrice());
            txtSize.setText(edit.getSize());
            txtComposition.setText(edit.getComposition());
            open.setVisibility(View.GONE);
        }
       else{
           submit.setText("submit");
           open.setVisibility(View.VISIBLE);
        }



        submit.setOnClickListener(v -> {

            Item emp=new Item(
                    txtName.getText().toString(),
                    txtPrice.getText().toString(),
                    txtSize.getText().toString(),
                    txtComposition.getText().toString());

            if(edit==null) {
                dao.add(emp).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "item is inserted", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "item is not inserted", Toast.LENGTH_SHORT).show();
                });
            }
           /* Button open=findViewById(R.id.open);
            open.setOnClickListener(V ->{
                Intent intent= new Intent (MainActivity2.this,RVActivity.class);
                startActivity(intent);
            });*/
            /*open=(Button) findViewById(R.id.open);

            open.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openMainActivity3();
                }
            });



        }private void openMainActivity3() {
            Intent intent= new Intent(this ,MainActivity3.class);
            startActivity(intent);
        }*/

           /* HashMap<String,Object> hashMap =new HashMap<>();
            hashMap.put("name",txtName.getText().toString());
            hashMap.put("price",txtPrice.getText().toString());
            hashMap.put("size",txtSize.getText().toString());
            hashMap.put("composition",txtComposition.getText().toString());
            dao.update("-Ml91s_vejqa_jp0-_T_",hashMap).addOnSuccessListener(suc->
            {
                Toast.makeText(this,"item is updated",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
            {
                Toast.makeText(this,"item is not inserted",Toast.LENGTH_SHORT).show();
            });*/

           /* dao.remove("-Ml91s_vejqa_jp0-_T_").addOnSuccessListener(suc->
            {
                Toast.makeText(this,"item is removed",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->
            {
                Toast.makeText(this,"item is not inserted",Toast.LENGTH_SHORT).show();
            });*/
       else{
                HashMap<String,Object> hashMap =new HashMap<>();
                hashMap.put("name",txtName.getText().toString());
                hashMap.put("price",txtPrice.getText().toString());
                hashMap.put("size",txtSize.getText().toString());
                hashMap.put("composition",txtComposition.getText().toString());
                dao.update(edit.getKey(),hashMap).addOnSuccessListener(suc->
                {
                    Toast.makeText(this,"item is updated",Toast.LENGTH_SHORT).show();
                    finish();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this,"item is not inserted",Toast.LENGTH_SHORT).show();
                });
       }

        });
    }
}