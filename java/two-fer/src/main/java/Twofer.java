import java.util.Objects;

class Twofer {
    String twofer(String name) {
        return "One for " + Objects.toString(name, "you") + ", one for me.";
    }
}
