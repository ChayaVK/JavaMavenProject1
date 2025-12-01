package Utils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.File;
import java.util.Base64;
import Utils.ConfigReader;


public class JiraAttachment {
    public static void attachScreenshot(String issueKey, String screenshotPath) throws Exception {
        String jiraUrl = "https://yadavchaya29.atlassian.net/";
        String email = "yadavchaya29@gmail.com";
        ConfigReader config = new ConfigReader();
        
        String apiToken = config.getProperty("jira_api_token");
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(jiraUrl + "/rest/api/3/issue/" + issueKey + "/attachments");

        // Authentication
        String auth = email + ":" + apiToken;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        post.setHeader("Authorization", "Basic " + encodedAuth);
        post.setHeader("X-Atlassian-Token", "no-check");

        // File attachment
        File file = new File(screenshotPath);
        HttpEntity entity = MultipartEntityBuilder.create()
                .addBinaryBody("file", file)
                .build();
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

        client.close();
    }
}
