T = int(input())

for test_case in range(1, T+1):
    N, M = map(int, input().split())
    arr = [[0]*N for _ in range(N)]

    size = M*M
    max = 0

    for i in range(N):
        arr[i] = list(map(int, input().split()))

    for i in range(N-M+1):
        h = i
        for j in range(N-M+1):
            value = 0
            w = j
            for k in range(M):
                for l in range(M):
                    value += arr[h + k][w + l]
            if value > max:
                max = value

    print('#'+str(test_case), max)