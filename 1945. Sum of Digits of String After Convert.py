class Solution:
    def getLucky(self, s: str, k: int) -> int:
        str1 = ""
        for i in s:
            str1+=str((ord(i)-ord('a'))+1)
        while k != 0:
            count = 0
            for i in str1:
                count+=int(i)
            str1 = str(count)
            k-=1
        return int(str1) 
