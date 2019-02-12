export const reverseString = (phrase) => {
    return  (new String(phrase)).split('').reverse().join('');
}