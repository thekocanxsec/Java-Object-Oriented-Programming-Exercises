import java.net.URL;

public static void postExample() throws IOException {
    URL url = new URL("http://localhost:8000/api/tasks/user1@example.com");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/json; utf-8");
    connection.setRequestProperty("Accept", "application/json");
    connection.setDoOutput(true);

    String jsonInput = "{\"title\": \"Sample task\", \"description\": \"Pay all bills!\", \"priority\": \"HIGH\", \"status\": \"PENDING\"}";
    OutputStream outputStream = connection.getOutputStream();
    byte[] input = jsonInput.getBytes("utf-8");
    outputStream.write(input, 0, input.length);
    System.out.println(connection.getResponseCode());
}

void main() {
}

