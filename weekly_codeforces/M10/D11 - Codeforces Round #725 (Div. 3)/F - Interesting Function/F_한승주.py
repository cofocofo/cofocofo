import sys
input = sys.stdin.readline

for test in range(int(input())):
    l, r = map(int, input().split())
    answer = 0
    while r or l:
        answer += r - l
        r //= 10
        l //= 10
    print(answer)
