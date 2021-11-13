import sys
input = sys.stdin.readline

for test in range(int(input())):
    n, m, k = map(int, input().split())
    if n&1 == k&1 and m>1:
        if n&1 == 1 and n*m//2 - k <= n:
            print('NO')
            continue
        print('YES')
        continue
    print('NO')