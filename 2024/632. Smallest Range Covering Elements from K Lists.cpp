#pragma GCC target("avx, mmx, sse2, sse3, sse4")

static const int disableSync = [](void) noexcept -> int
{
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    std::ios::sync_with_stdio(false);
    return 0;
}();

class Solution final
{
private:
    size_t nbLists;
    std::vector<std::pair<int, size_t>> nums;

public:
    std::vector<int> smallestRange(const std::vector<std::vector<int>>& lists) noexcept
    {
        this->nbLists = lists.size();
        this->setFlattenedList(lists);
        return this->slidingWindow();
    }

private:
    inline void setFlattenedList(const std::vector<std::vector<int>>& lists) noexcept
    {
        for (size_t i = 0; i < this->nbLists; ++i)
            for (const int num : lists[i])
                this->nums.push_back(std::make_pair(num, i));
        std::sort(this->nums.begin(), this->nums.end());
    }

    inline std::vector<int> slidingWindow(void) const noexcept
    {
        std::unordered_map<size_t, size_t> counter;
        std::pair<int, int> range = std::make_pair(0, INT_MAX);
        const size_t nbElements = this->nums.size();
        for (size_t iLeft = 0, iRight = 0, nbIncludedLists = 0; iRight < nbElements; ++iRight)
        {
            if (++counter[this->nums[iRight].second] == 1)
                ++nbIncludedLists;
            if (nbIncludedLists != this->nbLists)
                continue;
            while (counter[this->nums[iLeft].second] > 1)
                --counter[this->nums[iLeft++].second];
            if (range.second - range.first > this->nums[iRight].first - this->nums[iLeft].first)
                range = std::make_pair(this->nums[iLeft].first, this->nums[iRight].first);
        }
        return std::vector<int>({range.first, (int)range.second});
    }
};
