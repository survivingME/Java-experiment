/**
 * Created by Tremble on 2016/4/1.
 */
 class ComparableCircle extends Circle implements Comparable {
    public String compareTo(Circle a, Circle b) {
        if(a.getR() > b.getR()) {} else {a.setR(b.getR());}
        return a.getName();
    }
}
