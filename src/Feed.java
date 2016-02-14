import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Feed {

    public InputStream setURL(String Id){
        try{
            InputStream feed = new URL("http://www.npr.org/rss/rss.php?id="+Id).openStream();
            return feed;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
