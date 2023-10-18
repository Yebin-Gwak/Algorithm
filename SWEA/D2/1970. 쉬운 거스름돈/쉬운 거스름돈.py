T = int(input())
money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

for test_case in range(1, T + 1):
    N = int(input())
    answer = []
    for i in money:
        answer.append(N//i)
        N %= i
    print(f'#{test_case}')
    for i in answer:
        print(i, end=' ')
    print()