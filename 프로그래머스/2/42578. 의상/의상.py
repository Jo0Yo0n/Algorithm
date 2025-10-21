def solution(clothes):
    c_dic = {}
    
    for c in clothes:
        c_dic[c[1]] = c_dic.get(c[1], 0) + 1
    
    ans = 1
    for k in c_dic:
        ans *= c_dic[k] + 1
    
    return ans - 1