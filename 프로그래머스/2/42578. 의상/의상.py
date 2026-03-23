def solution(clothes):
    clothes_dict = {}
    
    for c in clothes:
        clothes_dict[c[1]] = clothes_dict.get(c[1], 0) + 1
        
    ans = 1
    for item in clothes_dict.values():
        ans *= item + 1
        
    return ans - 1