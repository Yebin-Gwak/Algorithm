N, answer = map(int, input().split())
numbers = list(map(int, input().split()))

check = 0

for i in range(N-2):
    for j in range(i+1, N-1):
        for k in range(j+1, N):
            if check < (numbers[i] + numbers[j] + numbers[k]) <= answer:
                check = numbers[i] + numbers[j] + numbers[k]
            if check == answer:
                break
        if check == answer:
            break
    if check == answer:
        break

print(check)