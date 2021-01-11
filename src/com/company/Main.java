package com.company;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        Date startOfComputing = new Date();
        System.out.println("Computing of 50th fibonacci number have started. Please, wait!");
        FibonacciForkJoin fibonacci = new FibonacciForkJoin(50);
        System.out.println("50th fibonacci number is " + new ForkJoinPool().invoke(fibonacci));
        Date endOfComputing = new Date();
        System.out.println(((endOfComputing.getTime() - startOfComputing.getTime()) * 0.001) + " seconds wasted for it");
    }
}

