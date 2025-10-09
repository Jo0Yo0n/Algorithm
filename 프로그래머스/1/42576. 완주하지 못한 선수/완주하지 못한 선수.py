def solution(participant, completion):
    dic = {}
    for p in participant:
        dic[p] = dic.get(p, 0) + 1
    
    for c in completion:
        if dic[c] == 1:
            dic.pop(c)
        else:
            dic[c] -= 1
    
    return list(dic.keys())[0]