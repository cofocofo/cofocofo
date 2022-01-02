import sys
input = sys.stdin.readline
 
def sieve(n):
    m = int(n ** 0.5) + 1
    s = [True] * (m)
    for i in range(2, m):
        if s[i] == True:
            for j in range(i + i, m, i):
                s[j] = False
    return [i for i in range(2, m) if s[i] == True]
 
for test in range(int(input())):
    n = int(input())
    primes = sieve(n)
    max_cnt = 0
    max_num = 0
    for prime in primes:
        tmp = n
        cnt = 0
        while not tmp % prime:
            tmp //= prime
            cnt += 1
        if max_cnt < cnt:
            max_cnt = cnt
            max_num = prime
            rest = tmp
        if tmp == 1:
            break
    if max_cnt < 2:
        print(1)
        print(n)
    else:
        print(max_cnt)
        for _ in range(max_cnt - 1):
            print(max_num, end = ' ')
        print(max_num * rest)