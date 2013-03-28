import javax.swing.text.Highlighter;

/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/10/12
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Properties {

    private ColorProperty color;
    private CaseProperty wordCase;
    private WeightProperty weight;

    Properties (String color, String wordCase, String weight) {

        this.color = new ColorProperty (color);
        this.wordCase = new CaseProperty (wordCase);
        this.weight = new WeightProperty (weight);
    }

    public String addColorTag (String targetWord) {

        return color.setColor (targetWord);
    }

    public String addWeightTag (String targetWord) {

        return weight.setWeight (targetWord);
    }

    public String changeCase (String targetWord) {

        return wordCase.setCase (targetWord);
    }
}
