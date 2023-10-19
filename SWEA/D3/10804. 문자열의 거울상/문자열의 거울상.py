T = int(input())

for test_case in range(1, T+1):
    word = input()
    answer = ''
    for i in range(len(word)-1, -1, -1):
        if word[i] == 'b':
            answer += 'd'

        elif word[i] == 'd':
            answer += 'b'

        elif word[i] == 'p':
            answer += 'q'
        else:
            answer += 'p'

    print(f'#{test_case} {answer}')
