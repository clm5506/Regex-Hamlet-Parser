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
        String expected = "ssssTarikssss";

        //When
        String actual = hamletParser.replaceEveryInstanceOfHoratioWithTarik(before);

        //Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testFindHoratio() {
        //Given
        String before = "ssssHoratiossssHoratio";
        String expected = "ssssTarikssssTarik";

        //When
        boolean actual = hamletParser.find(before);

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testFindHamlet() {

        //Given
        String before = "ssssHamletssssHamlet";
        String expected = "ssssLeonssssLeon";

        //When
        boolean actual = hamletParser.find(before);

        //Then
        Assert.assertTrue(actual);
    }
    
}