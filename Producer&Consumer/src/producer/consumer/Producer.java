/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author hieub
 */
public class Producer implements Runnable {
    
    private ProductQueue<String> productQueue;

    public Producer(ProductQueue<String> productQueue) {
        this.productQueue = productQueue;
    }
    
    @Override
    public void run() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                int number = ThreadLocalRandom.current().nextInt(1, 10);
                productQueue.Put("item " + number);
                System.out.println("---------------------------------------------------------------------------");
            }
        };
        Timer time = new Timer("Timer");
        time.schedule(timerTask, 0, 5000);
    }
    
}
