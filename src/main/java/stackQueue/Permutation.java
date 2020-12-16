package stackQueue;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
  public static void main(String[] args) {
//    int size = Integer.parseInt(args[0].strip());
    RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
    while (!StdIn.isEmpty()) {
      String line = StdIn.readString();
      if (!line.isBlank()) {
        randomizedQueue.enqueue(line);
      }
    }
    Iterator<String> itr = randomizedQueue.iterator();
    while (itr.hasNext())
      System.out.println(itr.next());
  }
}
