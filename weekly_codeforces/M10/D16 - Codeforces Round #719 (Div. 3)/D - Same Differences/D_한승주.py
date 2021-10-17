import sys
input = sys.stdin.readline
from collections import defaultdict

for test in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    new_arr = defaultdict(int)
    for idx, num in enumerate(arr):
        new_arr[num - idx] += 1
    answer = 0
    for num in new_arr:
        k = new_arr[num] 
        answer += k * (k - 1) // 2
    print(answer)
