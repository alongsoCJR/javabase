package focus.javabase.com.leetcode;

public class AddBinaryT067 {


    // 11 1 ->10 10-> 100
    // 1010 1011  ->  1 0101
    public static String addBinary1(String a, String b) {
        assert a != null && b != null;
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        // 拆
        int len = a.length() > b.length() ? b.length() : a.length();
        String result = "";
        Boolean isIncr = false;
        for (int i = len - 1; i >= 0; i--) {
            int aVal = Integer.parseInt(a.charAt(i) + "");
            int bVal = Integer.parseInt(b.charAt(i) + "");
            // 进一
            if (isIncr) {
                result = (aVal ^ bVal ^ 1) + result;
                isIncr = ((aVal ^ bVal) == 1);
            } else {
                // 装
                result = (aVal ^ bVal) + result;
                isIncr = ((aVal ^ bVal) == 0 && aVal == 1);
            }
            a = a.substring(0, i);
            b = b.substring(0, i);
        }

        if (a.length() == 0 && b.length() == 0 && isIncr) {
            result = "1" + result;
        }

        while (a.length() != 0) {
            int aLastVal = Integer.parseInt(a.charAt(a.length() - 1) + "");
            if (isIncr) {
                result = (aLastVal ^ 1) + result;
                isIncr = ((aLastVal ^ 1) == 0);
            } else {
                result = a + result;
                break;
            }
            a = a.substring(0, a.length() - 1);
        }

        while (b.length() != 0) {
            int bLastVal = Integer.parseInt(b.charAt(b.length() - 1) + "");
            if (isIncr) {
                result = (bLastVal ^ 1) + result;
                isIncr = ((bLastVal ^ 1) == 0);
            } else {
                result = b + result;
            }
            b = b.substring(0, b.length() - 1);

        }

        if (isIncr) {
            result = "1" + result;
        }
        return result;
    }

    // 11 1 10 10
    // 1010 1011   1
    // 101 10 111
    // 101 101 1->  10 11 01-> 1 1 101-> 1 0101
    // 1111 1 -> 111 0 ->1000 0
    public static String addBinary(String a, String b) {
        assert a != null && b != null;
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }

        String result = "";
        int aVal = Integer.parseInt(a.charAt(a.length() - 1) + "");
        int bVal = Integer.parseInt(b.charAt(b.length() - 1) + "");

        if ((aVal ^ bVal) == 1) {
            result = addBinary(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)) + "1";
        } else if ((aVal ^ bVal) == 0 && aVal == 0) {
            result = addBinary(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)) + "0";
        } else {
            // 解决进位的问题
            if (a.substring(0, a.length() - 1).length() == 0) {
                // 对 b进位  101 1 1000
                boolean isIncr = true;
                String ret = "";
                while (b.length() != 0) {
                    int val = Integer.parseInt(b.charAt(b.length() - 1) + "");
                    if (isIncr) {
                        ret = (val + 1) % 2 + ret;
                        isIncr = ((val + 1) % 2 == 0);
                    } else {
                        ret = b + ret;
                        break;
                    }
                    b = b.substring(0, b.length() - 1);
                }
                if (isIncr) {
                    ret = "1" + ret;
                }
                b = ret;
            } else {
                // 对 a进位
                boolean isIncr = true;
                String ret = "";
                while (a.length() != 0) {
                    int val = Integer.parseInt(a.charAt(a.length() - 1) + "");
                    if (isIncr) {
                        ret = (val + 1) % 2 + ret;
                        isIncr = ((val + 1) % 2 == 0);
                    } else {
                        ret = a + ret;
                        break;
                    }
                    a = a.substring(0, a.length() - 1);
                }
                if (isIncr) {
                    ret = "1" + ret;
                }
                a = ret;
            }
            result = addBinary(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)) + "0";
        }
        return result;

    }


    public static String addBinary2(String a, String b) {
        assert a != null && b != null;
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int len = a.length() < b.length() ? a.length() : b.length();
        for (int i = len - 1; i >= 0; i++) {
            if (aChars[i] != bChars[i]) {

            } else {
                if (aChars[i] == '1') {

                } else {

                }
            }
        }

        return "";
    }


    // // 解决进位的问题
    //            if (a.substring(0, a.length() - 1).length() == 0) {
    //                // 对b进位  1-10 0-1 11->100
    //                char[] ret = new char[b.length() + 1];
    //                for (int i = b.length(); i >= 0; i++) {
    //                    int val = b.charAt(i);
    //                    if (val == '1') {
    //
    //                    } else {
    //
    //                        break;
    //                    }
    //                }
    //                b = ret;
    //            } else if (b.substring(0, b.length() - 1).length() == 0) {
    //                // 对a进位
    //            } else {
    //                // 对其一进位
    //            }
}