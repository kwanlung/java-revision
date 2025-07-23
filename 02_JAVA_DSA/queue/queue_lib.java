package queue;

import java.util.LinkedList;
import java.util.Queue;

public class queue_lib {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        // different between add() and offer()
        // add() throws an exception if the queue is full, while offer() returns false.
        queue.add(1);
        queue.offer(2);
        System.out.println("Queue after adding elements: " + queue);
        queue.poll();
        System.out.println("Queue after removing an element: " + queue);
        System.out.println("Peek at the front element: " + queue.peek());
    }
}
