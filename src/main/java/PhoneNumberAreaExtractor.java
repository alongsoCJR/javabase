import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import focus.javabase.com.basejava.Lists;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberAreaExtractor {


    // 指定城市手机号
    private static Set<String> appointMobileAreas = new HashSet<>(Lists.newArrayList("盐城", "淮安", "徐州", "连云港", "宿迁"));
    private static String appointMobileProvice = "江苏";


    public static void main(String[] args) {

        try {
            Set<String> historyNumbers = readHistoryNumbers("历史手机号查重库.txt");
            Set<String> dataNumbers = readDataNumbers("评论区复制文本.txt");
            Set<String> uniqueNumbers = new HashSet<String>(dataNumbers);
            uniqueNumbers.removeAll(historyNumbers);


            writeUniqueNumbers("本次提取到的手机号.txt", uniqueNumbers);


            appendUniqueNumbers("历史手机号查重库.txt", uniqueNumbers);

            String apiKey = "f48bbee3545f9b8cab435e32f30eea71";

            String phoneNumberFile = "本次提取到的手机号.txt";

            try {
                BufferedReader reader = new BufferedReader(new FileReader(phoneNumberFile));

                try {
                    Map<String, BufferedWriter> provinceWriters = new HashMap<String, BufferedWriter>();
                    Map<String, BufferedWriter> areaWriters = new HashMap<String, BufferedWriter>();
                    String phoneNumber;
                    while ((phoneNumber = reader.readLine()) != null) {

                        String locationInfo = getLocationInfo(apiKey, phoneNumber);


                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode responseNode = objectMapper.readTree(locationInfo);

                        int code = responseNode.path("code").asInt();
                        if (code == 200) {
                            JsonNode resultNode = responseNode.path("result");

                            String mobileProvice = resultNode.path("mobileprovice").asText();
                            String mobileArea = resultNode.path("mobilearea").asText();


                            BufferedWriter writer = getOrCreateWriter(mobileProvice, provinceWriters);
                            writer.write(phoneNumber + "\t" + mobileProvice + "\t" + mobileArea);
                            System.out.println(phoneNumber + "\t" + mobileProvice + "\t" + mobileArea);
                            writer.newLine();

                            // 如果是指定城市
                            if (appointMobileProvice.equals(mobileProvice) && appointMobileAreas.contains(mobileArea)) {
                                BufferedWriter areaWriter = getOrCreateAreaWriter(mobileProvice,mobileArea, areaWriters);
                                areaWriter.write(phoneNumber + "\t" + mobileProvice + "\t" + mobileArea);
                                System.out.println("提取指定城市: " + phoneNumber + "\t" + mobileProvice + "\t" + mobileArea);
                                areaWriter.newLine();
                            }
                            continue;
                        }
                        if (code == 150) {
                            System.out.println("API可用次数不足!!!!!!!!!!!!!!!!!");
                        }
                    }


                    closeWriters(provinceWriters);
                    closeWriters(areaWriters);

                    System.out.println("手机号归属地划分完毕！");

                    reader.close();
                } catch (Throwable throwable) {
                    try {
                        reader.close();
                    } catch (Throwable throwable1) {
                        throwable.addSuppressed(throwable1);
                    }
                    throw throwable;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("手机号处理完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> readHistoryNumbers(String fileName) throws IOException {
        Set<String> historyNumbers = new HashSet<String>();

        File file = new File(fileName);
        if (file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    historyNumbers.add(line.trim());
                }
                reader.close();
            } catch (Throwable throwable) {
                try {
                    reader.close();
                } catch (Throwable throwable1) {
                    throwable.addSuppressed(throwable1);
                }
                throw throwable;
            }

        }
        return historyNumbers;
    }

    private static Set<String> readDataNumbers(String fileName) {
        Set<String> dataNumbers = new HashSet<String>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Pattern pattern = Pattern.compile("(\\d{11})");
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String phoneNumber = matcher.group(1);
                    dataNumbers.add(phoneNumber.trim());
                }
            }
            reader.close();
            System.out.println("提取并保存手机号成功！");

            reader.close();
        } catch (Throwable throwable) {
            try {
                reader.close();
            } catch (Throwable throwable1) {
                throwable.addSuppressed(throwable1);
            }
        }
        return dataNumbers;
    }

    private static void writeUniqueNumbers(String fileName, Set<String> uniqueNumbers) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        try {
            for (String number : uniqueNumbers) {
                writer.write(number);
                writer.newLine();
            }
            writer.close();
        } catch (Throwable throwable) {
            try {
                writer.close();
            } catch (Throwable throwable1) {
                throwable.addSuppressed(throwable1);
            }
            throw throwable;
        }
    }

    private static void appendUniqueNumbers(String fileName, Set<String> uniqueNumbers) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        try {
            writer.newLine();
            for (String number : uniqueNumbers) {
                writer.write(number);
                writer.newLine();
            }
            writer.close();
        } catch (Throwable throwable) {
            try {
                writer.close();
            } catch (Throwable throwable1) {
                throwable.addSuppressed(throwable1);
            }
            throw throwable;
        }
    }

    private static String getLocationInfo(String apiKey, String phoneNumber) throws IOException {
        String apiUrl = "https://apis.tianapi.com/mobilelocal/index?key=" + apiKey + "&phone=" + phoneNumber;


        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");


        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return response.toString();
    }


    private static BufferedWriter getOrCreateWriter(String province, Map<String, BufferedWriter> writers) throws IOException {
        if (!writers.containsKey(province)) {

            String fileName = "归属地/" + province + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writers.put(province, writer);
        }
        return (BufferedWriter) writers.get(province);
    }

    private static BufferedWriter getOrCreateAreaWriter(String mobileProvice, String mobileArea, Map<String, BufferedWriter> writers) throws IOException {
        if (!writers.containsKey(mobileArea)) {

            String fileName = "归属地/" + mobileProvice + "/" + mobileArea + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writers.put(mobileArea, writer);
        }
        return (BufferedWriter) writers.get(mobileArea);
    }

    private static void closeWriters(Map<String, BufferedWriter> writers) {
        for (BufferedWriter writer : writers.values()) {
            try {
                writer.close();
            } catch (IOException e) {
                System.err.println("Error closing writer: " + e.getMessage());
            }
        }
    }
}
