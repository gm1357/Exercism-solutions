const testSilence = (msg) => msg === '';
const testAtLeastOneNoCaps = (msg) => !/[a-z]/.test(msg);
const testAtLeastOneCaps = (msg) => /[A-Z]/.test(msg);
const testQuestion = (msg) => /\?$/.test(msg);
const testYell = (msg) => testAtLeastOneNoCaps(msg) && testAtLeastOneCaps(msg);
const testYellQuestion = (msg) => testYell(msg) && testQuestion(msg);

const ANSWER_SILENCE = 'Fine. Be that way!';
const ANSWER_YELL_QUESTION = 'Calm down, I know what I\'m doing!';
const ANSWER_YELL = 'Whoa, chill out!';
const ANSWER_QUESTION = 'Sure.';
const ANSWER_DEFAULT = 'Whatever.';

export const hey = (message) => {
  message = message.trim();

  if (testSilence(message)) {
    return ANSWER_SILENCE;  
  }

  if (testYellQuestion(message)) {
    return ANSWER_YELL_QUESTION;
  }

  if (testYell(message)) {
    return ANSWER_YELL;
  }

  if (testQuestion(message)) {
    return ANSWER_QUESTION;
  }

  return ANSWER_DEFAULT;
};
