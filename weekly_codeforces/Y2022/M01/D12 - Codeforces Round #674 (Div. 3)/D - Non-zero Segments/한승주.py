import sys
input = sys.stdin.readline

n = int(input())
a = list(map(int, input().split()))
segments = {0}
cnt, s = 0, 0
for i in range(n):
    s += a[i]
    if s in segments:
        cnt += 1
        segments = {0}
        s = a[i]
    segments.add(s)
print(cnt)
