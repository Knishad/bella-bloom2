package com.example.mad2;

public class Item {
    private String Name;
    private String Price;
    private String size;
    private String composition;


    public Item(String name, String price, String size, String composition) {
        Name = name;
        Price = price;
        this.size = size;
        this.composition = composition;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public String getSize() {
        return size;
    }

    public String getComposition() {
        return composition;
    }
}