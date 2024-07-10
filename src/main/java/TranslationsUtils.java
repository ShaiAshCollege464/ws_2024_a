import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TranslationsUtils {
    public static final String TRANSLATIONS_FILE_PATH = "translation_values.csv";
    public static Map<String, String> translationsMap = new HashMap<>();

    static {
        TranslationsUtils.init();
    }

    public static String getCredsMessage (Creds creds) {
        return String.format("%s %s, %s %s",
                getTranslation(TranslationKeys.hello),
                creds.getName(),
                getTranslation(TranslationKeys.your_test_identifier),
                creds.getMagic());
    }

    public static String getTranslation (TranslationKeys key) {
        String value = null;
        if (translationsMap.containsKey(key.toString())) {
            value = translationsMap.get(key.toString());
        } else {
            value = key.toString();
        }
        return value;
    }

    private static void init () {
        try {
            File file = new File(TRANSLATIONS_FILE_PATH);
            if (file.exists()) {
                TranslationsUtils.translationsMap = CSVReader.readCsvToMap(TRANSLATIONS_FILE_PATH);
            }
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getQuestion (int index) {
        TranslationKeys key = switch (index) {
            case 1 -> TranslationKeys.file_question_1;
            case 2 -> TranslationKeys.file_question_2;
            case 3 -> TranslationKeys.file_question_3;
            case 4 -> TranslationKeys.file_question_4;
            case 5 -> TranslationKeys.file_question_5;
            case 6 -> TranslationKeys.file_question_6;
            default -> TranslationKeys.general_error;
        };
        return getTranslation(key);
    }
}
