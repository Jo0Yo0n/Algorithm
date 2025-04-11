n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
white = 0
blue = 0

def check(x, y, size):
    for i in range(x, x+size):
        for j in range(y, y+size):
            if arr[x][y] != arr[i][j]:
                return False
    return True

def solve(x, y, size):
    global white
    global blue

    if check(x, y, size):
        if arr[x][y] == 0:
            white += 1
        else:
            blue += 1
        return
    
    size //= 2
    for i in range(2):
        for j in range(2):
            solve(x+i*size, y+j*size, size)

solve(0, 0, n)
print(white)
print(blue)