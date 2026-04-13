package utils;

public class URLUtils {

    public static String[] processURL(String url) {

        if (url.startsWith("http://")) {
            url = url.substring(7);
        } else if (url.startsWith("https://")) {
            url = url.substring(8);
        }

        int end = url.length();
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '/' || url.charAt(i) == '?' || url.charAt(i) == '#') {
                end = i;
                break;
            }
        }

        String domain = url.substring(0, end);
        String[] parts = domain.split("\\.");

        String lastTwo;
        if (parts.length >= 2) {
            lastTwo = parts[parts.length - 2] + "." + parts[parts.length - 1];
        } else {
            lastTwo = domain;
        }

        return new String[]{domain, lastTwo};
    }
}
