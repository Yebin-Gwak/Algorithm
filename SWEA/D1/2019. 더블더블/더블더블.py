N = int(input())
answer = []

for i in range(N+1):
    answer.append(2**i)

for i in answer:
    print(i, end=' ')