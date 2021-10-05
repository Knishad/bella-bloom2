package com.example.anew;

import android.content.ClipData;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DaoEmployee {

    private DatabaseReference databaseReference;


    public DaoEmployee(){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference =db.getReference(Item.class.getSimpleName());
    }
    public Task<Void> add(Item emp){


        return  databaseReference.push().setValue(emp);
    }



    public Task<Void> update(String key, HashMap<String,Object> hashMap){
        return databaseReference.child(key).updateChildren(hashMap);
    }

    public Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }

    public Query get(){

        /*if(key==null){
            return databaseReference.orderByKey().limitToFirst(8);
        }*/
        return databaseReference.orderByKey();}
    }

















