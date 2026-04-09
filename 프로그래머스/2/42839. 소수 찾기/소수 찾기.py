from itertools import permutations

def solution(numbers):
    possible_nums = []
    
    for i in range(1, len(numbers)+1):
        possible_nums += [int(''.join(x)) for x in permutations(numbers, i)]
    
    possible_nums = list(set(possible_nums))
    
    answer = 0
    for num in possible_nums:
        if num == 0 or num == 1:
            continue
        if num == 2:
            answer += 1
            continue
            
        flag = True
        for i in range(2, num):
            if num % i == 0:
                flag = False
                break
        if(flag):
            answer += 1
    
    return answer
