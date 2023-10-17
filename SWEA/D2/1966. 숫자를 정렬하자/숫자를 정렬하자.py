T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    print(f'#{test_case}',end=' ')
    for i in arr:
        print(i, end=' ')
    print()
