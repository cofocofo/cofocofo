import sys
input = sys.stdin.readline
from bisect import bisect_left, bisect_right

for test in range(int(input())):
    n, l, r = map(int, input().split())
    arr = sorted(list(map(int, input().split())))
    answer = 0
    for i in range(n - 1):
        if arr[i] + arr[n - 1] < l:
            continue
        # 범위를 만족하는 최소 j와 최대 j를 이분탐색으로 찾아야함.
        left = max(i + 1, bisect_left(arr, l - arr[i]))
        right = max(i + 1, bisect_right(arr, r - arr[i]))
        answer += right - left
    print(answer)