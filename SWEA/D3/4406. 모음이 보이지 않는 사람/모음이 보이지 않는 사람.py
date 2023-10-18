T = int(input())
arr = ['a', 'e', 'i', 'o', 'u']

for test_case in range(1, T + 1):
    word = input()
    answer = ''
    for i in range(len(word)):
        if word[i] not in arr:
            answer += word[i]

    print(f'#{test_case} {answer}')
