import sys
input = sys.stdin.readline
from collections import defaultdict

for test in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    cnt = 0
    primes = defaultdict(int)
    # 소인수분해 하기위한 코드
    for i in range(n):
        tmp = a[i]
        for j in range(2, tmp + 1):
            if tmp == 1:
                break
            if not tmp % j:
                while not tmp % j:
                    tmp //= j
                primes[j] += 1
    print(primes)
    # 가장 많이나온.. 그런데 이렇게 풀면안되고 각 위치마다 인수분해해서 순회하며 중복 제거해줘야 할듯싶네요.
    max_cnt = 0
    for prime in primes:
        if not primes[prime] == n and max_cnt < primes[prime]:
            max_cnt = primes[prime]
    print(max_cnt)