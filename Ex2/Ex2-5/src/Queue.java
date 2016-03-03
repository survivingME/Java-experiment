
public class Queue {
    int[] element;
    int size;
    int top;

    public void Queue() {
        this.size = 8;
        //desire learning!
        this.element = new int[this.size];
        this.top = 0;
    }

    public void enqueue(int v) {
        if (top < size) {
            element[top] = v;
        } else {
            int[] nElement = new int[size * 2];
            size *= 2;
            for (int i = 0;i < size / 2;i++) {
                nElement[i] = element[i];
            }
            nElement[size / 2 + 1] = v;
            element = nElement;
        }
        top++;
    }

    public int dequeue() {
        int number = element[top];
        int[] nElement = new int[top - 1];
        for (int i = 0;i < (top - 1);i++) {
            nElement[i] = element[i];
        }
        element = nElement;
        top--;
        return number;
    }

    public boolean empty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int getSize() {
        return this.size;
    }

    public static void main(String[] agrs) {
        Queue aQueue = new Queue();
        aQueue.enqueue(1);




    }
}
