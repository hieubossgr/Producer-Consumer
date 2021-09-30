/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumer;

import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author hieub
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProductQueue<String> productQueue = new ProductQueue<>();
    
        Producer producer = new Producer(productQueue);
        Consumer consumer1 = new Consumer(productQueue);
        Consumer consumer2 = new Consumer(productQueue);
        Consumer consumer3 = new Consumer(productQueue);
        Consumer consumer4 = new Consumer(productQueue);


        Thread proThread = new Thread(producer);
        Thread con1 = new Thread(consumer1);
        Thread con2 = new Thread(consumer2);
        Thread con3 = new Thread(consumer2);
        Thread con4 = new Thread(consumer2);

        con1.setName("Consumer 1");
        con2.setName("Consumer 2");
        con3.setName("Consumer 3");
        con4.setName("Consumer 4");
        
        proThread.start();
        con1.start();
        con2.start();
        con3.start();
        con4.start();
        
    }
}
