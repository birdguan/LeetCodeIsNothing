# @param chars string字符串一维数组
# @return string字符串
#

import difflib

class Solution:
    def commonChars(self, chars):
        result, temp = [], set(chars[0])
        for i in temp:
            result += min(char.count(i) for char in chars) * i
        return ''.join(result)


if __name__ == '__main__':
    solution = Solution()
    chars = ["bella", "label", "roller"]
    # chars = ["where", "whereis", "iswhoand you e", "doublle odoosiuiqasidufoewnoij"]
    res = solution.commonChars(chars)
    print(res)
