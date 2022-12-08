package DesignPattern.Observer;

import java.util.ArrayList;

abstract class AbstractObservable {
  ArrayList<Subscriber> observers;
  public abstract void registerObserver(Subscriber observer);
  public abstract void unregisterObserver(Subscriber observer);
  public abstract void notifyObservers(String msg);
}

abstract class AbstractObserver {
  public abstract String update(String msg);
}

class Publisher extends AbstractObservable {

  public Publisher() {
    this.observers = new ArrayList<Subscriber>();
  }

  @Override
  public void registerObserver(Subscriber observer) {
    this.observers.add(observer);
  }

  @Override
  public void unregisterObserver(Subscriber observer) {
    this.observers.remove(observer);
  }

  @Override
  public void notifyObservers(String msg) {
    for (Subscriber sub : this.observers) {
      sub.update(msg);
    }
  }
}
class Subscriber extends AbstractObserver {
  String lastMsg;
  @Override
  public String update(String msg) {
    lastMsg = msg;
    String ret = String.format("%s: %s\n", this.toString(), msg);
    System.out.println(ret);
    return ret;
  }
}

public class Observer {
  public static void main(String[] args) {
    Publisher publisher = new Publisher();
    for (int i = 0; i < 4; i++) {
      publisher.registerObserver(new Subscriber());
    }
    publisher.notifyObservers("Hello!");
    publisher.notifyObservers("World!");
  }
}
