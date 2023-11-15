N = 10**6
arr = [True] * (N + 1)
arr[0], arr[1] = False, False

for i in range(2, N + 1):
    if arr[i] == True:
        for j in range(i * 2, N + 1, i):
            arr[j] = False

T = int(input())

for test_case in range(1, T+1):
    D, A, B = map(int, input().split())
    result = 0
    for i in range(A, B+1):
        if arr[i] == True:
            if str(D) in str(i):
                result += 1

    print(f'#{test_case} {result}')