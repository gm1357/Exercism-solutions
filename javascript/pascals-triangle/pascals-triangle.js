export const rows = (num) => {
  const pascalTriangle = [];

  for (let i = 0; i < num; i++) {
    const row = [];
    if (i === 0) {
      pascalTriangle.push([1]);
      continue;
    }

    const previouRow = pascalTriangle[i - 1];

    for (let j = 0; j <= previouRow.length; j++) {
      const left = j !== 0 ? previouRow[j - 1] : 0;
      const right = j !== previouRow.length ? previouRow[j] : 0;
      row.push(left + right);
    }
    pascalTriangle.push(row);
  }

  return pascalTriangle;
};