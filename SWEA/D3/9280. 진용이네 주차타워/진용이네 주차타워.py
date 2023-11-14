from collections import deque

T = int(input())

for test_case in range(1, T+1):
    n, m = map(int, input().split())
    parked = [0] * n
    pay = [0] * n
    car = [0] * m
    wait = deque()
    result = 0
    for i in range(n):
        pay[i] = int(input())

    for j in range(m):
        car[j] = (int(input()))

    for i in range(m*2):
        order = int(input())

        if order > 0:
            #주차 공간 있는 경우
            if 0 in parked:
                index = parked.index(0)
                parked[index] = order
                result += car[order-1] * pay[index]
            #없는 경우 대기큐 삽입
            else:
                wait.append(order)

        #출차
        else:
            carNum = abs(order)
            index = parked.index(carNum)
            #대기중인 차 있는 경우 출차공간에 주차
            if wait:
                j = wait.popleft()
                parked[index] = j
                result += car[j-1] * pay[index]

            else:
                parked[index] = 0

    print(f'#{test_case} {result}')