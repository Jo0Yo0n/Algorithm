def solution(array, commands):
    answer = []
    for command in commands:
        start, end, seq = command
        silced_list = array[start - 1:end]
        silced_list.sort()
        answer.append(silced_list[seq - 1])
        
    return answer