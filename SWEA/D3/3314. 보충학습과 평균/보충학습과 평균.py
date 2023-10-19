T = int(input())

for test_case in range(1, T+1):
    arr = list(map(int, input().split()))
    for i in range(len(arr)):
        if arr[i] < 40:
            arr[i] = 40

    avg = int(sum(arr)/5)
    print(f'#{test_case} {avg}')