// 2696. Minimum String Length After Removing Substrings

function minLength(s: string): number {
  const stack: string[] = [];
  for (let i of s) {
    const prevChar = stack?.[stack.length - 1];
    if ((i == 'B' && prevChar == 'A') || (i == 'D' && prevChar == 'C')) {
      stack.pop();
    } else {
      stack.push(i)
    }
  }
  return stack.length;
};

