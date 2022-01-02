import sys
input = sys.stdin.readline
from collections import defaultdict
sys.setrecursionlimit(10**6)

def dfs(cur_node, pre_node):
    visited[cur_node] = 1
    for next_node in graph[cur_node]:
        if next_node == pre_node:
            continue
        if visited[next_node]:
            if visited[next_node] == 1:
                isCycle[next_node] = 2
                isCycle[cur_node] = 1
        else:
            dfs(next_node, cur_node)
        
        if isCycle[next_node] == 1 and isCycle[cur_node] != 2:
            isCycle[cur_node] = 1
    visited[cur_node] = 2


def dfs2(cur_node, pre_node):
    res = 1
    for next_node in graph[cur_node]:
        if next_node == pre_node: continue
        if isCycle[next_node]: continue
        res += dfs2(next_node, cur_node)
    
    return res


# 사이클이 없다면 n(n-1)/2개의 단순 경로(a출발, b도착)이지만
# 사이클이 있기 때문에 (a, b)의 경로가 2개일 수 있다(사이클을 돌고 도착하는)
# 따라서 n(n-1)에서 사이클을 돌지 않는 (a,b)의 갯수를 빼주면 답이다.
# 사이클의 각 정정에서 뻗어나가는 트리(사이클이 없는)의 크기 (s(s-1)/2)를 각각 빼주면 된다.
for test in range(int(input())):
    n = int(input())
    graph = defaultdict(list)
    isCycle = [0] * (n + 1)
    visited = [0] * (n + 1)
    for _ in range(n):
        u, v = map(int , input().split())
        graph[u] += [v]
        graph[v] += [u]

    answer = n * (n - 1)
    dfs(1, 0)
    for i in range(1, n + 1):
        if isCycle[i]:
            res = dfs2(i, 0)
            answer -= res * (res - 1) // 2
    
    print(answer)