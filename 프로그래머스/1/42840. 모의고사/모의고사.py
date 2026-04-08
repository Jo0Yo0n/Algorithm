import math

def solution(answers):
    user1 = [1, 2, 3, 4, 5]
    user2 = [2, 1, 2, 3, 2, 4, 2, 5]
    user3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    user1_count = 0
    user2_count = 0
    user3_count = 0
    
    for idx, answer in enumerate(answers):
        if user1[idx % len(user1)] == answer:
            user1_count += 1
        if user2[idx % len(user2)] == answer:
            user2_count += 1
        if user3[idx % len(user3)] == answer:
            user3_count += 1
            
    count_list = [user1_count, user2_count, user3_count]
            
    return [idx + 1 for idx, c in enumerate(count_list) if c == max(count_list)]
    
    