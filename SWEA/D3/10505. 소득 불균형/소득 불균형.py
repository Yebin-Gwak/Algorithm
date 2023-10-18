T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))
    avg = sum(arr) / len(arr)
    count = 0

    for i in arr:
        if i <= avg:
            count += 1
    print(f'#{test_case} {count}')
    