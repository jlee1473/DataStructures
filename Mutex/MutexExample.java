package Mutex;

import java.util.Random;

/**
 * Mutex = Mutual Exclusion (Lock)
 */

public class MutexExample {
  public volatile int x;
  public volatile boolean mutex_x;

  public MutexExample() {
    x = 0;
    mutex_x = true;
  }

  public int addOne() throws InterruptedException {
    Thread.sleep(new Random().nextInt(500));
//    while (!mutex_x) {};
//    mutex_x = false;
    x = x + 1;
//    mutex_x = true;
    return x;
  }

  public int setToEight() throws InterruptedException {
    Thread.sleep(new Random().nextInt(500));
//    while (!mutex_x) {};
//    mutex_x = false;
    x = 8;
//    mutex_x = true;
    return x;
  }

  public void run() throws InterruptedException {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          setToEight();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          addOne();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.format("Value of x is: %d\n", x);
  }

  public static void main(String[] args) {
    MutexExample m = new MutexExample();
    try {
      for (int i = 0; i < 1000; i++) {
        m.run();
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
