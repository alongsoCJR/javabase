package focus.javabase.com.jvm.allocation;

/**
 * @Author chenjianrong-lhq
 * @Description 对象大于指定大小，会直接分配至Old区
 * @Date 2020-05-03 11:27
 **/
public class Allocate_DirectToOld_T02 {

    private static final int _1MB = 1024 * 1024;

    /*VM 参数：
        -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
        注意：PS收集器不认识这个参数，PretenureSizeThreshold

        -XX:PretenureSizeThreshold=3145728   设置指定大小3M
        -XX:+UseSerialGC   Young区和old区都使用serial 垃圾回收算法
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation1;

        allocation1 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}

// 定义eden区 会占用一些内存
// def new generation   total 9216K, used 2292K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
// eden space 8192K,  27% used [0x00000007bec00000, 0x00000007bee3d0f8, 0x00000007bf400000)
