for test_case in range(1, 11):
    length = int(input())
    arr = [[] for _ in range(8)]
    for i in range(8):
        arr[i] = input()

    repeat = (8 - length) + 1
    count = 0

    for i in range(8):
        for j in range(repeat):
            word = arr[i][j:j+length]

            palindrome = True
            for k in range(length//2):
                if word[k] != word[-1-k]:
                    palindrome = False
                    break
            if palindrome:
                count += 1

    for i in range(8):
        for j in range(repeat):
            word = ''
            for m in range(j, j + length):
                word += arr[m][i]
            palindrome = True
            for k in range(length//2):
                if word[k] != word[-1-k]:
                    palindrome = False
                    break
            if palindrome:
                count += 1

    print(f'#{test_case} {count}')
