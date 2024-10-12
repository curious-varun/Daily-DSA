class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key = lambda x : x[0])
        heap = []
        for x, y in intervals:
            if heap and x > heap[0]:
                heapq.heappop(heap)
            heapq.heappush(heap, y)
        return len(heap)
