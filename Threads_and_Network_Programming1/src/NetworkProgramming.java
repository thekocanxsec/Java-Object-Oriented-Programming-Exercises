import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NetworkProgramming {

    static void main(String[] args) throws IOException {
        //readUrl("https://klix.ba");
        //readUrl("unknown://something.ba");
        //readPageData("https://klix.ba");
        readPageData("https://avaz.ba");


    }

    public static void readUrl(String urlAddress){
        try{
            URL url = new URL(urlAddress);
            System.out.println("URL is OK! Protocol used is: " + url.getProtocol() + ", and the authority is: " + url.getAuthority());
        }catch(MalformedURLException e){
            System.out.println("URL: " + urlAddress + " is not valid URL!");

        }
    }

    public static void readPageData(String urlAddress) throws IOException {
        URL url = new URL(urlAddress);
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
        String content = "";
        String line = null;

        while ((line = inputStream.readLine()) != null) content = content + line;

        String pattern = "<h2[^>]*>(.*?)</h2>";

        Pattern regex = Pattern.compile(pattern, Pattern.DOTALL);
        Matcher matcher = regex.matcher(content);

        while(matcher.find()){
            String hContent = matcher.group(1);
            System.out.println("Matched header content: " + hContent);
        }

    }
}


