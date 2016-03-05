
public class QueueTest  {
    public static void main(String[] agrs) {
        Queue aQueue = new Queue();
        for (int i = 5; i <= 20; ++i) {
            aQueue.enqueue(i);
            System.out.println(aQueue.dequeue());
        }
        System.out.println("The size is :"+aQueue.getSize());

    }
}
