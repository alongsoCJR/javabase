import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberExtractor {

    public static void main(String[] args) {
        try {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String formattedDate = currentDate.format(formatter);
            Set<String> historyNumbers = readHistoryNumbers("历史手机号查重库.txt");
            Map<String, String> numberAndNameMap = readDataNumbers("评论区复制文本.txt");
            Set<String> uniqueNumbers = new LinkedHashSet<String>();
            uniqueNumbers.add("--" + formattedDate + "跑数--");
            uniqueNumbers.addAll(numberAndNameMap.keySet());
            uniqueNumbers.removeAll(historyNumbers);

            writeUniqueNumbers("微信名手机号" + formattedDate + ".txt", uniqueNumbers, numberAndNameMap);
            appendUniqueNumbers("历史手机号查重库.txt", uniqueNumbers);
            System.out.println("手机号处理完成,新增：" + Math.max(0, uniqueNumbers.size() - 1) + "个手机号");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> readHistoryNumbers(String fileName) throws IOException {
        Set<String> historyNumbers = new HashSet<String>();
        File file = new File(fileName);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    historyNumbers.add(line.trim());
                }
            }
        }
        return historyNumbers;
    }

    private static Map<String, String> readDataNumbers(String fileName) throws IOException {
        Map<String, String> numberAndNameMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Pattern pattern = Pattern.compile("1[3-9]\\d{9}");
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String phoneNumber = matcher.group();
                    numberAndNameMap.put(phoneNumber.trim(), line);
                }
            }
            reader.close();
            System.out.println("提取并保存手机号成功");
        }
        return numberAndNameMap;
    }

    private static void writeUniqueNumbers(String fileName, Set<String> uniqueNumbers, Map<String, String> numberAndNameMap) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (String number : uniqueNumbers) {
                if (numberAndNameMap.containsKey(number)) {
                    writer.write(numberAndNameMap.get(number));
                    writer.newLine();
                }
            }
        }
    }

    private static void appendUniqueNumbers(String fileName, Set<String> uniqueNumbers) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine();
            for (String number : uniqueNumbers) {
                writer.write(number);
                writer.newLine();
            }
        }
    }


}
