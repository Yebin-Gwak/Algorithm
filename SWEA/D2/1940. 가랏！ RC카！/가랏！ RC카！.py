T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    speed = 0
    meter = 0
    for i in range(N):
        command = list(map(int, input().split()))
        if command[0] == 0:
            meter += speed
        elif command[0] == 1:
            speed += command[1]
            meter += speed
        elif command[0] == 2:
            speed -= command[1]
            if speed <= 0:
                speed = 0
            meter += speed

    print(f'#{test_case} {meter}')
