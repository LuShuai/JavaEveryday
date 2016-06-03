package thread;

/**
 * Created by shuailu on 4/13/16.
 */
public class HelloThread {

    private static final int SECOND = 1000;

    static class ThreadRun implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1 * SECOND);
                System.out.println("Thread!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class HelloRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello, ");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadRun());
        Thread t2 = new Thread(new HelloRun());
        t1.start();
        t2.start();
    }


}
