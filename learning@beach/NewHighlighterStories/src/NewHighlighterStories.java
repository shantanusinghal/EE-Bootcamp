/**
 * Created with IntelliJ IDEA.
 * User: Shantanu
 * Date: 7/10/12
 * Time: 12:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewHighlighterStories {

    public static void main (String args []) {
        //given
        Lines inputText = new Lines ("If we write a program and compile it, then we can run the program to get output");
        RuleMappings keywords = new RuleMappings ();

        //Story 1 - default color
        keywords.add ("as", new Properties("blue",null,null));
        keywords.add ("if", new Properties("blue",null,null));
        keywords.add ("and", new Properties("blue",null,null));
        keywords.add ("then", new Properties("blue",null,null));
        keywords.add ("when", new Properties("blue",null,null));

        //when
        inputText.highlightText (keywords);

        //then
        System.out.println("The Output is :\n" + inputText.getLine());

        //Story 2 - custom color
        keywords.add ("as", new Properties("blue",null,null));
        keywords.add ("if", new Properties("red",null,null));
        keywords.add ("and", new Properties("red",null,null));
        keywords.add ("then", new Properties("green",null,null));
        keywords.add ("when", new Properties("blue",null,null));

        inputText.highlightText(keywords);
        System.out.println("The Output is :\n" + inputText.getLine());

        //Story 3 - custom color and case
        keywords.add ("as", new Properties("blue","capital",null));
        keywords.add ("if", new Properties("red","normal",null));
        keywords.add ("and", new Properties("red","capital",null));
        keywords.add ("then", new Properties("green","lower",null));
        keywords.add ("when", new Properties("blue","lower",null));

        inputText.highlightText(keywords);
        System.out.println("The Output is :\n" + inputText.getLine());

        //Story 4 - custom color, case and weight
        keywords.add ("as", new Properties("blue","capital","normal"));
        keywords.add ("if", new Properties("red","normal","bold"));
        keywords.add ("and", new Properties("red","capital","bold"));
        keywords.add ("then", new Properties("green","lower","normal"));
        keywords.add ("when", new Properties("blue","lower","normal"));

        inputText.highlightText(keywords);
        System.out.println("The Output is :\n" + inputText.getLine());

    }

}
