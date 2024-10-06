function areSentencesSimilar(sentence1: string, sentence2: string): boolean {
  const longSentence = sentence1.length >= sentence2.length ? sentence1 : sentence2;
  const shortSentence = sentence1.length < sentence2.length ? sentence1 : sentence2;

  if (longSentence === shortSentence) return true;

  const splitedShortSentence = shortSentence.split(" ");
  const wordCount = splitedShortSentence.length;

  for (let i = 0; i <= wordCount; i++) {
    const preSentence = splitedShortSentence.slice(0, i).join(' ');
    const postSentence = splitedShortSentence.slice(i).join(' ');

    if (longSentence.startsWith(preSentence ? preSentence + ' ' : '') && longSentence.endsWith(postSentence ? ' ' + postSentence : '')) return true;
  }

  return false;
}
