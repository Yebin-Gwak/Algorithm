T = int(input())

for test_case in range(1, T + 1):
    L, U, X = map(int, input().split())
    answer = 0

    if X < L:
        answer = L-X
    elif L <= X <= U:
        answer = 0
    elif X > U:
        answer = -1

    print(f'#{test_case} {answer}')
    