from collections import deque

def bfs(start):
    global result
    count = 0
    lst = deque()
    lst.append([start,count])
    result.append([start, 0])
    v[start] = True

    while lst:
        now, cnt = lst.popleft()

        for i in arr[now]:
            if v[i] == False:
                v[i] = True
                lst.append([i, cnt+1])
                result.append([i, cnt+1])

for test_case in range(1, 11):
    N, M = map(int, input().split())
    command = list(map(int, input().split()))
    arr = [[] for _ in range(101)]
    v = [False] * 101
    result = []
    for i in range(0, N, 2):
        x, y = command[i], command[i+1]
        arr[x].append(y)

    for i in range(100):
        arr[i] = list(set(arr[i]))

    bfs(M)
    result.sort(key=lambda x:x[0],reverse=True)
    result.sort(key=lambda x:x[1],reverse=True)

    print(f'#{test_case} {result[0][0]}')