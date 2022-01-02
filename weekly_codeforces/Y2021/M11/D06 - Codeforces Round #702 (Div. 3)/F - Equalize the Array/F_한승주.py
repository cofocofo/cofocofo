import sys
input = sys.stdin.readline
from collections import defaultdict


for test in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    counter = defaultdict(int)
    for num in arr:
        counter[num] += 1
    candidate = set()
    for target in counter.values():
        candidate.add(target)
    answer = float('inf')
    for target in candidate:
        total = 0
        for cnt in counter.values():
            if cnt == target:
                continue
            if target > cnt:
                total += cnt
            else:
                total += cnt - target
            if total >= answer:
                break
        answer = min(answer, total)
    print(answer)