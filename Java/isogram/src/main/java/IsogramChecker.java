import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        Integer length = phrase.length();
        String lowerCasePhrase = phrase.toLowerCase();
        Set<Character> words = new HashSet<Character>();

        for (int i = 0; i < length; i++) {
            Character letter = lowerCasePhrase.charAt(i);
            if (!letter.equals('-')
                && !letter.equals(' ')
                && words.contains(letter)) {
                return false;
            }
            words.add(letter);
        }

        return true;
    }

}
