package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Book books[] = new Book[5]; //Заранее создан каталог книг
        books[0] = new Book("Dictionary", 1000);
        books[1] = new Book("Red Book", 200);
        books[2] = new Book("Hobbit", 300);
        books[3] = new Book("C S Lewis full b1", 610);
        books[4] = new Book("C S Lewis full b2", 593);
        Customer customers[] = new Customer[5]; //Заранее есть неск читателей
        customers[0] = new Customer("Lord Weeblesnotch");
        customers[1] = new Customer("Mrs Burpple");
        customers[2] = new Customer("Mr Greensnot");
        customers[3] = new Customer("Mr Nerdwimp");
        Order orders[] = new Order[10]; //Допустим, нам хватит 10 заказов

        //Работа с вводом
        System.out.println("_____Welcome to the library______");
        System.out.println("Enter your name");
        String name = scan.nextLine();
        customers[4] = new Customer(name); //Создаем пользователя
        System.out.println("Welcome, your stats are:");
        customers[4].Show();
        String t;
        int i = 0; //id заказов
        while (true) {
            System.out.println("enter");
            System.out.println("o - to send an order");
            System.out.println("s - to show your stats");
            System.out.println("p - to pass the day");
            System.out.println("c - to close an order");
            System.out.println("q - to quit");
            t = scan.nextLine();
            if (t.equals("q")) {
                break;
            }
            if (t.equals("o")) {
                if (customers[4].getKarma() < 0) { //Блочим должника
                    //Решил не делать черный список отд списком - юзеров с негативной кармой можно найти и вывести
                    System.out.println("YOU ARE BLACKLISTED!");
                    break;
                }
                System.out.println("What is the book in question?");
                String bname = scan.nextLine();
                int ds;
                int bk = -1;
                for (int j = 0; j < books.length; j++) { //Ищем книгу в каталоге
                    if (books[j].getName().equals(bname)) {
                        bk = j;
                    }
                }
                if (bk > -1) { //Узнаем, как долго держим книгу. Если день - читзал, больше - абонемент
                    System.out.println("For how long shall you keep it?");
                    ds = scan.nextInt();
                }
                else { //Не нашли книгу
                    System.out.println("No such book! Flip off!");
                    break;
                }
                orders[i] = new Order(customers[4], books[bk], ds); //Заказ создан
                System.out.println("Posted an order with id = " + i);
                i++;
            }
            if (t.equals("s")) { //Инфа юзера
                customers[4].Show();
            }
            if (t.equals("c")) { //Закрытие заказа - возврат книги
                System.out.println("Type in an id of the order you want closed");
                int id = scan.nextInt();
                orders[id].Close();
            }
            if (t.equals("p")) {
                for (int j = 0; j < i; j++) { //Всем заказам сообщаем, что день прошел
                    orders[j].DayPassed();
                }
            }
        }
    }
}
