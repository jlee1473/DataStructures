package DesignPattern.IteratableIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CustomIterable<T> implements Iterable<T> {
  List<T> values = new ArrayList<>();

  public void add(T value) {
    values.add(value);
  }

  @Override
  public Iterator<T> iterator() {
    return new CustomIterator<T>(values);
  }

  public class CustomIterator<E> implements Iterator<E> {

    List<E> data;
    int position = 0;

    public CustomIterator(List<E> data) {
      this.data = data;
    }

    @Override
    public boolean hasNext() {
      return data.size() > position;
    }

    @Override
    public E next() {
      E nextValue = this.data.get(position);
      position++;
      return nextValue;
    }
  }
}

class Node <T> {
  private Node next;
  private Node prev;
  private T data;

  public Node getNext() {
    return next;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }
}

class CustomLinkedList<T> implements Iterable<Node> {
  private Node first;
  private Node last;

  public CustomLinkedList() {
    first = last = null;
  }

  public boolean isEmpty(){
    return first == null;
  }

  public void push(T data) {
    Node temp = new Node();
    temp.setData(data);
    temp.setNext(null);

    if (first == null) {
      temp.setPrev(null);
      first = last = temp;
    } else {
      temp.setPrev(last);
      last.setNext(temp);
      last = temp;
    }
  }

  @Override
  public Iterator<Node> iterator() {
    return new ListIterator(first);
  }

  public class ListIterator implements Iterator<Node> {
    private Node current;

    public ListIterator(Node first) {
      current = first;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Node next() {
      Node temp = current;
      current = current.getNext();
      return temp;
    }
  }
}


public class IterableIterator {
  public static void main(String[] args) {
    CustomIterable<Integer> integers = new CustomIterable<>();
    integers.add(1);
    integers.add(2);
    integers.add(3);
    integers.add(4);

    CustomLinkedList<String> strings = new CustomLinkedList<>();
    strings.push("Hello");
    strings.push("world!");

    for (Integer integer : integers)
      System.out.println(integer);

    for (Node n : strings)
      System.out.println(n.getData());
  }
}
