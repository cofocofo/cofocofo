import sys
input = sys.stdin.readline
from math import sqrt
 
for test in range(int(input())):
    n = int(input())
    answer = float('inf')
    t = sqrt(n)
    for i in range(-5, 6, 1):
        t2 = int(t - i)
        if t2 > n or t2 < 1:
            continue
        answer = min(answer, t2 - 2 + (n + t2 - 1) // t2)
    print(answer)