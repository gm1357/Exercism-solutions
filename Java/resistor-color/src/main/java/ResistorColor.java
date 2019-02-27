import java.util.Arrays;

enum ResistorColors {
    black(0), brown(1), red(2), orange(3), yellow(4), green(5), blue(6), violet(7), grey(8), white(9);

    private final int colorCode;

    ResistorColors(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getColorCode() {
        return colorCode;
    }

    public static String[] getColors() {
        return Arrays.stream(ResistorColors.values()).map(Enum::name).toArray(String[]::new);
    }
}

class ResistorColor {
    int colorCode(String color) {
        return ResistorColors.valueOf(color).getColorCode();
    }

    String[] colors() {
        return ResistorColors.getColors();
    }
}
