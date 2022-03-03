import ajuro.couleur.Couleur;
import org.junit.jupiter.api.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class Test {
    private Couleur couleur;
    private Couleur couleurHash;

    @BeforeEach
    public void setUp() {
        couleur = new Couleur(3,3,3);
        couleurHash = new Couleur("#A2AA23");
    }

    @AfterEach
    public void tearDown() {
        couleur = null;
    }

    @org.junit.jupiter.api.Test
    public void testIsNotNull() {
        assertNotNull(couleur, "La couleur est null");
    }

    @org.junit.jupiter.api.Test
    public void testGetRouge() {
        Assertions.assertEquals(2, couleur.getRed(), "Ce n'est pas le bon nombre");
    }

    @org.junit.jupiter.api.Test
    public void testSetRouge() {
        try {
            couleur.setRed(-2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    public void startsWithHash() {
        assertTrue(couleurHash.getHexValue().startsWith("#"), "La chaîne ne commence pas par un '#'");
    }

    @org.junit.jupiter.api.Test
    public void hexLengthIsCorrect() {
        Pattern p = Pattern.compile("#\\w{6}$");
        Matcher m = p.matcher(couleurHash.getHexValue());
        assertTrue(m.matches(), "La chaîne n'a pas la bonne longueur");
    }

    @org.junit.jupiter.api.Test
    public void hexHasOnlyLettersOrNumbers() {
        Pattern p = Pattern.compile("#([A-F]|\\d)$");
        Matcher m = p.matcher(couleurHash.getHexValue());
        assertTrue(m.matches(), "La chaîne n'a pas que des chiffres ou des lettres (entre A et F)");
    }

    @org.junit.jupiter.api.Test
    public void samePattern() {
        Pattern pattern = Pattern.compile("#([A-F]|\\d){6}$");
        Matcher matcher = pattern.matcher(couleurHash.getHexValue());
        assertTrue(matcher.matches(), "La chaîne est mauvaise");
    }

    @org.junit.jupiter.api.Test
    public void isHexValueSet() {
        assertFalse(couleur.getHexValue().isEmpty(), "La valeur est vide");
    }

    @org.junit.jupiter.api.Test
    public void toStringExists() {
        assertEquals(couleur, "La valeur est vide");
    }
}
