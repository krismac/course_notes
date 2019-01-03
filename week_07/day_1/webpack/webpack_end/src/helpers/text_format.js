const TextFormat = {};

TextFormat.capitalise = function (text) {
  if (!text) return text;
  const initialLetter = text[0];
  const restOfWord = text.slice(1);
  return initialLetter.toUpperCase() + restOfWord.toLowerCase();
};

module.exports = TextFormat;
