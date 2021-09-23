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
    private int compacity = 3;

    public ProductQueue() {
        for(int i=1; i<=2; i++) {
            items.add((T)("Number " + i));
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
    
    public synchronized void Put(T value) {
        
        while(items.size() == compacity) {
            System.out.println("Queue fulled");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ProductQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        items.add(value);
        System.out.println("Add " + value);
        System.out.println("The number of products: " + getSizeItems());
        System.out.println("Compacity of products: " + getCompacity());
        notifyAll();
    }
    
    public synchronized void Take() {
        while(items.size()==0) {
            System.out.println("Queue empty");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(ProductQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Remove " + items.poll());
        System.out.println("The number of products: " + getSizeItems());
        notifyAll();
    }
    
    public int getSizeItems() {
        return items.size();
    }
}
