object ScrabbleScore {

    private val lettersValues = hashMapOf(
            "aeioulnrst" to 1,
            "dg" to 2,
            "bcmp" to 3,
            "fhvwy" to 4,
            "k" to 5,
            "jx" to 8,
            "qz" to 10
    )

    fun scoreWord(word: String): Int {
        return word.map {
            letter -> lettersValues.filter { entry -> entry.key.contains(letter.toLowerCase()) }.values.sum()
        }.sum()
    }

}