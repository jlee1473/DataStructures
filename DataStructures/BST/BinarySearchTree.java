package DataStructures.BST;

public class BinarySearchTree<K extends Comparable<K>, V> implements IKeyValueStore<K, V>{

  public Node root;
  public BinarySearchTree() {
    root = null;
  }
  @Override
  /**
   * Push adds an item to the implementing data structure.
   *
   * @param key   is what is used to index values
   * @param value is what is stored
   */
  public void push(K key, V value) {
//    insertRec(root,(K) key,(V) value);
    Node node = new Node(key, value);

    if(root == null) {
      root = node;
    } else {
      Node current = root;
      Node temp;

      while(true) {
        temp = current;

        if(key.compareTo((K)current.key) < 0) {
          current = current.left;
          if(current == null) {
            temp.left = node;
            return;
          }
        } else {
          current = current.right;
          if(current == null) {
            temp.right = node;
            return;
          }
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

    Node node = getNode(key);
    return (V)node.value;
  }

  /**
   * Gets the whole node rather than the value.
   *
   * @param key is used to index the values (and nodes)
   */
  @Override
  public Node getNode(K key) {
    Node current = root;
    while(current != null && key.compareTo((K) current.key) != 0) {

      if(key.compareTo((K) current.key) < 0) {
        current = current.left;
      } else if(key.compareTo((K) current.key) > 0) {
        current = current.right;
      }
    }
    return current;
  }

  /**
   * Clear removes all items from the data structure.
   */
  @Override
  public void clear() {
    root = null;
  }
}
