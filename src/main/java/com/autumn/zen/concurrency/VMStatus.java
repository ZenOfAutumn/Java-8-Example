package com.autumn.zen.concurrency;

/**
 * @since 2022-08-23
 */
public class VMStatus {



    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.currentThread().sleep(2);
                    }catch (Exception e) {

                    }
                }
            }
        };
        t.start();

    }
}


