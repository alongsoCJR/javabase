package focus.javabase.com.basejava.thinkinginjava.chapter3;

/**
 * @Author chenjianrong-lhq
 * @Description 如果你理解了，就不会提这种问题
 * @Date 2019-06-29 16:54
 **/
public class ForAppTest {

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
        }

        for (int j = 1; j < 10; ++j) {
            System.out.println(j);
        }

        int[] arg = new int[]{123, 12, 12};
        chang(arg);
        chang2(123, 12, 12);
        Object obj=new Object();
        System.out.println(arg);
        System.out.println(obj);
    }

    private static void chang2(int ...num) {
        for(int i:num){
            System.out.println(i);
        }
    }

    private static void chang(int[] arg) {
        for (int i : arg) {
            System.out.println(i);
        }
    }


}
