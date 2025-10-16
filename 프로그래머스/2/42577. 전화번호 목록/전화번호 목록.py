def solution(phone_book):
    phone_set = set(phone_book)
    
    for pn in phone_book:
        for i in range(1, len(pn)):
            if pn[:i] in phone_set:
                return False
    
    return True