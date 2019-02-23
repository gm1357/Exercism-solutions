def abbreviate(words):
    list_of_words = words.replace('-', ' ').replace('\'', '').replace('_', '').split()
    return ''.join(word[0] for word in list_of_words).upper()