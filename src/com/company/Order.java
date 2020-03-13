package com.company;

public class Order {
    private Customer cust;
    private Book boo;
    private String state; //u - up, c - closed
    private int days;
    public Order(Customer cu, Book b, int d){
        this.cust = cu;
        this.boo = b;
        this.state = "u";
        if (d == 1) {
            this.boo.setState("r"); //Если выдается на день - то в чит зал
        }
        else {
            this.boo.setState("a"); //Если больше, то абонемент
        }
        this.days = d;
    }
    public void DayPassed(){
        this.days -= 1;
        if (this.days < 0) { //задерживает, минус к карме
            this.cust.setKarma(-1);
        }
    }
    public void Close(){
        this.boo.setState("i");
        if (this.days < 0) { //если опоздал, то уменьшаем карму
            this.cust.setKarma(0);
        }
        else {
            this.cust.setKarma(1);
        }
    }
}
