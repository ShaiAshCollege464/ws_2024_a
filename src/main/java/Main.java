import utils.Utils;

public class Main {

    public static void main(String[] args) {
        Utils.saveIdentifyCode();
        if (Utils.getCreds() != null) {
            System.out.println(Utils.getCreds());
            Window window = new Window();
        }
    }


}
