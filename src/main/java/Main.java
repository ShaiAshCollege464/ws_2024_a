import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileVisitResult;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Utils.saveIdentifyCode();
        if (Utils.getCreds() != null) {
            System.out.println(Utils.getCreds());
            Window window = new Window();
        }
    }


}
