import sys
input = sys.stdin.readline

for test in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    answer = 0
    for i in range(n - 1):
        a, b = arr[i], arr[i + 1]
        if a > b:
            a, b = b, a
        while 2 * a < b:
            answer += 1
            b /= 2
    print(answer)