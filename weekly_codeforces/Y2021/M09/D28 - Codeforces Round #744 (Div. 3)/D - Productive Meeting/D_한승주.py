import sys
input = sys.stdin.readline
from heapq import heappop, heappush

for t in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    check = {i: False for i in range(1, n + 1)}
    min_heap = []
    max_heap = []
    for i in range(n):
        if arr[i] == 0:
            continue
        heappush(min_heap, [arr[i], i + 1])
        heappush(max_heap, [-arr[i], i + 1])
    answer = 0
    answer_set = []
    while min_heap and max_heap and min_heap[0][1] != max_heap[0][1] and not check[max_heap[0][1]]:
        min_cnt, min_idx = heappop(min_heap)
        max_cnt, max_idx = heappop(max_heap)
        while min_cnt > 0 and max_cnt <= max_heap[0][0]:
            min_cnt -= 1
            max_cnt += 1
            answer += 1
            answer_set.append([min_idx, max_idx])
        
        if max_cnt:
            heappush(max_heap, [max_cnt, max_idx])
        check[min_idx] = True
    print(answer)
    for ans in answer_set:
        print(*ans)
