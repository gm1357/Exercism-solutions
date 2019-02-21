import java.util.HashMap;
import java.util.Map;

class Scrabble {

    private static final char[] FIRST_SET = new char[]{'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'};
    private static final Integer FIRST_SET_POINTS = 1;
    private static final char[] SECOND_SET = new char[]{'D', 'G'};
    private static final Integer SECOND_SET_POINTS = 2;
    private static final char[] THIRD_SET = new char[]{'B', 'C', 'M', 'P'};
    private static final Integer THIRD_SET_POINTS = 3;
    private static final char[] FOURTH_SET = new char[]{'F', 'H', 'V', 'W', 'Y'};
    private static final Integer FOURTH_SET_POINTS = 4;
    private static final char[] FIFTH_SET = new char[]{'K'};
    private static final Integer FIFTH_SET_POINTS = 5;
    private static final char[] SIXTH_SET = new char[]{'J', 'X'};
    private static final Integer SIXTH_SET_POINTS = 8;
    private static final char[] SEVENTH_SET = new char[]{'Q', 'Z'};
    private static final Integer SEVENTH_SET_POINTS = 10;
    
    private int score = 0;
    private Map<Character, Integer> rule_set = new HashMap<Character, Integer>();

    Scrabble(String word) {
        this.putAll(FIRST_SET, FIRST_SET_POINTS);
        this.putAll(SECOND_SET, SECOND_SET_POINTS);
        this.putAll(THIRD_SET, THIRD_SET_POINTS);
        this.putAll(FOURTH_SET, FOURTH_SET_POINTS);
        this.putAll(FIFTH_SET, FIFTH_SET_POINTS);
        this.putAll(SIXTH_SET, SIXTH_SET_POINTS);
        this.putAll(SEVENTH_SET, SEVENTH_SET_POINTS);

        this.calculateScore(word.toUpperCase());
    }

    void putAll(char[] keys, Integer value) {
        for (Character key : keys) {
            rule_set.put(key, value);
        }
    }

    void calculateScore(String word) {
        for (Character letter : word.toCharArray()) {
            this.score += checkLetter(letter);
        }
    }

    int checkLetter(Character letter) {
        return rule_set.getOrDefault(letter, 0);
    }

    int getScore() {
        return this.score;
    }

}
