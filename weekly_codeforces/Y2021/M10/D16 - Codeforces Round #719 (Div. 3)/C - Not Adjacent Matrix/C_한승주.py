import sys
input = sys.stdin.readline

for test in range(int(input())):
    n = int(input())
    if n == 1:
        print(1)
        continue
    elif n == 2:
        print(-1)
        continue
    matrix = [[1] * n for _ in range(n)]

    k = 1
    for i in range(n):
        for j in range(i, -1, -1):
            matrix[i - j][j] = k
            k += 2

    k = 2
    if n&1:
        for i in range(n // 2):
            matrix[n//2 + 1 + i][n//2 - 1 - i] = k
            k += 2
    else:
        for i in range(n // 2):
            matrix[n //2  + i][n//2 - 1 - i] = k
            k += 2


    for i in range(1, n):
        for j in range(n - 1, i - 1, -1):
            matrix[n + i - j - 1][j] = k
            k += 2
    for row in matrix:
        print(*row)

     
