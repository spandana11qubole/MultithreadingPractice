public class SingletonPattern{

    private SingletonPattern instance= new SingletonPattern();

    private SingletonPattern() {}

    //Basic implementation
    //unnecessary initialization;
    public SingletonPattern getInstance1() {
        return instance;
    }

    //avoids unnecessary initialization
    //Multithread issues
    public SingletonPattern getInstance2() {
        if(instance==null) {
            //add
            //instance= new SingletonPattern();
        }
        return instance;
    }

    //handles multithreading case
    public synchronized SingletonPattern getInstance3() {
        if(instance==null) {
            //add
            //instance= new SingletonPattern();
        }
        return instance;
    }

}
