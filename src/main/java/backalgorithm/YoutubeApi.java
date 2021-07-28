package backalgorithm; /**
 * Sample Java code for youtube.commentThreads.list
 * See instructions for running these code samples locally:
 * https://developers.google.com/explorer-help/guides/code_samples#java
 */

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.CommentThreadListResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class YoutubeApi {
    // You need to set this value for your code to compile.
    // For example: ... DEVELOPER_KEY = "YOUR ACTUAL KEY";
    private static final String DEVELOPER_KEY = "AIzaSyBo706xyfkjFA57ZQgNyWt1jKYg8HORXh0";

    private static final String APPLICATION_NAME = "API code samples";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static CommentThreadListResponse response;

//    CommentThreadListResponse response;

    /**
     * Build and return an authorized API client service.
     *
     * @return an authorized API client service
     * @throws GeneralSecurityException, IOException
     */
    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     * Call function to create API service object. Define and
     * execute API request. Print API response.
     *
     * @throws GeneralSecurityException, IOException, GoogleJsonResponseException
     */
    public static void main(String[] args) throws GeneralSecurityException, IOException, GoogleJsonResponseException, ParseException {
        YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.CommentThreads.List request = youtubeService.commentThreads()
                .list("snippet");

        response = request.setKey(DEVELOPER_KEY)
                .setMaxResults(100L)
                .setTextFormat("plainText")
                .setVideoId("lqzExR7QSMw")
                .execute();
        String result = response.toString();

        Json.get(result,"심상정");
        do {
            try {
                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
                String token = (String) jsonObject.get("nextPageToken");
                System.out.println(token);
                response = request.setPageToken(token)
                        .setMaxResults(100L)
                        .setTextFormat("plainText")
                        .setVideoId("lqzExR7QSMw")
                        .execute();
                Json.get(response.toString(),"심상정");
                result = response.toString();
            }catch (Exception e){
                break;
            }
        }while (true);

    }
}