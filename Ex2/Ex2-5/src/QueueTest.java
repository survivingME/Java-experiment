/**
 * Created by 15510 on 2016/3/9.
 */
public class QueueTest  {
    public static void main(String[] agrs) {
        Queue aQueue = new Queue();
        for (int i = 1; i <= 20; ++i) {
            aQueue.enqueue(i);
        }
        for(int i = 1;i <= 20; ++i) {
            System.out.println(aQueue.dequeue());
        }
        System.out.println("The size is :"+aQueue.getSize());

    }
}
