def dfs(index, now, cnt):
    global result

    if index == N:
        if now == S and cnt > 0:
            result += 1
        return

    dfs(index + 1, now+arr[index], cnt+1)
    dfs(index + 1, now, cnt)

N, S = map(int, input().split())
arr = list(map(int, input().split()))
result = 0
dfs(0, 0, 0)

print(result)