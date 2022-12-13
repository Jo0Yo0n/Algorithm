A, B, C = map(int, input().split())
price = 0
if A == B == C:
    price = 10000 + A * 1000
elif A == B:
    price = 1000 + A * 100
elif B == C:
    price = 1000 + B * 100
elif C == A:
    price = 1000 + C * 100
else:
    maxDice = A
    if maxDice < B:
        maxDice = B
    if maxDice < C: # elif가 아닌 if여야 함. 안그러면 B를 최대라고 여기는 문제 발생
        maxDice = C
    price = maxDice * 100

print(price)
