def recursion(num, mul):
    if mul == 0:
        return 1
    elif mul == 1:
        return num
    else:
        return recursion(num, mul-1) * num


for test_case in range(10):
    T = int(input())
    N, M = map(int, input().split())
    print(f'#{T} {recursion(N, M)}')
