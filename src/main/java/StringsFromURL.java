import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
public class StringsFromURL {
//Retrieve contents from a URL and return them as a string, then counts one word.
    public static void main(String[] args) {
      //main method
        String output = StringsFromURL.urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(output);
        int count = 0;
        int i = 0;
        while (i < output.length() - 2) {
        String check = output.substring(i, i + 3);
        if (check.equals("and") || check.equals("And")) {
            count++;
        }
        i++;
        }
        System.out.println();
        System.out.println("And appears: " + count + " times");


    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
