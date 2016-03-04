
public class Queue {
    int[] elements;
    int[] elements1;
    int size;
    int top;

    public Queue() {
        this.size = 8;
        this.elements = new int[this.size];
        this.top = 0;
    }

    public void enqueue(int v) {
        if(top < size) {
            elements[top] = v;
            top++;
        } else {
            this.elements1 = new int[this.size * 2];
            for(int i = 0;i < top;i++) {
                elements1[i] = elements[i];
            }
            for(int i = 0;i < top;i++) {
                elements[i] = elements1[i];
            }
            top++;
            this.size *= 2;
        }
    }

    public int dequeue() {
        int dequeue1 = elements[top - 1];
        elements[top - 1] = 0;
        top--;
        return dequeue1;
    }

    public boolean empty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int Size() {
        return elements.length;
    }


}
