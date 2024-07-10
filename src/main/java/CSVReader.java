import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {
    public static final int VALID_LINE_SIZE = 2;
    public static final int PARAM_NAME = 0;
    public static final int PARAM_VALUE = 1;

    public static Map<String, String> readCsvToMap(String filePath) {
        Map<String, String> resultMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Replace escaped newlines in the line read from the file
                line = line.replace("\\n", "\n");
                String[] keyValuePair = line.split(Constants.COMMA, VALID_LINE_SIZE);
                if (keyValuePair.length == VALID_LINE_SIZE) {
                    resultMap.put(keyValuePair[PARAM_NAME].trim(), keyValuePair[PARAM_VALUE].trim().replace("\\n", "\n"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

}
