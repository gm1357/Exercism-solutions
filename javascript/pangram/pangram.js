export const isPangram = (sentence) => {
  return "abcdefghijklmnopqrstuvwxyz"
    .split('')
    .filter(letter => !sentence.toLowerCase().includes(letter))
    .length == 0
};
