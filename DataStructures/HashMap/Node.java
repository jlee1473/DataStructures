package DataStructures.HashMap;

public class Node<K, V>{
  K key;
  V value;

  Node parent;
  Node left, right;

  Node next;


  int hashCode;

  public Node(Node parent, K key, V value) {
    this.key = key;
    this.value = value;
    left = right = null;
  }

  public Node(K key, V value) {
   this.key = key;
   this.value = value;
  }

  public Node(K key, V value, int hashCode) {
   this.key = key;
   this.value = value;
   this.hashCode = hashCode;
  }

  public K getKey() {
   return this.key;
  }

 public Node getLeft() {
  return this.left;
 }

 public void setLeft(Node left) {
  this.left = left;
 }

 public Node getRight() {
  return this.right;
 }

 public void setRight(Node right) {
  this.right = right;
 }
}
