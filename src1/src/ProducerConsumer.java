import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer{
    LinkedList<Integer> list= new LinkedList<Integer>();
    final int MAX_CAPACITY=10;

    public void producer() throws InterruptedException{
        Random r= new Random();
        while(true) {
            synchronized(this){
                if(list.size()<MAX_CAPACITY) {
                    list.add(r.nextInt(10));
                    System.out.println("Producer added an item. Queue size: "+list.size());
                    this.notify();
                }
                if(list.size()==MAX_CAPACITY){
                    this.wait();
                }
            }

        }
    }

    public void consumer() throws InterruptedException{
        Random r= new Random();
        while(true) {
            synchronized(this){
                if(list.size()>0) {
                    int value=list.removeFirst();
                    System.out.println("Consumer removed an item. Queue size: "+list.size());
                    this.notify();
                }
                if(list.size()==0){
                    this.wait();
                }
            }


        }
    }
}