N = int(input())

arr = [[0] * (N+1)] + [[0] + list(map(int, input().split())) for _ in range(N)]
dp = [[0] * (N+1)] + [[0] * (N+1) for _ in range(N)]
dp[1][1] = 1

for i in range(1, N+1):
    for j in range(1, N+1):
        if dp[i][j] > 0 and arr[i][j] > 0:
            jump = arr[i][j]
            if i + jump <= N: #아래로 점프 가능한 경우
                dp[i + jump][j] += dp[i][j]

            if j + arr[i][j] <= N: #옆으로 점프 가능한 경우
                dp[i][j + jump] += dp[i][j]

print(dp[N][N])
