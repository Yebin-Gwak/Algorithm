T = int(input())

for test_case in range(1, T+1):
    N, K = map(int, input().split())
    arr = [i for i in range(1, N+1)]
    submit = list(map(int, input().split()))
    for i in submit:
        arr.remove(i)
    
    print(f'#{test_case}', end=' ')

    for i in arr:
        print(i, end=' ')

    print()
