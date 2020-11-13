package collections.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueExamples {
  public static void main(String[] args) {
    PriorityQueue<String> pq = new PriorityQueue<>();
    pq.offer("Java");
    pq.offer("Python");
    pq.offer("JavaScript");
    pq.offer("PHP");
    pq.offer("Ruby");
    pq.offer("Scala");
    pq.offer("Swift");
    pq.offer("Go");
    pq.offer("C/C++");
    pq.offer("Rust");
    pq.offer("ArnoldC");
    System.out.println(pq.size());

    System.out.println(Arrays.toString(pq.toArray()));

    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }

    Student s1 = new Student("Steve Jobs", (int)(Math.random() * 50) + 50);
    Student s2 = new Student("Bill Gates", (int)(Math.random() * 50) + 50);
    Student s3 = new Student("Sergey Brin", (int)(Math.random() * 50) + 50);
    Student s4 = new Student("Larry Page", (int)(Math.random() * 50) + 50);
    Student s5 = new Student("Jeff Bezos", (int)(Math.random() * 50) + 50);
    Student s6 = new Student("Mark Zuckerberg", (int)(Math.random() * 50) + 50);

    // MERGE SORT: O(nlogn)
    // QUICK SORT: O(nlogn)
    // HEAP SORT : O(nlogn)
    PriorityQueue<Student> topStudents = new PriorityQueue<>();
    topStudents.offer(s1);
    topStudents.offer(s2);
    topStudents.offer(s3);
    topStudents.offer(s4);
    topStudents.offer(s5);
    topStudents.offer(s6);

    while (!topStudents.isEmpty()) {
      System.out.println(topStudents.poll());
    }
  }
}

