package ee.bootcamp.dd;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ShellSpecs {

    @Test
    public void itShouldExecuteTailCommand() {
        //Given
        Shell shell = new Shell();
        //When
        String response = shell.execute("tail readme.txt");
        //Then
        assertEquals(response,  "11\n" +
                                "12\n" +
                                "13\n" +
                                "14\n" +
                                "15\n" +
                                "16\n" +
                                "17\n" +
                                "18\n" +
                                "19\n" +
                                "20");
    }

    @Test
    public void itShouldExecuteTailCommandWithCustomLineOption() {
        //Given
        Shell shell = new Shell();
        //When
        String response = shell.execute("tail -l 5 readme.txt");
        //Then
        assertEquals(response,  "16\n" +
                                "17\n" +
                                "18\n" +
                                "19\n" +
                                "20");

    }

    @Test
    public void itShouldExecuteTailCommandWithRedirectionOperator() {
        //Given
        Shell shell = new Shell();
        //When
        String response = shell.execute("tail readme.txt > dump.txt");
        //Then
        assertEquals(response, "Command successful");
        assertEquals(shell.execute("tail dump.txt"),    "11\n" +
                                                        "12\n" +
                                                        "13\n" +
                                                        "14\n" +
                                                        "15\n" +
                                                        "16\n" +
                                                        "17\n" +
                                                        "18\n" +
                                                        "19\n" +
                                                        "20");

    }

    @Test
    public void itShouldExecuteTailCommandWithLineNumberOptionSet() {
        //Given
        Shell shell = new Shell();
        //When
        String response = shell.execute("tail -n readme.txt");
        //Then
        assertEquals(response,    "11 11\n" +
                                  "12 12\n" +
                                  "13 13\n" +
                                  "14 14\n" +
                                  "15 15\n" +
                                  "16 16\n" +
                                  "17 17\n" +
                                  "18 18\n" +
                                  "19 19\n" +
                                  "20 20");
    }

    @Test
    public void itShouldExecuteTailCommandWithCustomLinesAndLineNumberOptionSet() {
        //Given
        Shell shell = new Shell();
        //When
        String response = shell.execute("tail -l 5 -n readme.txt");
        //Then
        assertEquals(response,    "16 16\n" +
                                  "17 17\n" +
                                  "18 18\n" +
                                  "19 19\n" +
                                  "20 20");
    }

    @Test
    public void itShouldExecuteCopyCommand() {
        //Given
        Shell shell = new Shell();
        //When
        String response = shell.execute("copy readMe.txt CopyOfReadMe.txt");
        //Then
        assertEquals(response, "readMe.txt successfully copied to CopyOfReadMe.txt");
        assertEquals(shell.execute("tail -l 20 readme.txt"), shell.execute("tail -l 20 CopyOfReadMe.txt"));
    }

}
