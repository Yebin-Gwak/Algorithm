from collections import deque

def bfs(x, y, endx, endy):

    lst = deque()
    lst.append([x, y])
    dp[x][y] = 0

    while lst:
        cx, cy = lst.popleft()
        for k in range(4):
            nx = cx + dx[k]
            ny = cy + dy[k]
            if 0 <= nx <= endx and 0 <= ny <= endy:
                if arr[nx][ny] == 1:
                    if dp[nx][ny] == -1:
                        dp[nx][ny] = dp[cx][cy] + 1
                        lst.append([nx, ny])

                    elif dp[nx][ny] > dp[cx][cy] + 1:
                        dp[nx][ny] = dp[cx][cy] + 1
                        lst.append([nx, ny])




N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[-1] * M for _ in range(N)]

firstX, firstY = 0, 0
for i in range(N):
        if 2 in arr[i]:
            firstX = i
            firstY = arr[i].index(2)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

bfs(firstX, firstY, N-1, M-1)
for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            dp[i][j] = 0

for i in range(N):
    print(*dp[i])
