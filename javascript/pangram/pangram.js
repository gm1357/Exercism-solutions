export const isPangram = (sentence) => {
  let letters = new Set();

  sentence
    .toLowerCase()
    .replace(/[\d ._'"]/g, '')
    .split('')
    .forEach(letter => letters.add(letter));

  return letters.size == 26;
};
