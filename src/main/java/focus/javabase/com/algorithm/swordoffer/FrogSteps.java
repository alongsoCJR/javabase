package focus.javabase.com.algorithm.swordoffer;

/**
 * @Author chenjianrong-lhq
 * @Description 青蛙跳法，可以跳1/2步，跳到n处的跳法有多少？
 * @Date 2020-04-06 08:51
 **/
public class FrogSteps {

    public static int[] steps = {10, 24, 12, 25, 8, 6, 5};

    public static void main(String[] args) {
        for (int i = 0; i < steps.length; i++) {
            System.out.print("青蛙开始跳！目标位置为：" + steps[i]);
            System.out.println("跳法有：" + forward(steps[i]));

        }
    }

    private static int forward(int step) {
        if (step == 0) {
            return 0;
        }
        if (step == 1) {
            return 1;
        }
        if (step == 2) {
            return 2;
        }
        return forward(step - 1) + forward(step - 2);
    }


}