object ScrabbleScore {

    private val lettersValues = "aeioulnrst".associate {it to 1}
            .plus("dg".associate {it to 2})
            .plus("bcmp".associate {it to 3})
            .plus("fhvwy".associate {it to 4})
            .plus("k".associate {it to 5})
            .plus("jx".associate {it to 8})
            .plus("qz".associate {it to 10})

    fun scoreWord(word: String): Int {
        return word.map {
            letter -> if (lettersValues.containsKey(letter.toLowerCase())) lettersValues[letter.toLowerCase()] else 0
        }.sumBy { it!! }
    }
}