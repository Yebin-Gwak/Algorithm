T = int(input())

for test_case in range(1, T+1):
    N, M = map(int, input().split())
    elephant = N - M
    unicorn = M - elephant

    print(f'#{test_case} {unicorn} {elephant}')
