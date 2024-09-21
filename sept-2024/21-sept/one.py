class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        k=list(range(1,n+1))
        def sor(n):
            n=str(n)
            return n[0:]
        k.sort(key=sor)
        return k
        
