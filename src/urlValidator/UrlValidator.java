package urlValidator;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlValidator {

    public static boolean isFromDomain(String baseURL, String link) {
        try {
            URL baseUrl = new URL(baseURL);
            URL linkUrl = new URL(link);

            return baseUrl.getHost().equals(linkUrl.getHost());
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
