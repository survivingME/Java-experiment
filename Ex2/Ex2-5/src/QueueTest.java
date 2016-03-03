
public class QueueTest  {
    public static void main(String[] agrs) {
        Queue aQueue = new Queue();
        aQueue.enqueue(1);
        aQueue.enqueue(2);
        aQueue.enqueue(3);
        aQueue.enqueue(4);
        aQueue.enqueue(5);
        aQueue.enqueue(6);
        aQueue.enqueue(7);
        aQueue.enqueue(8);
        aQueue.enqueue(9);
        aQueue.enqueue(10);
        System.out.print(aQueue.dequeue());


    }
}
