import sys
input = sys.stdin.readline

for test in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    min_p = float('inf')
    max_p = 0
    min_idx = -1
    max_idx = -1
    for i in range(n):
        if arr[i] > max_p:
            max_p = arr[i]
            max_idx = i
        if arr[i] < min_p:
            min_p = arr[i]
            min_idx = i
    answer = 0
    left = 0
    right = n - 1
    if max_idx < min_idx:
        min_idx, max_idx = max_idx, min_idx
    if min_idx + 1 <= right - max_idx + 1:
        answer += min_idx + 1
        left = min_idx + 1
        if max_idx - left + 1 <= right - max_idx + 1:
            answer += max_idx - left + 1
        else:
            answer += right - max_idx + 1
    else:
        answer += right - max_idx + 1
        right = max_idx - 1
        if min_idx - left + 1 <= right - min_idx + 1:
            answer += min_idx - left + 1
        else:
            answer += right - min_idx + 1
    print(answer)