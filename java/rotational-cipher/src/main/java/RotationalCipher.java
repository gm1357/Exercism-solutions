import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RotationalCipher {

    private List<String> alphabet = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
    private int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder cipherBuilder = new StringBuilder();

        for (String character : data.split("")) {
            boolean isUpperCase = character == character.toUpperCase();
            int index = alphabet.indexOf(character.toLowerCase());

            if (index != -1) {
                character = alphabet.get((index + this.shiftKey) % 26);
            }

            cipherBuilder.append(isUpperCase ? character.toUpperCase() : character);
        }

        return cipherBuilder.toString();
    }

}
