import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Tremble on 2016/2/28.
 */
public class StackOfIntegers {

    static StackOfIntegers GetFactors(int n)
    {
        List<Integer> factors = new ArrayList<Integer>();
        int x = 2;
        while (x <= n)
        {
            if (n % x == 0)
            {
                factors.add(x);
                n = n / x;
            }
            else
            {
                x++;
                if (x * x >= n)
                {
                    factors.add(n);
                    break;
                }
            }
        }
        Collections.sort(factors);
        Collections.reverse(factors);
        StackOfIntegers stackOfIntegers = new StackOfIntegers();
        for(int i :factors){
            //stackOfIntegers.push(i);
        }

        return stackOfIntegers;
    }

    public static void main(String[] args) {
        StackOfIntegers stackOfIntegers = GetFactors(120);
        //System.out.println(stackOfIntegers.getSize());

    }


}
