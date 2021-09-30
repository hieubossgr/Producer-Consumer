/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hieub
 */
public class Producer implements Runnable {
    
    private final ProductQueue<String> productQueue;

    public Producer(ProductQueue<String> productQueue) {
        this.productQueue = productQueue;
    }
    
    @Override
    public void run() {
        while(true) {
            int number = ThreadLocalRandom.current().nextInt(1, 10);
            productQueue.put("item " + number);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                int number = ThreadLocalRandom.current().nextInt(1, 10);
//                productQueue.put("item " + number);
//                System.out.println("---------------------------------------------------------------------------");
//            }
//        };
//        Timer time = new Timer("Timer");
//        time.schedule(timerTask, 0, 2000);
    }
    
}
