package DataStructures.HashMap;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This data structure use a custom hashmap structure
 * to store key and value with linkedlist.
 *
 * @author gareth, linh
 * @version 2.0
 *
 * @param <K> key.
 * @param <V> value.
 */
public class HashMap<K, V> implements IKeyValueStore<K, V> {
  /**
   * Push adds an item to the implementing data structure.
   *
   * @param key   is what is used to index values
   * @param value is what is stored
   */

  private ArrayList<Node> bucketArray;
  private int capacity;
  private int size;

  /**
   * Constructor for MyDataStructure.
   */
  public HashMap() {

    bucketArray = new ArrayList<>();
    capacity = 10;
    size = 0;
    for (int i = 0; i < capacity; i++) {
      bucketArray.add(null);
    }

  }

  /**
   * This function return the size of this
   * data structure.
   *
   *@return int size.
   */
  public int size() {
    return size;
  }

  /**
   * A utility function that turn key
   * variable into hashcode.
   *
   * @param key code.
   * @return hashcode.
   */
  private final int hashCode(K key) {
    return Objects.hashCode(key);
  }

  /**
   * This function is use to find the
   * index for they key param.
   *
   * @param key code.
   * @return index number.
   */
  private int getBucketIndex(K key) {
    int hashCode = hashCode(key);
    int index = hashCode % capacity;

    if (index < 0) {
      index = index * -1;
    }
    return index;
  }


  /**
   * Insertion to data structure method.
   *
   * @param key is what is used to index values
   * @param value is what is stored
   */
  @Override
  public void push(K key, V value) {

    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);
    Node head = bucketArray.get(bucketIndex);

    while (head != null) {
      if (head.key.equals(key) && head.hashCode == hashCode) {
        head.value = value;
        return;
      }
      head = head.next;
    }
    size++;
    head = bucketArray.get(bucketIndex);
    Node newNode = new Node(key, value, hashCode);
    newNode.next = head;
    bucketArray.set(bucketIndex, newNode);

    increaseCapacity();
  }

  /**
   * This function increase the capacity of the arraylist
   * if its filled 80% or more.
   */
  private void increaseCapacity() {
    if ((1.0 * size) / capacity >= 0.8) {
      ArrayList<Node> temp = bucketArray;
      bucketArray = new ArrayList<>();
      capacity = 2 * capacity;
      size = 0;

      for (int i = 0; i < capacity; i++) {
        bucketArray.add(null);
      }

      for (Node headNode : temp) {
        while (headNode != null) {
          push((K) headNode.key, (V) headNode.value);
          headNode = headNode.next;
        }
      }
    }

  }

  /**
   * Get retrieves a value given a key.
   *
   * @param key is used to index values
   * @return the value
   */
  @Override
  public <V> V get(K key) {

    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);

    Node head = bucketArray.get(bucketIndex);

    while (head != null) {
      if (head.key.equals(key) && head.hashCode == hashCode) {
        return (V) head.value;
      }
      head = head.next;
    }
    return null;

  }

  /**
   * Gets the whole node rather than the value.
   *
   * @param key is used to index the values (and nodes)
   */
  @Override
  public Node getNode(K key) {
    int bucketIndex = getBucketIndex(key);
    int hashCode = hashCode(key);

    Node head = bucketArray.get(bucketIndex);

    while (head != null) {
      if (head.key.equals(key) && head.hashCode == hashCode) {
        return head;
      }
      head = head.next;
    }
    return null;
  }

  /**
   * Clear removes all items from the data structure.
   */
  @Override
  public void clear() {
    int length = bucketArray.size();

    for (int i = 0; i < length; i++) {
      bucketArray.set(i, null);
    }

  }
}