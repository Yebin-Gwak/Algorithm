T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    word = ''

    for i in range(N):
        alpha, num = input().split()
        word += alpha * int(num)

    print(f'#{test_case}')
    while True:
        if len(word) >= 10:
            print(word[:10])
            word = word[10:]
        else:
            print(word)
            break
