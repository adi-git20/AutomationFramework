import java.util.*;

public class solution {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);

    	// FIXED INPUT
    	System.out.print("Enter number of URLs: ");
    	int n = Integer.parseInt(sc.nextLine());

    	String[] urls = new String[n];

    	System.out.println("Enter URLs:");
    	for (int i = 0; i < n; i++) {
    	    urls[i] = sc.nextLine();
    	}

    	int count = Math.min(2, n);

    	for (int i = 0; i < count; i++) {
    	    String[] result = processURL(urls[i]);

    	    System.out.println((i + 1) + " URL: ["
    	            + result[0] + ", " + result[1] + "]");
    	}

        sc.close();
    }

    public static String[] processURL(String url) {

        // Step 1: Remove protocol
        if (url.startsWith("http://")) {
            url = url.substring(7);
        } else if (url.startsWith("https://")) {
            url = url.substring(8);
        }

        // Step 2: Find domain end
        int end = url.length();
        for (int i = 0; i < url.length(); i++) {
            char ch = url.charAt(i);
            if (ch == '/' || ch == '?' || ch == '#') {
                end = i;
                break;
            }
        }

        // Step 3: Extract domain
        String domain = url.substring(0, end);

        // Step 4: Split domain
        String[] parts = domain.split("\\.");

        // Step 5: Get last two parts
        String lastTwo;
        if (parts.length >= 2) {
            lastTwo = parts[parts.length - 2] + "." + parts[parts.length - 1];
        } else {
            lastTwo = domain;
        }

        return new String[]{domain, lastTwo};
    }
}