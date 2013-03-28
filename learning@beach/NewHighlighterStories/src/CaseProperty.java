/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/10/12
 * Time: 5:12 PM
 */
public class CaseProperty {

    private String wordCase;

    CaseProperty (String wordCase) {

        this.wordCase = wordCase;
    }

    public String getWordCase() {

        return wordCase;
    }

    public String setCase (String targetWord) {

        if (wordCase == null) {

            return targetWord;
        }

        else if (wordCase.equals("capital")) {

            return targetWord.toUpperCase();
        }

        else if (wordCase.equals("lower")) {

            return targetWord.toLowerCase();
        }

        else if (wordCase.equals("normal")) {

            return targetWord;
        }

        return null;
    }

}
