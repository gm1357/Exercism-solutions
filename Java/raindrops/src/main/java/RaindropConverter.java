class RaindropConverter {

    String convert(int number) {
        StringBuilder sb = new StringBuilder();

        if (number % 3 == 0) {
            sb.append("Pling");
        }
        if (number % 5 == 0) {
            sb.append("Plang");
        }
        if (number % 7 == 0) {
            sb.append("Plong");
        }
        
        return (sb.toString().equals("") ? Integer.toString(number) : sb.toString());
    }

}
