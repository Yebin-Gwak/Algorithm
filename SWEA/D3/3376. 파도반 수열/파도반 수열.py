T = int(input())

arr = [0] * 101
arr[1], arr[2], arr[3] = 1, 1, 1
for i in range(4, 101):
    arr[i] = arr[i-3] + arr[i-2]

for test_case in range(1, T+1):
    N = int(input())

    print(f'#{test_case} {arr[N]}')