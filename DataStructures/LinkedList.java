package DataStructures;

public class LinkedList {
  Node head;

  static class Node {
    int data;
    Node next;

    Node(int d) {
      this.data = d;
      next = null;
    }
  }

  public static LinkedList insert(LinkedList list, int data) {
    Node newNode = new Node(data);

    if (list.head == null) {
      list.head = newNode;
    } else {
      Node temp = list.head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
    return list;
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    for (int i = 1; i <= 10; i++) {
      list = insert(list, i);
    }

    Node printNode = list.head;
    System.out.print("DataStructures.LinkedList: ");

    while(printNode != null) {
      System.out.print(printNode.data + " ");
      printNode = printNode.next;
    }
  }

}
