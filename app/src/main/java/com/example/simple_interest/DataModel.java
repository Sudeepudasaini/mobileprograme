package com.example.simple_interest;

public class DataModel {
    private int id;
    private String name;
    private String address;

    public DataModel(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
}
