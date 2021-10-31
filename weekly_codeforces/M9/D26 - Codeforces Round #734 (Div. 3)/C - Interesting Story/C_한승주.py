import sys
input = sys.stdin.readline
from itertools import combinations


def check(n):
    for string_set in combinations(strings, n):
        cnt = {chr(i): 0 for i in range(97,102)}
        max_cnt = 0
        sum_count = 0
        for string in string_set:
            sum_count += len(string)
            for char in string:
                cnt[char] += 1
                max_cnt = max(max_cnt, cnt[char])
        if max_cnt * 2 > sum_count:
            return True
    return False


for test in range(int(input())):
    n = int(input())
    strings = [input().rstrip() for _ in range(n)]
    left = 0
    right = n
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        if check(mid):
            left = mid + 1
            answer = mid
        else:
            right = mid - 1
    print(answer)
