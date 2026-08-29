import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

class JsonReaders {
    static void main(String[] args) throws IOException {
        readJson("https://mocki.io/v1/b338a8e7-edf4-393d-a3e5-d3a424a744b5");

    }
    public static void readSimpleJson(){
        String json = "{ \"key\": \"value\" }";

        JSONObject jsonObject = new JSONObject(json);
        System.out.println(jsonObject);
        System.out.println(jsonObject.getString("key"));
    }

    public static void readJson(String urlAddress) throws IOException {
        URL url = new URL(urlAddress);
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        String content = "";
        String line = null;

        while((line = inputStream.readLine()) =! null) content = content + line;
        JSONObject jsonObject = new JSONObject(content);

        System.out.println(jsonObject.getJSONObject("preferences"));
        System.out.println(jsonObject.getJSONArray("roles"));
        System.out.println(jsonObject.getString("name"));
    }
}
