package DataStructures.BST;

public class Node<K extends Comparable<K>, V> {
  K key;
  V value;
  Node left, right, next, previous, tail;

//  Node[] children;
//  Node parent;

  public Node(K key, V value) {
    this.key = key;
    this.value = value;
  }
}
