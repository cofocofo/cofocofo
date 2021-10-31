import sys
input = sys.stdin.readline
from heapq import heappush, heappop
from collections import defaultdict

for test in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    min_heap = []
    max_heap = []
    counter = defaultdict(int)
    for num in arr:
        counter[num] += 1
    min_num = float('inf')
    max_num = 0
    for num in counter:
        heappush(min_heap, (counter[num], num))
        heappush(max_heap, (-counter[num], -num))
    while min_heap and max_heap:
        min_count, min_num = heappop(min_heap)
        max_count, max_num = heappop(max_heap)
        print(counter, min_num, max_num)
        while min_heap and min_count != counter[min_num]:
            if counter[min_num]:
                heappush(min_heap, (counter[min_num], min_num))
            min_count, min_num = heappop(min_heap)
        while max_heap and -max_count != counter[-max_num]:
            if counter[-max_num]:
                heappush(max_heap, (-counter[max_num], max_num))
            max_count, max_num = heappop(max_heap)
        if not counter[-max_num] or not counter[min_num] or min_num == -max_num:
            break
        counter[min_num] -= 1
        counter[-max_num] -= 1
        if counter[min_num]:
            heappush(min_heap, (counter[min_num], min_num))
        if counter[-max_num]:
            heappush(max_heap, (-counter[-max_num], max_num))
        while min_heap[0][1] == -max_heap[0][1]:
            heappush(min_heap, heappop(min_heap))
            heappush(max_heap, heappop(max_heap))
            print(min_heap)
            print(max_heap)
    answer = 0
    for num in counter:
        answer += counter[num]
    if answer == -1:
        answer = 1
    print(answer)