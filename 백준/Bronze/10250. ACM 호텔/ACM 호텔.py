t = int(input())
for _ in range(t):
    h, w, n = map(int, input().split())
    no = (n // h) + 1
    floor = n % h

    if floor == 0:
        floor = h
        no -= 1
    
    print(f"{floor}{no:02d}")
