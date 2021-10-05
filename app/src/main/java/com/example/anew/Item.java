package com.example.anew;

import com.google.firebase.database.Exclude;

public class Item {

    @Exclude
    private String key;
    private String Name;
    private String Price;
    private String size;
    private String composition;
   public Item(){}
    public Item(String name, String price, String size, String composition) {
        Name = name;
        Price = price;
        this.size = size;
        this.composition = composition;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
