import java.util.ArrayList;
import java.util.List;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        Integer length = phrase.length();
        List<String> words = new ArrayList<String>();
        String letter = "";

        for (int i = 0; i < length; i++) {
            letter = Character.toString(phrase.charAt(i)).toLowerCase();
            if (words.contains(letter)
                && !letter.equals("-")
                && !letter.equals(" ")) {
                return false;
            }
            words.add(letter);
        }

        return true;
    }

}
