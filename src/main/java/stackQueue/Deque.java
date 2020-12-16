package stackQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

  private int size;
  private Node<Item> head, tail;

  // construct an empty deque
  public Deque() {
    size = 0;
    head = null;
    tail = null;
  }

  // is the deque empty?
  public boolean isEmpty() {
    return size() == 0;
  }

  // return the number of items on the deque
  public int size() {
    return size;
  }

  // add the item to the front
  public void addFirst(Item item) {
    if (item == null)
      throw new IllegalArgumentException("Could not add empty item");
    Node<Item> curr = new Node<Item>(item);
    curr.next = head;
    if (size != 0)
      head.prev = curr;
    head = curr;
    if (size == 0)
      tail = head;
    size++;
  }

  // add the item to the back
  public void addLast(Item item) {
    if (item == null)
      throw new IllegalArgumentException("Could not add empty item");
    if (size() == 0)
      addFirst(item);
    else {
      size++;
      Node<Item> curr = new Node<Item>(item);
      tail.next = curr;
      curr.prev = tail;
      tail = curr;
    }
  }

  // remove and return the item from the front
  public Item removeFirst() {
    if (size == 0)
      throw new NoSuchElementException("Empty Queue, no elements to return");
    Node<Item> curr = head;
    head = head.next;
    if (head != null)
      head.prev = null;
    if (head == null)
      tail = null;
    size--;
    return curr.item;
  }

  // remove and return the item from the back
  public Item removeLast() {
    if (size == 0)
      throw new NoSuchElementException("Empty Queue, no elements to return");
    Node<Item> curr = tail;
    tail = tail.prev;
    if (tail != null)
      tail.next = null;
    if (tail == null)
      head = null;
    size--;
    return curr.item;
  }

  // return an iterator over items in order from front to back
  @Override
  public Iterator<Item> iterator() {
    return new Iterator<Item>() {
      Node<Item> curr = head;

      @Override
      public boolean hasNext() {
        // TODO Auto-generated method stub
        return curr != null;
      }

      @Override
      public Item next() {
        // TODO Auto-generated method stub
        if (curr == null)
          throw new NoSuchElementException("Traversed all items, No more items to return");
        Item i = curr.item;
        curr = curr.next;
        return i;
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }

    };
  }

  // unit testing (required)
  public static void main(String[] args) {
    Deque<String> deque = new Deque<String>();
    deque.addFirst("apple");
    System.out.println("Is Empty : " + deque.isEmpty());
    deque.addFirst("mango");
    System.out.println("Is Empty : " + deque.isEmpty());
    deque.removeFirst();
    System.out.println("Is Empty : " + deque.isEmpty());
    deque.removeLast();
    System.out.println("Is Empty : " + deque.isEmpty());

    deque.addLast("grapes");
    System.out.println("Is Empty : " + deque.isEmpty());
    deque.removeFirst();
    System.out.println("Is Empty : " + deque.isEmpty());

    deque.addFirst("bananna");
    System.out.println("Is Empty : " + deque.isEmpty());
    deque.addLast("kiwi");
    System.out.println("Is Empty : " + deque.isEmpty());
    deque.removeLast();
    System.out.println("Is Empty : " + deque.isEmpty());

    deque.addLast("plum");
    System.out.println("Is Empty : " + deque.isEmpty());
    deque.addFirst("pears");
    System.out.println("Is Empty : " + deque.isEmpty());
    System.out.println("Is Empty : " + deque.isEmpty());

    deque.removeLast();
    System.out.println("Is Empty : " + deque.isEmpty());
    deque.addLast("peach");
    System.out.println("Is Empty : " + deque.isEmpty());

    deque.removeFirst();
    System.out.println("Is Empty : " + deque.isEmpty());

    System.out.println("size: " + deque.size());

    Iterator<String> iterator = deque.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " , ");
    }

    System.out.println();
    iterator = deque.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " , ");
    }

  }

  private class Node<T> {
    T item;
    Node<T> prev, next;

    Node(T item) {
      this.item = item;
    }
  }
}