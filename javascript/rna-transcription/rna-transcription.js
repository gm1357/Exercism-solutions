export const toRna = (strand) => {
    if (strand.search(new RegExp('[^GCTA]')) !== -1) {
        throw new Error('Invalid input DNA.');
    }

    return strand.split('').map(nucleotide => {
        switch (nucleotide) {
            case 'G':
                return 'C';
            case 'C':
                return 'G';
            case 'T':
                return 'A';
            case 'A':
                return 'U';
        }
    }).join('');
}