const GIGASECOND_IN_MS = (10 ** 9) * 1000

export const gigasecond =  (initialDate) => {
    return new Date(initialDate.getTime() + GIGASECOND_IN_MS);
};