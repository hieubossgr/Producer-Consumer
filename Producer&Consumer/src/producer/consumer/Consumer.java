/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumer;

/**
 *
 * @author hieub
 */
public class Consumer implements Runnable{
    private ProductQueue<String> productQueue;

    public Consumer(ProductQueue<String> productQueue) {
        this.productQueue = productQueue;
    }
    
    @Override
    public void run() {
        System.out.println("Consumer is getting item");
        productQueue.Take();
        System.out.println("Consumer done");
        System.out.println("---------------------------------------------------------------------------");
    }
    
}
