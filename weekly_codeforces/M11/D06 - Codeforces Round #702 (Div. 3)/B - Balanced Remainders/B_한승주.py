import sys
input = sys.stdin.readline

def check(d):
    pivot = d[0]
    for i in range(1, 3):
        if d[i] != pivot:
            return True
    return False

def move(over, d):
    global answer
    for i in range(3):
        if not over and d[i] > n // 3:
            pivot = d[i] - (n // 3)
            over.append((i, pivot))
            d[i] -= pivot
        elif over and d[i] < n // 3:
            idx, num = over.pop()
            if idx < i:
                dist = num * (i - idx)
            else:
                dist = num * (3 - (idx - i))
            d[i] += num
            answer += dist
            over = []
    if over:
        move(over, d)
    return d

for test in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    count = {0: 0, 1: 0, 2: 0}
    answer = 0
    for num in arr:
        count[num%3] += 1
    while check(count):
        count = move([], count)
    print(answer)