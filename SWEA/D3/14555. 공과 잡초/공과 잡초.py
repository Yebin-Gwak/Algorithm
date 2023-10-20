T = int(input())

for test_case in range(1, T+1):
    word = input()
    count = 0

    for i in range(len(word)):
        if word[i] == '(':
            count += 1
        elif word[i] == ')':
            if word[i-1] == '(':
                continue
            else:
                count += 1

    print(f'#{test_case} {count}')
