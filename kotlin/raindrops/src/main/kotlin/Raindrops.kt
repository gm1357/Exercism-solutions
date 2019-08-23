object Raindrops {

    fun convert(number: Int): String {
        val factors = getFactor(number)
        var phrase = ""

        if (3 in factors) phrase += "Pling"
        if (5 in factors) phrase += "Plang"
        if (7 in factors) phrase += "Plong"
        if (phrase == "") phrase = number.toString()

        return phrase;
    }

    fun getFactor(number: Int) = (1..number).filter { number.rem(it) == 0 }
}