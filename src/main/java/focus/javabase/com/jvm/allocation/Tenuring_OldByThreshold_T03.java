package focus.javabase.com.jvm.allocation;

/**
 * @Author chenjianrong-lhq
 * @Description 长期存活的对象进入老年代
 * @Date 2020-05-04 18:07
 **/
public class Tenuring_OldByThreshold_T03 {


    private static final int _1MB = 1024 * 1024;

    /*VM 参数：
        -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[_1MB / 4];
//        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];

        allocation4 = new byte[2 * _1MB]; // minor GC
        allocation4 = null;
        allocation4 = new byte[2 * _1MB];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}