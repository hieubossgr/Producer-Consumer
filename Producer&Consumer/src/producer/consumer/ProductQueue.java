/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer.consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hieub
 */
public class ProductQueue<T> {
    private Queue<T> items = new LinkedList<>();
    private int compacity = 5;

    public ProductQueue() {
        for(int i=1; i<=3; i++) {
            items.add((T)("Item " + i));
        }
    }
    
    public ProductQueue(Queue<T> items, int compacity) {
        this.items = items;
        this.compacity = compacity;
    }

    public Queue<T> getItems() {
        return items;
    }

    public int getCompacity() {
        return compacity;
    }

    public void setCompacity(int compacity) {
        this.compacity = compacity;
    }
    
    public void put(T value, Queue<T> items) {
        synchronized(items) {
            if(items.size() >= compacity) {
                System.out.println("Queue fulled");
                try {
                    items.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProductQueue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            items.add(value);
            System.out.println("Add " + value);
            System.out.println("The number of products: " + getSizeItems());
    //        System.out.println("Compacity of products: " + getCompacity());
            System.out.println("---------------------------------------------------------------------------");
            items.notify();
        }
    }
    
    public void take(Queue<T> items) throws InterruptedException {
        synchronized(items) {
            System.out.println(Thread.currentThread().getName() + " is handling...");
            if(items.size()==0) {
                System.out.println("Queue empty");
                try {
                    items.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProductQueue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Remove " + items.poll() + " by " + Thread.currentThread().getName());
            System.out.println("The number of products: " + getSizeItems());
            System.out.println("---------------------------------------------------------------------------");
            if(items.size()>0) items.notify();
        }
    }
    
    public int getSizeItems() {
        return items.size();
    }
}
