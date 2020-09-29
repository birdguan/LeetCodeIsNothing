"""
"abcd","abcde"
"""

#
#
# @param str1 string字符串 原始的字符串
# @param str2 string字符串 转换的字符串
# @return string字符串
#


class Solution:
    def find_diff_char(self, str1, str2):
        str1 = str1.strip()
        str2 = str2.strip()
        len1 = len(str1)
        len2 = len(str2)
        if len1 > len2:
            str1, str2 = str2, str1
        for ch in str2:
            if ch not in str1:
                return ch
        # write code here


if __name__ == '__main__':
    solution = Solution()
    str1, str2 = list(input().strip().split(","))
    ch = solution.find_diff_char(str1, str2)
    print(ch)
