for test_case in range(1, 11):
    N = int(input())
    arr = list(map(int, input().split()))
    count = 0

    for i in range(len(arr)):
        if arr[i] == 0:
            continue
        else:
            height = arr[i]
            left1 = arr[i-1]
            left2 = arr[i-2]
            right1 = arr[i+1]
            right2 = arr[i+2]
            if height > left1 and height > left2 and height > right1 and height > right2:
                count += height - max(left1, left2, right1, right2)

    print(f'#{test_case} {count}')
