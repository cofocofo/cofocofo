import sys
input = sys.stdin.readline
from heapq import heappop, heappush
from collections import defaultdict


for test in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    cnt = defaultdict(int)
    heap = []
    for idx, num in enumerate(arr):
        heappush(heap, (num, idx + 1))
        cnt[num] += 1
    while heap and cnt[heap[0][0]] != 1:
        heappop(heap)
    if heap:
        print(heap[0][1])
    else:
        print(-1)