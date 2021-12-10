package pendu;

import com.sun.istack.internal.Nullable;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class JeuDuPendu {

    public Scanner scanner = new Scanner(System.in);
    public Map<Integer, Character> lettersModel = new HashMap<Integer, Character>();
    public Map<Integer, Character> letters = new HashMap<Integer, Character>();
    public Character[] wordArray;
    public String word;
    public int maxErrors = 10;
    public int tries = 0;

    public void start() {

        word = WordUtil.generateRandomWord();
        wordArray = new Character[word.length()];

        for(int i = 0; i < wordArray.length; i++) {
            wordArray[i] = word.charAt(i);
        }

        Character[] characters = wordArray;
        int i = 0;
        for (Character c : characters) {
            lettersModel.put(i, c);
            i++;
        }

        do {
            AtomicBoolean found = new AtomicBoolean(false);
            Character[] charactersShown = new Character[0];
            for (int index = 0; index < lettersModel.size(); index++) {
                charactersShown = new Character[lettersModel.size()];
                Arrays.fill(charactersShown, '_');
                for (Map.Entry<Integer, Character> entry : letters.entrySet()) {
                    Integer key = entry.getKey();
                    Character value = entry.getValue();
                    charactersShown[key] = value;
                }
            }
            System.out.println(Arrays.toString(charactersShown));
            Character letter = giveLetter();
            lettersModel.forEach((index, l) -> {
                if (l == letter) {
                    letters.put(index, l);
                    found.set(true);
                }
            });
            if (!found.get()) {
                tries++;
            }

            System.out.println("Encore " + (maxErrors - tries) + " essais restants.");

        } while (tries != maxErrors && !letters.equals(lettersModel));

        if (tries == maxErrors) {
            System.out.println("###############");
            System.out.println("Perdu");
            System.out.println(word);
        }

        if (letters.equals(lettersModel)) {
            System.out.println("###############");
            System.out.println("Gagné");
            System.out.println(word);
        }
    }

    public @Nullable
    Character giveLetter() {
        try {
            System.out.println("Donnez une lettre");
            return scanner.next().charAt(0);

        } catch (Exception e) {
            giveLetter();
        }
        return null;
    }

    public void letterException(String letter) throws Exception {
        if (letter.length() > 1) {
            System.out.println("Trop de lettres.");
            throw new Exception();
        }
    }
}
