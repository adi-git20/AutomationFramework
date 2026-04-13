package Tests;

import org.testng.annotations.Test;
import utils.URLUtils;

import java.io.*;

public class urlTest {

    @Test
    public void readURLsFromFile() {

        String filePath = "src/test/resources/urls.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            int count = 1;

            while ((line = br.readLine()) != null) {

                String[] result = URLUtils.processURL(line);

                System.out.println(count + " URL: [" 
                        + result[0] + ", " + result[1] + "]");

                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
