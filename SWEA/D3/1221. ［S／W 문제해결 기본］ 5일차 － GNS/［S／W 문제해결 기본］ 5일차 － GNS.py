numbers = ['ZRO', 'ONE', 'TWO', 'THR', 'FOR', 'FIV', 'SIX', 'SVN', 'EGT', 'NIN']

T = int(input())

for test_case in range(1, T+1):

    n, m = input().split()
    dic = {}
    data = list(input().split())
    count = []

    for i in numbers:
        count.append(data.count(i))

    print(n)
    for i in range(10):
        for j in range(count[i]):
            print(numbers[i], end=' ')
    print()
