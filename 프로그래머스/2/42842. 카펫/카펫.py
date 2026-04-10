def solution(brown, yellow):
    width_plus_height = (brown // 2) - 2
    
    for i in range(1, (width_plus_height // 2) + 1):
        h = i
        w = width_plus_height - h
        if h * w == yellow:
            return (w + 2, h + 2)
    
    
# y가로*2 + y세로*2 + 4 = b
# 2(가로 + 세로 + 2) = b