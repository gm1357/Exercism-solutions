object Pangram {
    
    fun isPangram(sentence: String): Boolean {
        val sentenceLowered = sentence.toLowerCase();

        for (letter in 'a'..'z')
            when { letter !in sentenceLowered -> return false; }

        return true;
    }
}