import heapq
class Solution:
    def smallestChair(self, times: List[List[int]], targetFriend: int) -> int:
        n = len(times)
        indices = [idx for idx in range(n)]

        indices.sort(key = lambda idx : times[idx][0])

        available_chairs = [chair for chair in range(n)]
        filled_chairs = [] #(l,chair)

        for idx in indices:
            a, l = times[idx]

            while filled_chairs and filled_chairs[0][0] <= a:
                leave, chair = heapq.heappop(filled_chairs)
                heapq.heappush(available_chairs, chair)

            chair = heapq.heappop(available_chairs)

            if idx == targetFriend:
                return chair

            heapq.heappush(filled_chairs,[l,chair])

        
