import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParagraphLoader {

    private static final Properties paragraphs = new Properties();

    static {
        try (InputStream input = ParagraphLoader.class.getClassLoader().getResourceAsStream("paragraphs.properties")) { // Using resource stream
            if (input == null) {
                System.err.println("Error: paragraphs.properties not found in classpath.");
            } else {
                paragraphs.load(input);
            }
        } catch (IOException e) {
            System.err.println("Error loading paragraphs.properties: " + e.getMessage());
        }
    }

    public static String getParagraph(String choice) {
        String paragraph = paragraphs.getProperty(choice);
        if (paragraph == null) {
            return "Error: Paragraph not found for choice: " + choice;
        }
        return paragraph;
    }
}