/**
 * @param {string[]} logs
 * @return {number}
 */
var minOperations = function (logs) {
  let answer = 0;

  for (let i of logs) {
    if (i == "../") {
      if (answer > 0) {
        answer -= 1;
      }
    }
    else if (i == "./") {
      continue;
    }
    else {
      answer += 1;
    }
  }

  return answer;
};
