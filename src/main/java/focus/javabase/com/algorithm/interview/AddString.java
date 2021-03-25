package focus.javabase.com.algorithm.interview;

/**
 * @Author Jianrong.Chen
 * @Description ks 两个字符串相加
 * @Date 2021-03-25 21:30
 **/
public class AddString {

    public static void main(String[] args) {
        String a1 = "1";
        String a2 = "999";
        String excepted = "1000";
        String outPut = getSum0(a1, a2);
        if (excepted.equals(outPut)) {
            System.out.println("Success!");
        } else {
            System.out.println("fail! outPut=" + outPut);
        }
    }

    public static String getSum(String num1, String num2) {
        if (num1 == null || "".equals(num1)) {
            return num2;
        }

        if (num2 == null || "".equals(num2)) {
            return num1;
        }

        int length = num1.length() > num2.length() ? num1.length() : num2.length();
        // 将字符串反向转化为int数组  "123" -> {3,2,1,0} "4567" -> {7,6,5,4}
        int[] arr1 = convertToArr(num1, length);
        int[] arr2 = convertToArr(num2, length);
        int[] result = new int[length];
        int bitCount = 0;
        for (int i = 0; i < length; i++) {
            int sum = arr1[i] + arr2[i] + bitCount;
            if (sum >= 10) {
                bitCount = 1;
                sum = sum % 10;
            } else {
                bitCount = 0;
            }
            result[i] = sum;
        }

        // 返回结果 {0,9,6,4} ——> 4690
        int[] result2 = new int[length + 1];
        if (bitCount == 1) {
            // 数组末位加一个1
            System.arraycopy(result, 0, result2, 0, length);
            result2[length] = 1;
            return convertToString(result2);
        }
        return convertToString(result);
    }

    public static int[] convertToArr(String str, int len) {
        int length = str.length();
        int[] arr = new int[len];
        for (int i = 0; i < length; i++) {
            arr[length - i - 1] = str.charAt(i) - '0';
        }
        return arr;
    }

    public static String convertToString(int arr[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }


    public static String getSum0(String num1, String num2) {
        if (num1 == null || "".equals(num1)) {
            return num2;
        }

        if (num2 == null || "".equals(num2)) {
            return num1;
        }

        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int bitCount = 0;
        while (i >= 0 || j >= 0 || bitCount > 0) {
            if (i >= 0) {
                bitCount += num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                bitCount += num2.charAt(j) - '0';
                j--;
            }

            result.append(bitCount % 10);
            bitCount = bitCount / 10;
        }
        return result.reverse().toString();
    }

}