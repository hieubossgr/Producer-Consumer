/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumer;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author hieub
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProductQueue<String> productQueue = new ProductQueue<>();
    
        Producer producer = new Producer(productQueue);
        Consumer consumer = new Consumer(productQueue);

        Thread proThread = new Thread(producer);
        
        proThread.start();
        for(int i=0; i<4; i++) {
            new Thread(consumer).start();
            Thread.sleep(1200);
        }
        
//        while(true) {
//            new Thread(consumer).start();
//            if(productQueue.getSizeItems()==0)
//                Thread.sleep(ThreadLocalRandom.current().nextInt(2000,3000));
//            else if(productQueue.getSizeItems()==productQueue.getCompacity())
//                Thread.sleep(ThreadLocalRandom.current().nextInt(10000,15000));
//            else
//                Thread.sleep(ThreadLocalRandom.current().nextInt(3000,4500));
//        }
    }
}
