package crawler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import urlValidator.UrlValidator;
import linkParse.LinkParser;
import pageFetch.PageFetch;

public class Crawler {
    private static final int MAX_DEPTH = 1;
    private Set<String> visitedUrls;

    public Crawler() {
        visitedUrls = new HashSet<>();
    }

    public void crawl(String url) {
        crawl(url, 0);
    }

    private void crawl(String url, int depth) {
        if (depth > MAX_DEPTH || visitedUrls.contains(url)) {
            return;
        }
        System.out.println(url);
        visitedUrls.add(url);

        try {
            PageFetch pageFetch = new PageFetch();
            String content = pageFetch.fetch(url);

            LinkParser linkParser = new LinkParser();
            Set<String> links = linkParser.parse(content);

            for (String link : links) {
                if (UrlValidator.isFromDomain(url, link)) {
                    crawl(link, depth + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
