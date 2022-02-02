import sys
input = sys.stdin.readline


for test in range(int(input())):
    n, m = map(int, input().split())
    answer = 0
    for _ in range(n):
        a, b = map(int, input().split())
        c, d = map(int, input().split())
        if b == c:
            answer = 1
    if m & 1:
        answer = 0
    print("YES" if answer else "NO")

