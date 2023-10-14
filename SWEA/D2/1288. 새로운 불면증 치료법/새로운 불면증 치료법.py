T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    now = N
    arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    count = 1

    while True:
        word = list(map(str, str(now)))

        for i in word:
            if int(i) in arr:
                arr.remove(int(i))
        if not arr:
            break
        else:
            count += 1
            now = N * count

    print('#'+str(test_case), str(count*N))
