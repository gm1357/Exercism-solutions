import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Scrabble {

    private static final char[] FIRST_SET = new char[]{'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'};
    private static final int FIRST_SET_POINTS = 1;
    private static final char[] SECOND_SET = new char[]{'D', 'G'};
    private static final int SECOND_SET_POINTS = 2;
    private static final char[] THIRD_SET = new char[]{'B', 'C', 'M', 'P'};
    private static final int THIRD_SET_POINTS = 3;
    private static final char[] FOURTH_SET = new char[]{'F', 'H', 'V', 'W', 'Y'};
    private static final int FOURTH_SET_POINTS = 4;
    private static final char[] FIFTH_SET = new char[]{'K'};
    private static final int FIFTH_SET_POINTS = 5;
    private static final char[] SIXTH_SET = new char[]{'J', 'X'};
    private static final int SIXTH_SET_POINTS = 8;
    private static final char[] SEVENTH_SET = new char[]{'Q', 'Z'};
    private static final int SEVENTH_SET_POINTS = 10;
    
    private int score = 0;
    private List<char[]> rule_list = new ArrayList<char[]>();
    private List<Integer> point_list = new ArrayList<Integer>();

    Scrabble(String word) {
        rule_list.add(FIRST_SET);
        rule_list.add(SECOND_SET);
        rule_list.add(THIRD_SET);
        rule_list.add(FOURTH_SET);
        rule_list.add(FIFTH_SET);
        rule_list.add(SIXTH_SET);
        rule_list.add(SEVENTH_SET);

        point_list.add(FIRST_SET_POINTS);
        point_list.add(SECOND_SET_POINTS);
        point_list.add(THIRD_SET_POINTS);
        point_list.add(FOURTH_SET_POINTS);
        point_list.add(FIFTH_SET_POINTS);
        point_list.add(SIXTH_SET_POINTS);
        point_list.add(SEVENTH_SET_POINTS);

        this.calculateScore(word.toUpperCase());
    }

    void calculateScore(String word) {
        for (Character letter : word.toCharArray()) {
            this.score += checkLetter(letter);
        }
    }

    int checkLetter(Character letter) {
        int index = 0;
        for (char[] rule : rule_list) {
            if (new String(rule).contains(letter.toString())) {
                return point_list.get(index);
            }
            index++;
        }
        return 0;
    }

    int getScore() {
        return this.score;
    }

}
