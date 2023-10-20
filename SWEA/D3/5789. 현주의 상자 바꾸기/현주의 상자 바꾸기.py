T = int(input())

for test_case in range(1, T+1):
    N, Q = map(int, input().split())
    arr = [0 for _ in range(N+1)]
    for i in range(1, Q+1):
        L, R = map(int, input().split())
        for j in range(L, R + 1):
            arr[j] = i

    print(f'#{test_case}', end=' ')
    for i in range(1, len(arr)):
        print(arr[i], end=' ')
    print()
