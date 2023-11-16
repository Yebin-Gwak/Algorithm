from collections import deque

def bfs(x, y, endx, endy):

    lst = deque()
    lst.append([x, y])
    dp[x][y] = 1

    while lst:
        cx, cy = lst.popleft()
        for k in range(4):
            nx = cx + dx[k]
            ny = cy + dy[k]
            if 0 <= nx <= endx and 0 <= ny <= endy:
                if arr[nx][ny] == 1:
                    if dp[nx][ny] > dp[cx][cy] + 1:
                        dp[nx][ny] = dp[cx][cy] + 1
                        lst.append([nx, ny])




N, M = map(int, input().split())
arr = [list(map(int, input())) for _ in range(N)]
dp = [[10000] * M for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

bfs(0, 0, N-1, M-1)
print(dp[N-1][M-1])
