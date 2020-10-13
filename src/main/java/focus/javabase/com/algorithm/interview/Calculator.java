package focus.javabase.com.algorithm.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author chenjianrong-lhq
 * @Description 美团面试 设计模式考察
 * @Date 2020-10-13 18:40
 **/
public class Calculator {

    // 职责单一原则
    public static void cal(int a, int b, String calType) {
        ICalculate calculate = CalculateFactory.getCalculate(calType);
        if (calculate == null) {
            System.out.println("不支持的算法符号");
        } else {
            double result = calculate.calculate(a, b);
            System.out.println("计算结果：" + result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = Integer.parseInt(scanner.nextLine());
            int b = Integer.parseInt(scanner.nextLine());
            String calType = scanner.nextLine();
            cal(a, b, calType);
        }
    }
}

// 简单工厂
class CalculateFactory {

    private static final Map<String, ICalculate> calMap = new HashMap();

    static {
        calMap.put("add", new AddCalculate());
        calMap.put("sub", new SubCalculate());
        calMap.put("mod", new ModCalculate());
    }

    // 策略模式
    public static ICalculate getCalculate(String type) {
        ICalculate calculate = calMap.get(type);
        if (calculate == null) {
            System.out.println("工厂中心未找到算法计算规则！请提供！");
        }
        return calculate;
    }
}

interface ICalculate {

    double calculate(int a, int b);
}

class AddCalculate implements ICalculate {

    @Override
    public double calculate(int a, int b) {
        return a + b;
    }
}

class SubCalculate implements ICalculate {
    @Override
    public double calculate(int a, int b) {
        return a - b;
    }
}

class ModCalculate implements ICalculate {
    @Override
    public double calculate(int a, int b) {
        return a % b;
    }
}

