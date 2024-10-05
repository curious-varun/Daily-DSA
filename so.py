class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        l = []
        lb, rb, tb, bb = cStart, cStart, rStart, rStart

        while len(l) < rows * cols:
            while cStart < rb + 1:
                if rStart < rows and cStart < cols and rStart >= 0 and cStart >= 0:
                    l.append([rStart, cStart])
                cStart += 1
            rb += 1
            while rStart < bb + 1:
                if rStart < rows and cStart < cols and rStart >= 0 and cStart >= 0:
                    l.append([rStart, cStart])
                rStart += 1
            bb += 1
            while cStart > lb - 1:
                if rStart < rows and cStart < cols and rStart >= 0 and cStart >= 0:
                    l.append([rStart, cStart])
                cStart -= 1
            lb -= 1
            while rStart > tb-1:
                if rStart < rows and cStart < cols and rStart >= 0 and cStart >= 0:
                    l.append([rStart, cStart])
                rStart -= 1
            tb -= 1
        return l
