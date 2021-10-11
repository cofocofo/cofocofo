import sys
input = sys.stdin.readline

for test in range(int(input())):
    n = int(input())
    x = list(map(int, input().split()))
    pivot = x[0]
    y = [0] * n
    # 각 x값에 대해 이전 값에서 1을 check한 pivot(visited배열이라 봐도 무방)
    for i in range(1, n):
        # pivot의 길이만큼만 check
        l = len(bin(pivot)[2:])
        for j in range(l):
            k = (1 << j)
            # pivot에는 1이 있고 x[i]에는 없다면 해당 1을 y[i]에 보정
            if pivot & k and not x[i] & k:
                y[i] += k
        # pivot값 갱신
        pivot = x[i] ^ y[i]
    print(*y)