package focus.javabase.com.algorithm.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @Author alongso.cjr
 * @Description hhsw 将文本内容有序输出
 * @Date 2021-03-29 15:43
 **/
public class OutPutSortString {


    /**
     * @return void
     * @Author alongso.cjr
     * @Description 使用java.io.FileReader类 https://www.yiibai.com/java/java-read-text-file.html
     * @Date 2021-03-29 17:36
     * @Param [fileName]
     **/
    public static void outPutSortedString(String fileName) throws Exception {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            sb.append(line);
        }

        int[] cs = new int[26];
        char[] lineChar = sb.toString().toCharArray();
        for (char c : lineChar) {
            int index = c - 'A';
            cs[index]++;
        }
        for (int i = 0; i < 26; i++) {
            while (cs[i] > 0) {
                char a = (char) ('A' + i);
                System.out.print(a);
                cs[i]--;
            }
        }
    }

    /**
     * @return void
     * @Author alongso.cjr
     * @Description 使用Scanner读取文本文件
     * @Date 2021-03-29 17:36
     * @Param [fileName]
     **/
    public static void outPutSortedString0(String fileName) throws Exception {
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        StringBuilder sb = new StringBuilder();
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            System.out.println(line);
            sb.append(line);
        }

        int[] cs = new int[26];
        char[] lineChar = sb.toString().toCharArray();
        for (char c : lineChar) {
            int index = c - 'A';
            cs[index]++;
        }
        for (int i = 0; i < 26; i++) {
            while (cs[i] > 0) {
                char a = (char) ('A' + i);
                System.out.print(a);
                cs[i]--;
            }
        }
    }

    // ASDADASSDQWDADASADAWEASJJSASGHFA
    // AAAAAAAAAADDDDDDEFGHJJQSSSSSSSWW
    public static void main(String[] args) throws Exception {
        outPutSortedString0("/Volumes/AlongsoPro/selfstudy/workspace/basejava/src/main/resource/string.txt");
    }
}