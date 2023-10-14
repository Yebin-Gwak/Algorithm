T = int(input())
numbers = [2, 3, 5, 7, 11]

for test_case in range(1, T+1):
    counter = [0] * 5
    N = int(input())

    for i in range(5):
        while True:
            if N % numbers[i] == 0:
                counter[i] += 1
                N = N // numbers[i]
            else:
                break

    print('#'+str(test_case), end=' ')
    for i in counter:
        print(i, end=' ')
    print()

