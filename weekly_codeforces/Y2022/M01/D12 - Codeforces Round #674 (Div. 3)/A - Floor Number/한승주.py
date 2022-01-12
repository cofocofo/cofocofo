import sys
input = sys.stdin.readline
from math import ceil
 
 
for test in range(int(input())):
    n, x = map(int, input().split())
    answer = ceil((n - 2) / x)  + 1
    if n < 2:
        answer = 1
    print(answer)