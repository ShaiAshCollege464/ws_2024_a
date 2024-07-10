import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Utils {
    private static Creds creds = null;

    public static final String CREDS_FILE_PATH = "creds";

    public static void saveIdentifyCode () {
        Creds creds = null;
        try {
            File credsFile = new File(CREDS_FILE_PATH);
            if (credsFile.exists()) {
                creds = Creds.readDataFromFile(CREDS_FILE_PATH);
            } else {
                creds = getInitialCreds();
                if (creds != null) {
                    FileWriter fileWriter = new FileWriter(CREDS_FILE_PATH);
                    creds.writeDataToFile(fileWriter);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        Utils.creds = creds;
    }


    public static Creds getInitialCreds () {
        Creds creds = null;
        while (true) {
            try {
                System.out.println(TranslationsUtils.getTranslation(TranslationKeys.enter_test_id));
                int testId = new Scanner(System.in).nextInt();
                System.out.println(TranslationsUtils.getTranslation(TranslationKeys.enter_id));
                String id = new Scanner(System.in).next();
                IdentifyResponse identifyResponse = HttpUtils.identify(id, testId);
                if (identifyResponse != null) {
                    if (identifyResponse.isSuccess()) {
                        if (identifyResponse.getExtra() != null && identifyResponse.getExtra().length() > 0 && identifyResponse.getName() != null && identifyResponse.getName().length() > 0) {
                            creds = new Creds(id, testId, identifyResponse.getExtra(), identifyResponse.getName());
                            break;
                        } else {
                            System.out.println(TranslationsUtils.getTranslation(TranslationKeys.general_error));
                        }
                    } else {
                        if (identifyResponse.getErrorCode() != null) {
                            System.out.println(ErrorCodes.codeToText(identifyResponse.getErrorCode()));
                        } else {
                            System.out.println(TranslationsUtils.getTranslation(TranslationKeys.general_error));

                        }
                    }
                } else {
                    System.out.println(TranslationsUtils.getTranslation(TranslationKeys.something_went_wrong));
                }
            } catch (Exception e) {
                System.out.println(TranslationsUtils.getTranslation(TranslationKeys.something_went_wrong));
            }
        }
        return creds;
    }

    public static Creds getCreds () {
        return Utils.creds;
    }

}
