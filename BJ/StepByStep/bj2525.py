hour, minute = map(int, input().split())
cookingTime = int(input())

minute += cookingTime
while minute >= 60:
    minute -= 60
    hour += 1
    if hour == 24:
        hour = 0

print(hour, minute)
