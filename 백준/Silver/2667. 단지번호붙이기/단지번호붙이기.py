from collections import deque

def bfs(x, y):
    global result
    lst = deque()
    count = 0

    lst.append([x, y])
    v[x][y] = True
    arr[x][y] = 0
    count += 1

    while lst:
        cx, cy = lst.popleft()
        for k in range(4):
            nx = cx + dx[k]
            ny = cy + dy[k]
            if 0<= nx <= N-1 and 0<= ny <= N-1:
                if arr[nx][ny] == 1 and v[nx][ny] == False:
                    v[nx][ny] = True
                    lst.append([nx, ny])
                    arr[nx][ny] = 0
                    count += 1
    result.append(count)



N = int(input())
arr = [[0] * N for _ in range(N)]
v = [[False] * N for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


for i in range(N):
    arr[i] = list(map(int, input()))

result = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            bfs(i,j)

result.sort()
print(len(result))
for i in result:
    print(i)