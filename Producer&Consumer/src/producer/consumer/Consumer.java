/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hieub
 */
public class Consumer implements Runnable{
    private final ProductQueue<String> productQueue;

    public Consumer(ProductQueue<String> productQueue) {
        this.productQueue = productQueue;
    }
    
    @Override
    public void run() {
        while(true) {
            productQueue.take();
            int timeSleep = ThreadLocalRandom.current().nextInt(6000, 10000);
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
