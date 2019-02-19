export const gigasecond =  (initialDate) => {
    return new Date(initialDate.getTime() + 1000 * (10 ** 9));
};