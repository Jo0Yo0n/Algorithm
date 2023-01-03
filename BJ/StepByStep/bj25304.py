total_price = int(input())
N = int(input())
receipt = []
for _ in range(N):
    price, num = map(int, input().split())
    receipt.append([price, num])

cal_price: int = 0
for i in range(N):
    cal_price += receipt[i][0] * receipt[i][1]

if total_price == cal_price:
    print('Yes')
else:
    print('No')
