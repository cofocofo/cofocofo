import sys
input = sys.stdin.readline

# 결국 벽에서부터 거리가 얼마나 되냐?
for test in range(int(input())):
    input()
    n, k = map(int, input().split())
    a = list(map(lambda x: int(x) - 1, input().split()))
    t = list(map(int, input().split()))
    answer = [float('inf')] * n
    for i in range(k):
        answer[a[i]] = t[i]
    # 왼쪽 벽에서부터 거리가 얼마나 되냐? 나보다 낮은 벽을 만나면 그 벽부터 다시 거리를 재자.
    dp_right = [0] * n
    # 오른쪽 벽
    dp_left = [0] * n
    last = float('inf')
    for i in range(n):
        last = min(last + 1, answer[i])
        dp_right[i] = last
    for i in range(n-1, -1, -1):
        last = min(last + 1, answer[i])
        dp_left[i] = last
    for i in range(n):
        print(min(dp_left[i],dp_right[i]), end=' ')