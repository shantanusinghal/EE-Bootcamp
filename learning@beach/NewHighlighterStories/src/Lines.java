import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/10/12
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lines {

    private String line;
    private String[] lineAsStringArray;

    Lines(String line) {

        this.line = line;
        lineAsStringArray = line.split("\\s");
    }

    public void highlightText (RuleMappings keywords) {

        line = "";

        for (String aWord : lineAsStringArray) {

            if (keywords.containsKey (aWord)) {

                aWord = keywords.getFormattedWord (aWord);
            }

            line = line.concat (aWord + " ");
        }
    }

    public String getLine() {

          return line;
    }

}
