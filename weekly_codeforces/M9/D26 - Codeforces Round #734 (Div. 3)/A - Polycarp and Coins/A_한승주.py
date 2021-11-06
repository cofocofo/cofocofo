import sys
input = sys.stdin.readline

for test in range(int(input())):
    n = int(input())
    # c1 + 2*c2 = n, abs(c1-c2)가 최소
    c1, c2 = n // 3, n // 3
    r = n % 3
    if r == 2:
        c2 += 1
    elif r == 1:
        c1 += 1
    print(c1, c2)
