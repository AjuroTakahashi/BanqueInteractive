package pendu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class WordUtil {

    private static final String FILE_NAME = "dictionnaire_1.txt";

    public static String generateRandomWord() {
        String generatedWord = null;
        try {
            Path path = Paths.get(FILE_NAME);

            Random random = new Random();
            long nbLinesInFile = Files.lines(path).count();
            long randomNbLine = random.longs(1, 1, nbLinesInFile).sum();
            generatedWord = Files.readAllLines(path).get((int) randomNbLine);
        } catch (IOException e) {
            System.err.println("Cannot generate word : Dictionnary file not found");
        }
        return generatedWord;
    }


}
