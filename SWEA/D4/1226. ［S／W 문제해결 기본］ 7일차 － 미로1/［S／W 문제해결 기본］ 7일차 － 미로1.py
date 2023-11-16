from collections import deque

def bfs(x, y):
    global result

    lst = deque()
    lst.append([x, y])
    v[x][y] = True
    maze[x][y] = 1

    while lst:
        x, y = lst.popleft()
        if result == 1:
            break
        else:
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx >= 1 and nx <=14 and ny >= 1 and ny <= 14:
                    if maze[nx][ny] != 1 and v[nx][ny] not in v:
                        if maze[nx][ny] == 3:
                            result = 1
                        maze[nx][ny] = 1
                        v[nx][ny] = True
                        lst.append([nx, ny])

for test_case in range(1, 11):
    tc = int(input())
    maze = [[0] * 16 for _ in range(16)]
    v = [[False] * 16 for _ in range(16)]

    for i in range(16):
        maze[i] = list(map(int, input()))
    result = 0

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    bfs(1, 1)

    print(f'#{tc} {result}')