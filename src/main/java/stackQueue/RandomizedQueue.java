package stackQueue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

  final private Array<Item> queue;

  // construct an empty randomized queue
  public RandomizedQueue() {
    queue = new Array<Item>();
  }

  // is the randomized queue empty?
  public boolean isEmpty() {
    return queue.size() == 0;
  }

  // return the number of items on the randomized queue
  public int size() {
    return queue.size();
  }

  // add the item
  public void enqueue(Item item) {
    if (item == null)
      throw new IllegalArgumentException();
    queue.add(item);
  }

  // remove and return a random item
  public Item dequeue() {
    if (queue.size() <= 0)
      throw new NoSuchElementException("Queue empty");
    return queue.remove();
  }

  // return a random item (but do not remove it)
  public Item sample() {
    if (queue.size() <= 0)
      throw new NoSuchElementException("Queue empty");
    int index = StdRandom.uniform(0, queue.size());
    return queue.get(index);
  }

  // return an independent iterator over items in random order
  @Override
  public Iterator<Item> iterator() {
    queue.shuffle();
    return new Iterator<Item>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        // TODO Auto-generated method stub
        return index < queue.size();
      }

      @Override
      public Item next() {
        if (index >= queue.size())
          throw new NoSuchElementException("Traversed all items, No more items to return");
        return queue.get(index++);
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }

    };
  }

  // unit testing (required)
  public static void main(String[] args) {
    RandomizedQueue<String> rque = new RandomizedQueue<String>();
    rque.enqueue("apple");
    rque.enqueue("mango");
    rque.dequeue();
    rque.enqueue("bananna");
    rque.enqueue("pears");
    rque.enqueue("apple2");
    rque.dequeue();
    rque.enqueue("mango2");
    rque.enqueue("bananna2");
    rque.dequeue();
    rque.dequeue();
    rque.enqueue("pears2");
    System.out.println("size: " + rque.size());

    rque.enqueue("grapes");
    rque.enqueue("kiwi");
    rque.enqueue("plum");
    rque.dequeue();
    rque.dequeue();
    rque.dequeue();
    rque.dequeue();
    rque.enqueue("peach");

    Iterator<String> iterator = rque.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " , ");
    }
    /*
     * rque.dequeue(); rque.dequeue(); rque.dequeue(); rque.dequeue();
     * rque.dequeue(); rque.dequeue(); rque.dequeue(); rque.dequeue();
     * System.out.println("\nsample : " + rque.sample()); rque.dequeue();
     * rque.dequeue(); System.out.println("sample : " + rque.sample());
     * rque.dequeue(); rque.dequeue();
     */
    rque.enqueue("grapes");
    rque.enqueue("kiwi");
    rque.enqueue("plum");
    rque.enqueue("peach");
    rque.dequeue();
    rque.dequeue();
    rque.dequeue();
    rque.dequeue();
    rque.dequeue();
    rque.dequeue();
    rque.dequeue();
    rque.dequeue();
    rque.enqueue("grapes7");
    iterator = rque.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " , ");
    }
  }

  private class Array<T> {
    Object[] elements;
    int curr;

    Array() {
      elements = new Object[10];
      curr = -1;
    }

    void add(T item) {
      System.out.println("Add Item :" + item);
      printState();
      curr++;
      if (curr > elements.length / 2) {
        resize(elements.length * 2);
      }
      elements[curr] = item;
      System.out.println("========================");
    }

    T get(int i) {
      final T e = (T) elements[i];
      return e;
    }

    T remove() {
      System.out.println("Remove Item");
      printState();
      shuffle();
      int index = curr - 1;
      final T i = (T) elements[curr--];
      if (index < elements.length / 4) {
        resize(elements.length / 2);
      }
      System.out.println("========================");
      if (i == null)
        throw new RuntimeException();
      return i;
    }

    int size() {
      return curr + 1;
    }

    void shuffle() {
      StdRandom.shuffle(elements, 0, curr + 1);
    }

    void resize(int size) {
      Object[] temp = new Object[size + 1];
      for (int i = 0; i <= curr; i++) {
        temp[i] = elements[i];
      }
      elements = temp;
    }

    private void printState() {
      System.out.println("Current Array size: " + elements.length);
      System.out.println("Array Fill till " + curr);
      System.out.println("Contains : " + Arrays.toString(elements));
    }
  }
}