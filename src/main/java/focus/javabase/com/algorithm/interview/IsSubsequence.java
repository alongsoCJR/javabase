package focus.javabase.com.algorithm.interview;

/**
 * @Author chenjianrong-lhq
 * @Description TT面试题  对应leetcodeT392
 * @Date 2020-09-14 21:47
 **/
public class IsSubsequence {
    public static void main(String[] args) {
//        boolean excepted = true;
//        boolean output = isOrderSubString("cejf", "abcdeddffsjdlsjflkdsjf");

        boolean excepted = false;
        boolean output = isSubsequence("abc", "aedsfab");
        if (excepted == output) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
    }

    // ["abc"、""],["abc"、"aedsfab"] 程序死循环
    public static boolean isOrderSubString(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int sLength = s.length();
        int tLength = t.length();
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < sLength) {
            char sChar = s.charAt(sIndex);
            while (tIndex < tLength) {
                if (sChar == t.charAt(tIndex)) {
                    tIndex++;
                    sIndex++;
                    break;
                } else {
                    tIndex++;
                }

                if (tIndex == tLength) {
                    return false;
                }
            }
        }
        return true;
    }

    // 完善代码
    public static boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int sLength = s.length();
        int tLength = t.length();
        if (sLength > tLength) {
            return false;
        }
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < sLength) {
            char sChar = s.charAt(sIndex);
            if (tIndex == tLength) {
                return false;
            }
            while (tIndex < tLength) {
                if (sChar == t.charAt(tIndex)) {
                    tIndex++;
                    break;
                } else {
                    tIndex++;
                }

                if (tIndex == tLength) {
                    return false;
                }
            }
            sIndex++;
        }
        return true;
    }

}