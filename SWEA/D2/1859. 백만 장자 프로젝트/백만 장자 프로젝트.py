T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    goods = list(map(int, input().split()))

    max_pride = 0
    surplus = 0

    for i in range(N-1, -1, -1):
        if goods[i] > max_pride:
            max_pride = goods[i]
        else:
            surplus += (max_pride - goods[i])

    print(f'#{test_case} {surplus}')
