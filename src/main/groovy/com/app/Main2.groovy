package com.app

class Main2 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            def _counter = new Counter(i)
            _counter.start()
        }
    }

    static class Counter extends Thread {

        int i;

        Counter(int i) {
            this.i = i
        }

        @Override
        void run() {
            println i
        }
    }}
