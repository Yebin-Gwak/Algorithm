import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
def dfs(point):
    v[point] = True

    for i in arr[point]:
        if v[i] == False:
            dfs(i)



N, M = map(int, input().split())

arr = [[0] for _ in range(N+1)]
v = [False] * (N+1)
for i in range(M):
    x, y = map(int, input().split())
    arr[x].append(y)
    arr[y].append(x)

result = 0

for i in range(1, N+1):
    if v[i] == False:
        dfs(i)
        result += 1

print(result)