def solution(phone_book):
    dict_phone = set(phone_book)
    
    for phone in phone_book:
        for i in range(1, len(phone)):
            if phone[0:i] in dict_phone:
                return False
            

    return True
            