package com.company;

public class Customer {
    private String name;
    private int karma; // <0 - blaklisted

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public Customer(String n){
        this.name = n;
        this.karma = 0;
    }

    public void Show(){
        System.out.println(this.name + " : " + this.karma);
    }

}