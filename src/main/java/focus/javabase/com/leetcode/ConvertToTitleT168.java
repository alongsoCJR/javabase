package focus.javabase.com.leetcode;

import java.util.Scanner;

public class ConvertToTitleT168 {


    public static String convertToTitle(int n) {
        int div = n;
        String ret = "";
        char cChar = ' ';
        if (div <= 26) {
            cChar = (char) ('A' + div - 1);
            ret += cChar;
            return ret;
        } else {
            int mod = div % 26;
            div = div / 26;
            if (mod == 0) {
                cChar = 'Z';
                ret = convertToTitle(div - 1) + cChar;
            } else {
                cChar = (char) ('A' + mod - 1);
                ret = convertToTitle(div) + cChar;
            }
        }
        return ret;
    }


    public static String convertToTitle1(int n) {
        String ret = "";

        int mod = 0;
        char modChar = ' ';
        while (n > 0) {
            if (n < 26) {
                mod = n % 27;
                modChar = (char) ('A' - 1 + mod);
            } else if (n == 26) {
                ret = 'Z' + ret;
                break;
            } else {
                mod = n % 26;
                if (mod == 0) {
                    modChar = 'Z';
                } else {
                    modChar = (char) ('A' - 1 + mod);
                }
            }
            ret = modChar + ret;
            if (n % 26 == 0) {
                n = n / 26 - 1;
            } else {
                n = n / 26;
            }
        }
        return ret;
    }
    //while (div >= 1) {
    //            int mod = div % 26;
    //            if (mod == 0) {
    //                cChar = 'Z';
    //            } else {
    //                cChar = (char) ('A' + mod - 1);
    //            }
    //            ret = cChar + ret;
    //            div = div / 26;
    //        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
//            String binary = getBinary(a);
            String ret = convertToTitle1(a);
//            System.out.println(binary);
            System.out.println(ret);
        }

    }

    // 二进制
    public static String getBinary(int a) {
        int div = a;
        String ret = "";
        while (div != 0) {
            int mod = div % 2;
            ret = mod + ret;
            div = div / 2;
        }
        return ret;
    }
}