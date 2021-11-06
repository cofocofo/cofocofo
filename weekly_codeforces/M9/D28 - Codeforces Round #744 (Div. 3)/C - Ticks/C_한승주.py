import sys
input = sys.stdin.readline

for t in range(int(input())):
    n, m, k = map(int, input().split())
    matrix = [input().rstrip() for _ in range(n)]
    answer = 'YES'
    for row in range(n - 1, -1, -1):
        if answer =='NO': break
        for col in range(m):
            if matrix[row][col] == '*':
                d = 0
                top = row - 1
                left = col - 1
                right = col + 1
                while 0 <= top and right < m and left >= 0:
                    if matrix[top][left] == '*' and matrix[top][right] == '*':
                        d += 1
                    else:
                        break
                    top -= 1
                    left -= 1
                    right += 1
                if d < k:
                    if row != n - 1:
                        if col != 0:
                            if matrix[row + 1][col - 1] == '*':
                                continue
                        if col != m - 1:
                            if matrix[row + 1][col + 1] == '*':
                                continue
                    answer = 'NO'
                    break
    print(answer)
