const COLORS = [
  {color: "black", value: 0},
  {color: "brown", value: 1},
  {color: "red", value: 2},
  {color: "orange", value: 3},
  {color: "yellow", value: 4},
  {color: "green", value: 5},
  {color: "blue", value: 6},
  {color: "violet", value: 7},
  {color: "grey", value: 8},
  {color: "white", value: 9},
];

export const value = colors => {
  let colorsValue = "";

  colors.forEach(color => colorsValue += COLORS.find(resistor => resistor.color == color).value);

  return parseInt(colorsValue);
};
