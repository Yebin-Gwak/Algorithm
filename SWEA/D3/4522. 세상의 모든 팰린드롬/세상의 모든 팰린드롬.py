T = int(input())

for test_case in range(1, T+1):
    word = input()
    half = len(word) // 2
    result = 'Exist'
    for i in range(half):
        if word[i] == '?' or word[-1-i] == '?':
            continue
        if word[i] != word[-1-i]:
            result = 'Not exist'
            break

    print(f'#{test_case} {result}')