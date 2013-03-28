/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/10/12
 * Time: 5:12 PM
 */
public class WeightProperty {

    private String weight;

    WeightProperty (String weight) {

        this.weight = weight;
    }

    public String getWeight() {

        return weight;
    }

    public String setWeight (String targetWord) {

        if (weight != null) {

            return String.format ("[" + weight + "]" + targetWord + "[" + weight + "]");
        }

        else
            return targetWord;
    }
}
