"""
满二叉树的逆时针打印
"""
import math

if __name__ == '__main__':
    n = int(input())
    data = list(map(int, input().strip().split(" ")))
    index = 1
    out = []
    while index - 1 < n:
        out.append(data[index - 1])
        index = index * 2
    index = index // 2
    while index < n:
        out.append(data[index])
        index += 1
    index = index // 2
    while index < 2 ** int(math.log2(n)) - 1:
        out.append(data[index])
        index += 1
    index = 2 ** (int(math.log2(n)) - 1)
    while index - 2 > 0:
        out.append(data[index-2])
        index = index // 2
    print(" ".join(map(str, out)))
