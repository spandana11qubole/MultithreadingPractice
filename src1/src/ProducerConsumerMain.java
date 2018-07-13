public class ProducerConsumerMain {

        public static void main(String[] args) {

                ProducerConsumer pc = new ProducerConsumer();
                System.out.println("Initial queue size: "+pc.list.size());
                Thread t1 = new Thread(new Runnable(){
                        public void run() {
                                try {
                                        pc.producer();
                                } catch (InterruptedException e) {
                                        System.out.println("Producer failed");
                                        e.printStackTrace();
                                }
                        }
                });

                Thread t2 = new Thread(new Runnable(){
                        public void run() {
                                try {
                                        pc.consumer();
                                } catch (InterruptedException e) {
                                        System.out.println("Consumer failed");
                                        e.printStackTrace();
                                }
                        }
                });

                t1.start();
                t2.start();

                try {
                        t1.join();
                        t2.join();
                        ;
                } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                ;

        }
}