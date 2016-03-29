/**
 * Created by 15510 on 2016/3/9.
 */
public class Queue {
    //原始数组
    int[] elements;
    //辅助数组，在原始数组长度需要扩大时将其中元素暂存在辅助数组中
    int[] elements1;
    //数组的长度
    int size;
    //数组即将被填入的元素的角标
    int top;

    //
    public Queue() {
        size = 8;
        elements = new int[this.size];
        top = 0;
    }

    //
    public void enqueue(int v) {
        if(top < size) {
            elements[top] = v;
            top++;
        } else {
            this.size *= 2;
            this.elements1 = new int[size];
            for(int i = 0;i < top;i++) {
                elements1[i] = elements[i];
            }
            elements = new int[this.size];
            for(int i = 0;i < top;i++) {
                elements[i] = elements1[i];
            }
            elements[top] = v;
            top++;
        }
    }

    //
    public int dequeue() {
        int dequeue1 = elements[0];
        int[] elements2 = elements;
        elements[0] = 0;
        for(int i = 0;i <= top;i++) {
            elements[i] = elements2[i+1];
        }
        return dequeue1;
    }

    //
    public boolean empty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }

    //
    public int getSize() {
        return size;
    }

}
