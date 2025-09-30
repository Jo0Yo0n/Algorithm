# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        return self.find(1, n)
    
    def find(self, low, high):
        while low < high:
            middle = (high + low) // 2
            if not isBadVersion(middle):
                low = middle + 1
                if isBadVersion(middle + 1):
                    return middle + 1
            else:
                high = middle - 1

        return low if isBadVersion(low) else low + 1