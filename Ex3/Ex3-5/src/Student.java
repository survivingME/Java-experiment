/**
 * Created by 15510 on 2016/3/22.
 */
public class Student extends Person {
    private String name;
    private String address;
    private long phoneNumber;
    private String email;
    private enum collegeClass {
        one, two, three, four
    };

    public String toString() {
        return "Person"+name+" "+" "+address+" "+phoneNumber+" "+email;

    }


}
