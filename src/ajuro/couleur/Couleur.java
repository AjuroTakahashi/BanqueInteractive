package ajuro.couleur;

import java.awt.*;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Couleur {

    private int rouge = 0;
    private int bleu = 0;
    private int vert = 0;
    private String hexValue = "";

    public Couleur(int rouge, int bleu, int vert) {
        if (isCorrectColor(rouge) && isCorrectColor(bleu) && isCorrectColor(vert)) {
            this.rouge = rouge;
            this.bleu = bleu;
            this.vert = vert;
            setHexValue(String.format("#%02x%02x%02x", rouge, vert, bleu));
        } else {
            throw new IllegalArgumentException("Couleur incorrecte");
        }
    }

    public Couleur (String hexValue) {
        if (isCorrectHexValue(hexValue)) {
            setHexValue(hexValue);
            Color color = Color.decode(hexValue);
            this.rouge = color.getRed();
            this.bleu = color.getBlue();
            this.vert = color.getGreen();
        } else {
            throw new IllegalArgumentException("Chaîne de caractères incorrecte");
        }
    }

    public int getRed() {
        return this.rouge;
    }

    public void setRed(int rouge) {
        if (isCorrectColor(rouge)) {
            this.rouge = rouge;
            setHexValue(String.format("#%02x%02x%02x", rouge, vert, bleu));
        } else {
            throw new IllegalArgumentException("Couleur Incorrecte : rouge");
        }
    }

    public int getBlue() {
        return this.bleu;
    }

    public void setBlue(int bleu) {
        if (isCorrectColor(bleu)) {
            this.bleu = bleu;
            setHexValue(String.format("#%02x%02x%02x", rouge, vert, bleu));
        } else {
            throw new IllegalArgumentException("Couleur Incorrecte : bleu " + bleu);
        }
    }

    public int getGreen() {
        return this.vert;
    }

    public void setGreen(int vert) {
        if (isCorrectColor(vert)) {
            this.vert = vert;
            setHexValue(String.format("#%02x%02x%02x", rouge, vert, bleu));
        } else {
            throw new IllegalArgumentException("Couleur Incorrecte : vert");
        }
    }

    public String getHexValue() {
        return this.hexValue;
    }

    public void setHexValue(String hexValue) {
        if (isCorrectHexValue(hexValue)) {
            this.hexValue = hexValue.toUpperCase(Locale.ROOT);
        } else {
            throw new IllegalArgumentException("Valeur hexadécimale incorrecte");
        }
    }

    private boolean isCorrectColor(int color) {
        return color >= 0 && color <= 255;
    }

    private boolean isCorrectHexValue(String hexValue) {
        if (hexValue != null) {
            Pattern pattern = Pattern.compile("#([A-F|a-f]|\\d){6}$");
            Matcher matcher = pattern.matcher(hexValue);
            return matcher.matches();
        }
        return false;
    }

    @Override
    public String toString() {
        return  "[value=" + hexValue +
                ", r=" + rouge +
                ", g=" + vert +
                ", b=" + bleu + "]"
                ;
    }
}
