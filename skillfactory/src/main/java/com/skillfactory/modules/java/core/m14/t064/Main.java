package com.skillfactory.modules.java.core.m14.t064;

public class Main {


    public static void main(String[] args) throws InterruptedException{

        Pizzeria pizzeria = new Pizzeria();
        pizzeria.order("Margarita");
        Thread.sleep(100);
        pizzeria.order("Pepperoni");
        Thread.sleep(100);
        pizzeria.order("Sicilian");
        Thread.sleep(100);
        pizzeria.order("Greek");

    }

}

