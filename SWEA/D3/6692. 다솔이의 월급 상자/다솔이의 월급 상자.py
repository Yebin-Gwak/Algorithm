T = int(input())

for test_case in range(1, T+1):

    n = int(input())
    result = []
    for i in range(n):
        x, y = input().split()
        result.append(float(x) * int(y))

    ans = sum(result)

    print(f'#{test_case} {ans:.6f}')
