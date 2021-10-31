import sys
input = sys.stdin.readline

for test in range(int(input())):
    n, m, x = map(int, input().split())
    row, col = (x - 1) % n, (x - 1) // n
    answer = row * m + col + 1
    print(answer)