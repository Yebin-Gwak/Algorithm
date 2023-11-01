from collections import deque


def dfs(v):
    ans_dfs.append(v)
    visited[v] = 1

    for i in graph[v]:
        if visited[i] == 0:
            dfs(i)


def bfs(v):
    queue = deque()

    queue.append(v)
    ans_bfs.append(v)
    visited[v] = 1

    while queue:
        b = queue.popleft()
        for n in graph[b]:
            if visited[n] == 0:
                queue.append(n)
                ans_bfs.append(n)
                visited[n] = 1


N, M, V = map(int, input().split())
graph = [[] for _ in range(N+1)]

for i in range(M):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in range(1, N+1):
    graph[i].sort()

visited = [0] * (N+1)
ans_dfs = []

dfs(V)

visited = [0] * (N+1)
ans_bfs = []

bfs(V)

print(*ans_dfs)
print(*ans_bfs)
