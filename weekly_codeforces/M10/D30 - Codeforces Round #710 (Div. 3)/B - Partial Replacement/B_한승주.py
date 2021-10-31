import sys
input = sys.stdin.readline


def dfs(cur_node, cnt):
    global min_cnt
    visited[cur_node] = cnt
    if cur_node >= end:
        min_cnt = min(min_cnt, cnt)
        return
    if cnt > min_cnt:
        return
    for next_node in range(cur_node + k, cur_node, -1):
        if 0 <= next_node < n and s[next_node] == '*' and visited[next_node] > cnt + 1:
            
            dfs(next_node, cnt + 1)

for test in range(int(input())):
    n, k = map(int, input().split())
    s = input().strip()
    visited = [float('inf')] * n
    for i in range(n):
        if s[i] == '*':
            start = i
            break
    for j in range(n - 1, -1, -1):
        if s[j] == '*':
            end = j
            break
    min_cnt = float('inf')
    dfs(start, 0)
    print(min_cnt +1)