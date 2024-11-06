class Solution:
    def makeFancyString(self, s: str) -> str:
        s1=""
        for i in s:
            if len(s1)<2:
                s1+=i
            else:
                if s1[-1]==s1[-2]==i:
                    continue
                else:
                    s1+=i
        return s1
