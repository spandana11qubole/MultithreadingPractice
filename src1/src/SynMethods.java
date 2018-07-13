public class SynMethods{

    private int count=0;

    public synchronized void incrementCount() {
        count++;
    }

    public void temp() {
        for(int i=0;i<1000;i++) {
            incrementCount();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        SynMethods s =new SynMethods();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                s.temp();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                s.temp();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.print(s.count);

    }
}