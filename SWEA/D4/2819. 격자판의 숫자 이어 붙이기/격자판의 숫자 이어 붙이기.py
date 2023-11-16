def dfs(x, y, cnt, word):
    global result
    cnt += 1
    word += str(arr[x][y])

    if cnt == 7:
        result.append(word)
        return
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx <= 3 and 0 <= ny <= 3:
            dfs(nx, ny, cnt, word)

T = int(input())
for test_case in range(1, T+1):
    arr = [list(map(int, input().split())) for _ in range(4)]
    result = []
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    for i in range(4):
        for j in range(4):
            dfs(i,j, 0, '')

    result = list(set(result))



    print(f'#{test_case} {len(result)}')