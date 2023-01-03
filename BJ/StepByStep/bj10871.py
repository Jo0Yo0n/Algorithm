N, X = map(int, input().split())
A = []
result = []

# 배열 입력
A = list(map(int, input().split()))

for i in range(N):
    if A[i] < X:
        result.append(A[i])

for i in range(len(result)):
    print(result[i], end=' ')
