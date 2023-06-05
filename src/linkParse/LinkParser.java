package linkParse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.util.HashSet;
import java.util.Set;

public class LinkParser {

    public Set<String> parse(String html) {

        Document document = Jsoup.parse(html);
        Elements links = document.select("a[href]");

        Set<String> parsedLinks = new HashSet<>();

        for (Element link : links) {
            parsedLinks.add(link.absUrl("href"));
        }
        return parsedLinks;
    }
}
