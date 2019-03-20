import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }


    public String replaceEveryInstanceOfHamletWithLeon(String hamlet){
         String hamletRegex = "Hamlet";
         Pattern pattern = Pattern.compile(hamletRegex, Pattern.CASE_INSENSITIVE);
         Matcher m = pattern.matcher(hamlet);
         hamlet = m.replaceAll("Leon");
         return hamlet;
    }

    public String replaceEveryInstanceOfHoratioWithTarik(String horatio){
        String hamletRegex = "Horatio";
        Pattern pattern = Pattern.compile(hamletRegex, Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(horatio);
        horatio = m.replaceAll("Tariq");
        return horatio;
    }

    public boolean findHoratio(String stringToCheck){
        String regex = "Horatio";
        Pattern pattern = Pattern.compile(regex);//, Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(stringToCheck);
        boolean b = m.lookingAt();
        return b;
    }

    public boolean findHamlet(String stringToCheck){
        String regex = "Hamlet";
        Pattern pattern = Pattern.compile(regex);//, Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(stringToCheck);
        boolean b = m.lookingAt();
        return b;
    }

}
