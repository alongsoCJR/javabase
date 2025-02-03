package focus.javabase.com.algorithm.second;

public class ComparableT implements Comparable<ComparableT> {

    public ComparableT(int age) {
        this.age = age;
    }

    private int age;

    @Override
    public int compareTo(ComparableT obj) {
        return obj.age > this.age ? 1 : -1;
    }
}