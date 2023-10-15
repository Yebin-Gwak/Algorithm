T = int(input())
grade = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']

for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    student = [0] * N

    for i in range(N):
        middle, final, hw = map(int, input().split())
        student[i] = middle * 0.35 + final * 0.45 + hw * 0.2

    target_score = student[K - 1]
    student.sort(reverse=True)

    div = N//10

    rank = grade[(student.index(target_score) // div)]

    print('#' + str(test_case), rank)
