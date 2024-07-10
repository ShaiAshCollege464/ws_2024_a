public class ErrorCodes {
    public static final int ERROR_CODE_ID_NOT_FOUND = 2003;

    public static final String codeToText (Integer code) {
        String text = null;
        if (code != null) {
            text = switch (code) {
                case 2003 -> TranslationsUtils.getTranslation(TranslationKeys.id_not_found);
                default -> TranslationsUtils.getTranslation(TranslationKeys.general_error);
            };
        }
        return text;
    }
}
