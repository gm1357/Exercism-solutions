enum Signal {

    WINK(1), DOUBLE_BLINK(2), CLOSE_YOUR_EYES(4), JUMP(8);

    private int signalValue;

    Signal(int value) {
        this.signalValue = value;
    }

    public int getValue() {
        return signalValue;
    }

    public static boolean isBitSetInNumber(int number, int bit) {
        return (number & bit) > 0;
    }

}
