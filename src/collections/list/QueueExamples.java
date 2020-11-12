//package collections.list;
//import java.util.ArrayDeque;
//import java.util.LinkedList;
//import java.util.Queue;
//public class QueueExamples {
//    public static void main(String[] args) {
//        Queue<Integer> queue1 = new LinkedList<>();
//        queue1.add(1);
//        queue1.add(2);
//        queue1.add(3);
//        stutter(queue1); // [1, 1, 2, 2, 3, 3]
//        Queue<String> queue2 = new ArrayDeque<>();
//        queue2.add("a");
//        queue2.add("b");
//        queue2.add("c");
//        mirror(queue2); // ["a", "b", "c", "c", "b", "a"]
//    }
//    /**
//     * Write a function stutter that accepts a queue of integers
//     * and replaces every element with two copies of itself.
//     *
//     * [1, 2, 3] becomes [1, 1, 2, 2, 3, 3]
//     */
//    public static void stutter(Queue<Integer> q) {
//        // dequeue and add twice(without creating new queue)
//        Queue <Integer> q1;
//        for (int i = 0; i < q.size();i++){
//           Integer x = q.poll();
//           q1.push(x);
//           q1.push(x);
//        }
//        q1 = q;
//    }
//
//    /**
//     * Write a function mirror that accepts a queue of strings
//     * and appends the queue's contents to itself in reverse order.
//     *
//     * ["a", "b", "c"] becomes ["a", "b", "c", "c", "b", "a"]
//     */
//    public static void mirror(Queue<String> q) {
//        //stackに入れて、popしてqueuwにpush
//
//    }
//}