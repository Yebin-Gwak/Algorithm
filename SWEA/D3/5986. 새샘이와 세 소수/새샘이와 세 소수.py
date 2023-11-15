N = 999
arr = [True] * (N+1)
arr[0], arr[1] = False, False
prime = []
for i in range(2, N+1):
    if arr[i] == True:
        prime.append(i)
        for j in range(i * 2, N+1, i):
            arr[j] = False


T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    result = 0

    for i in range(len(prime)):
        if prime[i] >= N:
            break
        for j in range(i, len(prime)):
            if prime[i] + prime[j] >= N:
                break
            for k in range(j, len(prime)):
                if prime[i] + prime[j] + prime[k] > N:
                    break
                if prime[i] + prime[j] + prime[k] == N:
                    result += 1

    print(f'#{test_case} {result}')