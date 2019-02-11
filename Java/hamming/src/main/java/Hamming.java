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
        int distance = 0;

        for (int i = 0; i < this.length; i++) {
            if (this.leftStrand.charAt(i) != this.rightStrand.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }

}
