def solution(phone_book):
    phone_set = set()
    phone_len = set()
    
    for e in phone_book:
        phone_set.add(e)
        phone_len.add(len(e))
    
    for e in phone_len:
        for p in phone_book:
            if len(p) < e:
                continue
            if len(p) != e and p[:e] in phone_set:
                return False
            
    return True