def solution(sizes):
    sizes = [(w, h) if w > h else (h, w) for (w, h) in sizes]
    width_list = [w for (w, _) in sizes]
    height_list = [h for (_, h) in sizes]
    
    return max(width_list) * max(height_list)
    