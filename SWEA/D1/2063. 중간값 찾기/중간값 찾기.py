T = int(input())

arr = list(map(int, input().split()))
arr.sort()
print(arr[T//2])
