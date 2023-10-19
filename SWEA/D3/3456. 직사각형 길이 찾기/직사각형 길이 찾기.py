T = int(input())

for test_case in range(1, T+1):
    a, b, c = map(int, input().split())

    if a == b:
        answer = c
    elif a == c:
        answer = b
    else:
        answer = a

    print(f'#{test_case} {answer}')