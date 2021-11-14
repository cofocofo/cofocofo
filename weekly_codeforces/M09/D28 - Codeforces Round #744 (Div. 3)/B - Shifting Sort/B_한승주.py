import sys
input = sys.stdin.readline

for t in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    # print shifting count
    # print each l, r, d in a line
    # find 1 -> n
    cnt = 0
    commands = []
    for left in range(n):
        target = min(arr[left:])
        for right in range(left, n):
            if arr[right] == target:
                break
        if not left == right:
            cnt += 1
            arr = arr[:left] + arr[right:] + arr[left: right]
            commands.append([left+1, right+1, right - left])
    print(cnt)
    for command in commands:
        print(*command)