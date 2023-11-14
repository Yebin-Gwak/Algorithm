def dfs(index, now):
    global result

    if now > k:
        return

    if index == n:
        if now == k:
            result += 1
        return

    dfs(index + 1, now + arr[index])
    dfs(index + 1, now)


T = int(input())

for test_case in range(1, T+1):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    result = 0

    dfs(0,0)

    print(f'#{test_case} {result}')