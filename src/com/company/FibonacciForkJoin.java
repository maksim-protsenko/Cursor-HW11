package com.company;

import java.util.concurrent.ForkJoinTask;

public class FibonacciForkJoin extends ForkJoinTask<Long> {
    private int number;
    private Long sum;

    public FibonacciForkJoin(int number) {
        this.number = number;
    }

    @Override
    public Long getRawResult() {
        if (!isDone()) {
            return null;
        }
        return sum;
    }

    @Override
    protected void setRawResult(Long value) {
        this.sum = value;
    }

    @Override
    protected boolean exec() {
        FibonacciForkJoin firstTask = new FibonacciForkJoin(number - 1);
        FibonacciForkJoin secondTask = new FibonacciForkJoin(number - 2);
        firstTask.fork();
        sum = secondTask.invoke() + firstTask.join();
        return true;
    }

    private static long fibonacci(int number) {
        if (number <= 1) return number;
        else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
