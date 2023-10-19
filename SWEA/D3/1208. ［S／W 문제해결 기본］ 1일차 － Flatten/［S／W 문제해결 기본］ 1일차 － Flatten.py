for test_case in range(1, 11):
    dump = int(input())
    arr = list(map(int, input().split()))
    complete = False

    for i in range(dump):
        max_h = max(arr)
        min_h = min(arr)
        if max_h - min_h <= 1:
            break
        else:
            max_index = arr.index(max_h)
            min_index = arr.index(min_h)
            arr[max_index] -= 1
            arr[min_index] += 1

    print(f'#{test_case} {max(arr) - min(arr)}')
