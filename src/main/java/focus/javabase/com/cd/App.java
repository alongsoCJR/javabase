//package focus.javabase.com.cd;
//
//import java.io.*;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class RemoveNthFromEndT19 {
//
//    public static void main(String[] args) {
//        try {
//            ClassLoader classLoader = PhoneNumberExtractor.class.getClassLoader();
//            Set<String> historyNumbers = readHistoryNumbers(classLoader, "历史手机号查重库.txt");
//            Set<String> dataNumbers = readDataNumbers(classLoader, "评论区复制文本.txt");
//
//            Set<String> uniqueNumbers = new HashSet<>(dataNumbers);
//            uniqueNumbers.removeAll(historyNumbers);
//            writeUniqueNumbers("微信名手机号.txt", uniqueNumbers);
//            appendUniqueNumbers(classLoader, "历史手机号查重库.txt", uniqueNumbers);
//            System.out.println("手机号处理完成");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static Set<String> readHistoryNumbers(ClassLoader classLoader, String fileName) throws IOException {
//        Set<String> historyNumbers = new HashSet<>();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(fileName)))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                historyNumbers.add(line.trim());
//            }
//        }
//        return historyNumbers;
//    }
//
//
//    private static Set<String> readDataNumbers(ClassLoader classLoader, String fileName) throws IOException {
//        Set<String> dataNumbers = new HashSet<>();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream(fileName)))) {
//            Pattern pattern = Pattern.compile("1[3-9]\\d{9}");
//            String line;
//            while ((line = reader.readLine()) != null) {
//                Matcher matcher = pattern.matcher(line);
//
//
//                while (matcher.find()) {
//                    String phoneNumber = matcher.group();
//                    dataNumbers.add(phoneNumber.trim());
//                }
//            }
//            reader.close();
//            System.out.println("提取并保存手机号成功");
//        }
//        return dataNumbers;
//    }
//
//    private static void writeUniqueNumbers(String fileName, Set<String> uniqueNumbers) throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//            for (String number : uniqueNumbers) {
//                writer.write(number);
//                writer.newLine();
//            }
//        }
//    }
//
//    private static void appendUniqueNumbers(ClassLoader classLoader, String fileName, Set<String> uniqueNumbers) throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
//            for (String number : uniqueNumbers) {
//                writer.write(number);
//                writer.newLine();
//            }
//        }
//    }
//
//}