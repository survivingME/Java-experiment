import java.util.ArrayList;
import java.util.List;

public class StackOfIntegers {
    List<Integer> list = new ArrayList<Integer>();

    public void getSub(int sum){
        int middle = getMiddleAfter(sum);
        for(int i = 2;i < middle;i++){
            if(!isPrime(i)){
                continue;
            }
            int yu = sum%i;
            int last = sum/i;
            if(yu == 0){
                list.add(i);
                if(isPrime(last)){
                    list.add(last);
                    return;
                }
                getSub(sum / i);
                break;
            }
        }
    }

    public int getMiddleAfter(int num){
        if(num % 2 == 0){
            return num / 2 + 1;
        }else{
            return (num + 1)/2;
        }
    }

    public boolean isPrime(int num){
        boolean flag = true;
        for(int i = 2;i < num;i++){
            if(num%i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();
        stack.getSub(120);
        System.out.println(stack.list);
    }
}
