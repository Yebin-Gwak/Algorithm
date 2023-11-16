def dfs(cnt, score, cal):
    global result

    if cal > L:
        return

    if cnt == N:

        result = max(score, result)
        return

    dfs(cnt+1, score + taste[cnt-1], cal + kcal[cnt-1])
    dfs(cnt+1, score, cal)



T = int(input())

for test_case in range(1, T+1):
    N, L = map(int, input().split())
    result = 0
    taste = [0] * N
    kcal = [0] * N

    for i in range(N):
        x, y = map(int, input().split())
        taste[i] = x
        kcal[i] = y


    dfs(0, 0, 0)

    print(f'#{test_case} {result}')