import okhttp3.*;

import java.io.IOException;

public class ChatGPTClient {

    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final String API_KEY = "your_openai_api_key";

    private final OkHttpClient client;

    public ChatGPTClient() {
        client = new OkHttpClient();
    }

    public void getChatResponse(String input, Callback callback) {
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                "{ \"prompt\": \"" + input + "\", \"max_tokens\": 50 }"
        );

        Request request = new Request.Builder()
                .url(API_URL)
                .header("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();

        client.newCall(request).enqueue(callback);
    }
}
