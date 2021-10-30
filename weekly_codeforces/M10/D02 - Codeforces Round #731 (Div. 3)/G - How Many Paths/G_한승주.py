import sys
input = sys.stdin.readline


# 1부터 탐색. cycle생기면 cycle에 포함되는 요소 하나 check.
def dfs(cur_node, path):
    if answer[cur_node] < 2:
        answer[cur_node] += 1
    for next_node in graph[cur_node]:
        if path & (1 << next_node):
            cycle.append(next_node)
        else:
            dfs(next_node, path | (1 << next_node))


# cycle요소로부터 갈 수 있는 모든 요소들 -1로 바꿈(infinite기 때문)
def dfs2(cur_node, path):
    if answer[cur_node] == -1:
        return
    answer[cur_node] = -1
    for next_node in graph[cur_node]:
        if not path & (1 << next_node):
            dfs2(next_node, path | (1 << next_node))


for test in range(int(input())):
    input()
    n, m = map(int, input().split())
    cycle = []
    graph = {i: [] for i in range(1, n + 1)}
    answer = [0] * (n+1)
    for _ in range(m):
        a, b = map(int, input().split())
        graph[a] += [b]
    # 못가면 0, 1, 2(경로 1개 초과), -1(경로 사이에 사이클 있으면)
    dfs(1, 1)
    for infinite in cycle:
        dfs2(infinite, (1 << infinite))
    print(*answer[1:])