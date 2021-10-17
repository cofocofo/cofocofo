import sys
input = sys.stdin.readline

for test in range(int(input())):
    n = int(input())
    arr = list(input().rstrip()) + ['.']
    dp = [[0, 0] for _ in range(n + 1)]
    
    last_sheep = -1
    cnt = 0
    for i in range(n + 1):
        if arr[i] == '*':
            last_sheep = i
            cnt += 1
        else:
            if last_sheep != -1:
                dp[i][0] = cnt * (i - last_sheep)

    last_sheep = -1
    cnt = 0
    for i in range(n, -1, -1):
        if arr[i] == '*':
            last_sheep = i
            cnt += 1
        else:
            if last_sheep != -1:
                dp[i][1] = (last_sheep - i) * cnt

    answer = 0
    min_value = float('inf')
    for i in range(n + 1):
        if dp[i][0] and dp[i][1]:
            min_value = min(min_value, dp[i][0] + dp[i + 1][1], dp[i][1] + dp[i - 1][0])
        elif not dp[i][0] and not dp[i][1] and min_value != float('inf'):
            answer += min_value
            min_value = float('inf')
    print(answer)

