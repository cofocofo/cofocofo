import sys
input = sys.stdin.readline

for test in range(int(input())):
    n = int(input())
    tmp = n
    k = 0
    while tmp // 10:
        tmp //= 10
        k += 9
    num = str(n)
    k += int(num[0]) - 1
    if num >= num[0] * len(num):
        k += 1
    print(k)

    