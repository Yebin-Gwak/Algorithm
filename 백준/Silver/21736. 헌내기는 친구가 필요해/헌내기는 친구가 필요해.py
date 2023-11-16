from collections import deque

def bfs(x, y):
    global result
    lst = deque()
    lst.append([x, y])
    v[x][y] = True

    while lst:
        cx, cy = lst.popleft()

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx <= N-1 and 0 <= ny <= M-1:
                if v[nx][ny] == False and arr[nx][ny] != 'X':
                    if arr[nx][ny] == 'P':
                        result += 1
                    v[nx][ny] = True
                    lst.append([nx, ny])



N, M = map(int, input().split())

arr = [list(input()) for _ in range(N)]
v = [[False] * M for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
startX, startY = 0, 0
result = 0
for i in range(N):
    if 'I' in arr[i]:
        startX = i
        startY = arr[i].index('I')
        break

bfs(startX, startY)
if result == 0:
    print('TT')
else:
    print(result)