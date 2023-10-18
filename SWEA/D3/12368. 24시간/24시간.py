T = int(input())

for test_case in range(1, T + 1):
    A, B = map(int, input().split())
    answer = A + B
    if answer > 23:
        answer -= 24

    print(f'#{test_case} {answer}')
