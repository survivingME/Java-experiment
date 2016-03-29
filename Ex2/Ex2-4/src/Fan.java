/**
 * Created by 15510 on 2016/3/8.
 */
public class Fan {
    //数据域
    int SLOW = 1,MEDIUM = 2, FAST = 3;
    private int speed = SLOW;
    private String speedClass = "SLOW";
    private boolean on = false;
    private  double radius = 5;
    private String color = "blue";

    //访问器
    public int getSpeed () {
        return speed;
    }
    public boolean getOn () {
        return on;
    }
    public double getRadius () {
        return radius;
    }
    public String getColor () {
        return color;
    }

    //修改器
    public void setSpeed (int speed) {
        if (speed == 1) {
            speedClass = "SLOW";
        } else if (speed == 2) {
            speedClass = "MEDIUM";
        } else if (speed == 3) {
            speedClass = "FAST";
        }

    }
    public void setOn (boolean on) {
        this.on = on;
    }
    public void setRadius (double radius) {
        this.radius = radius;
    }
    public void setColor (String color) {
        this.color = color;
    }
    public void setAll (int speed, boolean on, double radius, String color) {
        this.speed = speed;
        if (speed == 1) {
            speedClass = "SLOW";
        } else if (speed == 2) {
            speedClass = "MEDIUM";
        } else if (speed == 3) {
            speedClass = "FAST";
        }
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    //构造方法
    public void ToString() {
        String result;
        if (on == false) {
            result = "fan is off";
        } else {
            result = "Speed: "+speedClass+",Color: "+color+",radius: "+radius;
        }
        System.out.println(result);
    }
}
