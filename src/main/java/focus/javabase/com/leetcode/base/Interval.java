package focus.javabase.com.leetcode.base;

public class Interval implements Comparable {

    public Interval(int l, int r) {
        this.l = l;
        this.r = r;
    }

    public int l;
    public int r;

    @Override
    public int compareTo(Object o) {
        Interval other = (Interval) o;
        return this.l - other.l;
    }
}