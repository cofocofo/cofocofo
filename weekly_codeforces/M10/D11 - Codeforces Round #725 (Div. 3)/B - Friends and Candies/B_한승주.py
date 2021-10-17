import sys
input = sys.stdin.readline

for test in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    avg = sum(arr) / n
    if avg > int(avg):
        print(-1)
        continue
    avg = int(avg)
    answer = 0
    for num in arr:
        if num > avg:
            answer += 1
    print(answer)