T = int(input())

for test_case in range(1, T+1):
    S = input()
    arr = set(S)
    result = 'Yes'

    if len(arr) != 2:
        result = 'No'
    else:
        for i in arr:
            if S.count(i) != 2:
                result = 'No'

    print(f'#{test_case} {result}')
