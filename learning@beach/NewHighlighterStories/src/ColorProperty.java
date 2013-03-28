/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/10/12
 * Time: 5:12 PM
 */
public class ColorProperty {

    private String color;

    ColorProperty (String color) {

        this.color = color;
    }

    public String getColor() {

        return color;
    }

    public String setColor (String targetWord) {

        if (color != null) {

            return String.format ("[" + color + "]" + targetWord + "[" + color + "]");
        }

        else
            return targetWord;
    }
}
