import sys
input = sys.stdin.readline
from math import gcd

for test in range(int(input())):
    a, b, k = map(int, input().split())
    if a > b:
        a, b = b, a
    if gcd(a, b) != a and k == 1:
        print('NO')
        continue
    if a == b and k == 1:
        print('NO')
        continue
    max_cnt = 0
    for i in range(2, b + 1):
        while not a % i:
            max_cnt += 1
            a //= i
        while not b % i:
            max_cnt += 1
            b //= i
        if b == 1 and a == 1:
            break
    if k > max_cnt:
        print('NO')
        continue
    print('YES')
    

    
    