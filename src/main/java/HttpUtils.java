import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.URI;

public class HttpUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static IdentifyResponse identify (String id, int testId) throws Exception {
        IdentifyResponse result = null;
        CloseableHttpClient client = HttpClients.createDefault();
        URI uri = new URIBuilder(
                String.format("%s/%s/%s", Constants.SERVER_DOMAIN, Constants.SERVER_PATH_PREFIX, RequestsPaths.identify))
                .setParameter(Constants.PARAM_ID, id)
                .setParameter(Constants.PARAM_TEST_ID, String.valueOf(testId))
                .build();
        HttpPost postRequest = new HttpPost(uri);
        CloseableHttpResponse response = client.execute(postRequest);
        if (response != null) {
            result = mapper.readValue(EntityUtils.toByteArray(response.getEntity()), IdentifyResponse.class);
        }
        return result;
    }

    public static ExtraResponse question1 () throws Exception {
        Creds creds = Utils.getCreds();
        IdentifyResponse result = null;
        CloseableHttpClient client = HttpClients.createDefault();
        URI uri = new URIBuilder(
                String.format("%s/%s/%s", Constants.SERVER_DOMAIN, Constants.SERVER_PATH_PREFIX, RequestsPaths.question_1))
                .setParameter(Constants.PARAM_ID, creds.getId())
                .setParameter(Constants.PARAM_TEST_ID, String.valueOf(creds.getTestId()))
                .setParameter(Constants.PARAM_MAGIC, creds.getMagic())
                .build();
        HttpPost postRequest = new HttpPost(uri);
        CloseableHttpResponse response = client.execute(postRequest);
        if (response != null) {
            result = mapper.readValue(EntityUtils.toByteArray(response.getEntity()), IdentifyResponse.class);
        }
        return result;
    }

    public static ExtraResponse question2 () throws Exception {
        Creds creds = Utils.getCreds();
        IdentifyResponse result = null;
        CloseableHttpClient client = HttpClients.createDefault();
        URI uri = new URIBuilder(
                String.format("%s/%s/%s", Constants.SERVER_DOMAIN, Constants.SERVER_PATH_PREFIX, RequestsPaths.question_2))
                .setParameter(Constants.PARAM_ID, creds.getId())
                .setParameter(Constants.PARAM_TEST_ID, String.valueOf(creds.getTestId()))
                .setParameter(Constants.PARAM_MAGIC, creds.getMagic())
                .build();
        HttpPost postRequest = new HttpPost(uri);
        CloseableHttpResponse response = client.execute(postRequest);
        if (response != null) {
            result = mapper.readValue(EntityUtils.toByteArray(response.getEntity()), IdentifyResponse.class);
        }
        return result;
    }

    public static ExtraResponse myImage () throws Exception {
        Creds creds = Utils.getCreds();
        IdentifyResponse result = null;
        CloseableHttpClient client = HttpClients.createDefault();
        URI uri = new URIBuilder(
                String.format("%s/%s/%s", Constants.SERVER_DOMAIN, Constants.SERVER_PATH_PREFIX, RequestsPaths.my_image))
                .setParameter(Constants.PARAM_ID, creds.getId())
                .setParameter(Constants.PARAM_TEST_ID, String.valueOf(creds.getTestId()))
                .setParameter(Constants.PARAM_MAGIC, creds.getMagic())
                .build();
        HttpPost postRequest = new HttpPost(uri);
        CloseableHttpResponse response = client.execute(postRequest);
        if (response != null) {
            result = mapper.readValue(EntityUtils.toByteArray(response.getEntity()), IdentifyResponse.class);
        }
        return result;
    }

}
