package focus.javabase.com.leetcode;

/**
 * @author chenjianrong-lhq 2019年08月03日 17:04:48
 * @Description: 是否是回文字符串
 * @ClassName: IsPalindromeT009
 */
public class IsPalindromeT125 {


    //i < arr.length - 1 && (arr[i] == ' ' || arr[i] == ';' || arr[i] == ',' || arr[i] == ':'
    public static boolean isPalindrome(String s) {
        assert s != null;
        char[] arr = s.toUpperCase().toCharArray();
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            char iChar = arr[i];
            char jChar = arr[j];
            while ((iChar < '0' || iChar > '9' && iChar < 'A' || iChar > 'Z')) {
                if (i >= arr.length - 1) {
                    return true;
                }
                iChar = arr[++i];
            }
            while ((jChar < '0' || jChar > '9' && jChar < 'A' || jChar > 'Z')) {
                if (j <= 0) {
                    return true;
                }
                jChar = arr[--j];
            }
            if (iChar != jChar) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // 参考
    public static boolean isPalindrome1(String s) {
        assert s != null;
        char[] arr = s.toUpperCase().toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char iChar = arr[i];
            char jChar = arr[j];
            while (!Character.isLetterOrDigit(iChar)) {
                if (i >= arr.length - 1) {
                    return true;
                }
                iChar = arr[++i];
            }
            while (!Character.isLetterOrDigit(jChar)) {
                if (j <= 0) {
                    return true;
                }
                jChar = arr[--j];
            }
            if (iChar != jChar) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
