def solution(array, commands):
    answer = []
    for start, end, seq in commands:
        silced_and_sorted_list = sorted(array[start - 1:end])
        answer.append(silced_and_sorted_list[seq - 1])
        
    return answer