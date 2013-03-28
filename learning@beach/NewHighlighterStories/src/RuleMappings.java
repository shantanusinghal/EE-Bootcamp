import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/10/12
 * Time: 11:23 PM
 */

//creates a <key, value> pair style mapping between the user defined keywords and their associated properties
public class RuleMappings {

    private ArrayList <String> keyAsWord = new ArrayList <String> ();
    private ArrayList <Properties> valueAsProperties = new ArrayList <Properties> ();

    //populate the rules dictionary
    public void add (String word, Properties properties) {

        keyAsWord.add (word.toLowerCase());
        valueAsProperties.add (keyAsWord.indexOf (word.toLowerCase ()), properties);
    }

    //check if the word is present in the rules dictionary
    public boolean containsKey(String targetWord) {

        if (keyAsWord.contains(targetWord.toLowerCase()))
            return true;

        else
            return false;
    }

    //use method chain to apply the syntax highlighting and return the formatted string
    public String getFormattedWord(String targetWord) {

        String formattedWord = targetWord;

        formattedWord = valueAsProperties.get (keyAsWord.indexOf (targetWord.toLowerCase ())).changeCase (formattedWord);
        formattedWord = valueAsProperties.get (keyAsWord.indexOf (targetWord.toLowerCase ())).addWeightTag (formattedWord);
        formattedWord = valueAsProperties.get (keyAsWord.indexOf (targetWord.toLowerCase ())).addColorTag (formattedWord);

        return formattedWord;
    }
}
