def dfs(n):
    global ans

    if n == N:
        ans += 1
        return

    for j in range(N):
        if v1[j] == v2[n+j] == v3[n-j] == False:
            v1[j] = v2[n + j] = v3[n - j] = True
            dfs(n+1)
            v1[j] = v2[n + j] = v3[n - j] = False


T = int(input())

for test_case in range(1, T+1):
    N = int(input())

    #세로, /대각, 반대대각 여부 확인
    v1, v2, v3 = [[False] * (2*N) for _ in range(3)]
    ans = 0

    dfs(0)


    print(f'#{test_case} {ans}')