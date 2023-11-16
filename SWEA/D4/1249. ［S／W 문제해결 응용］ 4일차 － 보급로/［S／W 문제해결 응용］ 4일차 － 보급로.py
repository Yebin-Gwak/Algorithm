from collections import deque

def bfs(x, y):
    lst = deque()
    lst.append([x, y])
    dp[x][y] = 0

    while lst:
        cx, cy = lst.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx <= N-1 and 0 <= ny <= N-1:
                if dp[nx][ny] == -1:
                    dp[nx][ny] = dp[cx][cy] + arr[nx][ny]
                    lst.append([nx, ny])

                elif dp[nx][ny] > dp[cx][cy] + arr[nx][ny]:
                    dp[nx][ny] = dp[cx][cy] + arr[nx][ny]
                    lst.append([nx, ny])

T = int(input())
for test_case in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input())) for _ in range(N)]
    dp = [[-1] * N for _ in range(N)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]


    bfs(0, 0)

    print(f'#{test_case} {dp[N-1][N-1]}')