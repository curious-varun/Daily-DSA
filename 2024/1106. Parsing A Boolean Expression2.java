class Solution:
    def parseBoolExpr(self, s):
        st = [[]]
        for ch in s:
            if ch == '&':
                st.append([all])
            elif ch == '|':
                st.append([any])
            elif ch == '!':
                st.append([lambda q: not q[0]])
            elif ch == 't':
                st[-1].append(True)
            elif ch == 'f':
                st[-1].append(False)
            elif ch == ')':
                stt = st.pop()
                val = stt[0](stt[1:])
                st[-1].append(val)
            
        return st[0][0]
