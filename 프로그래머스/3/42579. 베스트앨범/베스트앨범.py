from collections import defaultdict

def solution(genres, plays):
    genre_count_dict = defaultdict(int)
    genre_list_dict = defaultdict(list)
    
    for i in range(len(genres)):
        genre_count_dict[genres[i]] += plays[i]
        genre_list_dict[genres[i]].append((plays[i], i))
        
    genre_count_list = list(genre_count_dict.items())
    genre_count_list.sort(key=lambda x: -x[1])
    for genre_list in genre_list_dict.values():
        genre_list.sort(key=lambda x: (-x[0], x[1]))
    
    answer = []
    
    for genre, _ in genre_count_list:
        for i in range(2 if len(genre_list_dict[genre]) >= 2 else 1):
            answer.append(genre_list_dict[genre][i][1])
            
    return answer