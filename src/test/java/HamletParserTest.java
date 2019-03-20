import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testText(){

        //Given
        String byeHamlet = hamletParser.replaceEveryInstanceOfHamletWithLeon(hamletText);
        String actual = hamletParser.replaceEveryInstanceOfHoratioWithTarik(byeHamlet);
        //When//Then
        Assert.assertFalse(actual.contains("Horatio"));
        Assert.assertFalse(actual.contains("Hamlet"));

    }


    @Test
    public void testChangeHamletToLeon() {
        //Given
        String before = "ssssHamletssss";
        String expected = "ssssLeonssss";

        //When
        String actual = hamletParser.replaceEveryInstanceOfHamletWithLeon(before);

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        String before = "ssssHoratiossss";
        String expected = "ssssTariqssss";

        //When
        String actual = hamletParser.replaceEveryInstanceOfHoratioWithTarik(before);

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testFindHoratio() {
        //Given
        String before = "HoratiossssHoratio";

        //When
        boolean actual = hamletParser.findHoratio(before);

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {

        //Given
        String before = "HamletssssHamlet";

       // When
        boolean actual = hamletParser.findHamlet(before);

        // Then
        Assert.assertTrue(actual);
    }

}