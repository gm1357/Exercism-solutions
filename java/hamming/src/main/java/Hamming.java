import java.util.stream.IntStream;

class Hamming {

    private String leftStrand;
    private String rightStrand;
    private Integer length;

    Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        this.length = leftStrand.length();
    }

    int getHammingDistance() {
        return (int) IntStream.range(0, this.length)
                              .filter(i -> this.leftStrand.charAt(i) != this.rightStrand.charAt(i))
                              .count();
    }

}
