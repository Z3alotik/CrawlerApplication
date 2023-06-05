package pageFetch;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import java.io.IOException;

public class PageFetch {

    public String fetch(String url) throws IOException {
        Document document = Jsoup.connect(url).ignoreHttpErrors(true).get();
        return document.html();
    }
}
