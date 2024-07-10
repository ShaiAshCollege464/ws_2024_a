import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Creds {
    public static final int VALID_PARAMS_SIZE = 4;

    private String id;
    private int testId;
    private String magic;
    private String name;

    public Creds(String id, int testId, String magic, String name) {
        this.id = id;
        this.testId = testId;
        this.magic = magic;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString () {
        return TranslationsUtils.getCredsMessage(this);
    }

    public void writeDataToFile (FileWriter fileWriter) {
        try {
            fileWriter.append(String.format("%s%s%s%s", Constants.PARAM_ID, Constants.COMMA, this.id, Constants.LINE_BREAK));
            fileWriter.append(String.format("%s%s%s%s", Constants.PARAM_TEST_ID, Constants.COMMA, this.testId, Constants.LINE_BREAK));
            fileWriter.append(String.format("%s%s%s%s", Constants.PARAM_MAGIC, Constants.COMMA, this.magic, Constants.LINE_BREAK));
            fileWriter.append(String.format("%s%s%s%s", Constants.PARAM_NAME, Constants.COMMA, this.name, Constants.LINE_BREAK));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Creds readDataFromFile (String filePath) {
        Creds creds = null;
        Map<String, String> contentMap = CSVReader.readCsvToMap(filePath);
        if (contentMap.size() == VALID_PARAMS_SIZE) {
            String id = contentMap.get(Constants.PARAM_ID);
            if (id != null) {
                String testId = contentMap.get(Constants.PARAM_TEST_ID);
                if (testId != null) {
                    String magic = contentMap.get(Constants.PARAM_MAGIC);
                    if (magic != null) {
                        String name = contentMap.get(Constants.PARAM_NAME);
                        if (name != null) {
                            creds = new Creds(id, Integer.parseInt(testId), magic, name);
                        }
                    }
                }
            }

        }
        return creds;
    }
}
