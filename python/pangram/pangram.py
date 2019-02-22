import string

def is_pangram(sentence):
    letters_alphabet = list(string.ascii_lowercase)
    letters_sentence = list(sentence.lower())

    for letter in letters_sentence:
        if letter in letters_alphabet:
            letters_alphabet.remove(letter)

    return len(letters_alphabet) == 0