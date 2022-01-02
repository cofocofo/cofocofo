import sys
input = sys.stdin.readline
from heapq import heappop, heappush



for test in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    heap = []
    for idx, num in enumerate(arr):
        heappush(heap, (num, idx))
    total, answer = 0, []
    while heap:
        num, idx = heappop(heap)
        if total >= num:
            answer.append(idx + 1)
        else:
            answer = [idx + 1]
        total += num
    answer.sort()
    print(len(answer))
    print(*answer)


