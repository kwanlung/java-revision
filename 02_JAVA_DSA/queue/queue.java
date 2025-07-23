package queue;

public class queue {
    public static void main(String[] args){
        class Queue {
            private final int[] arr;
            private final int capacity;
            private int front, rear, size;

            Queue(int size) {
                arr = new int[size];
                capacity = size;
                front = 0;
                rear = -1;
                this.size = 0;
            }

            public Boolean isFull() {
                return size == capacity;
            }

            public Boolean isEmpty() {
                return size == 0;
            }

            public void enqueue(int x) {
                if (isFull()) {
                    System.out.println("The Queue is Full");
                    System.exit(1);
                }
                rear = (rear + 1) % capacity;
                arr[rear] = x;
                size++;
                System.out.println("Inserted " + x);
            }

            public int dequeue() {
                if (isEmpty()) {
                    System.out.println("The Queue is Empty");
                    return -1;
                }
                int item = arr[front];
                front = (front + 1) % capacity;
                size--;
                return item;
            }

            public int peek() {
                if (!isEmpty()) {
                    return arr[front];
                } else {
                    System.out.println("The Queue is Empty");
                    return -1;
                }
            }
        }
    }
}
