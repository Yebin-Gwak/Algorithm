T = int(input())

for test_case in range(1, T+1):
    n = int(input())
    arr = list(map(int, input().split()))
    dp = [0] * n
    dp[0] = 1

    for i in range(1, n):
        for j in range(i-1, -1, -1):
            if arr[i] >= arr[j]:
                dp[i] = max(dp[i], dp[j])
        dp[i] += 1

    print(f'#{test_case} {max(dp)}')
