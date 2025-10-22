def solution(genres, plays):
    music_dict = {}
    for i in range(len(genres)):
        music_dict.setdefault(genres[i], []).append([plays[i], i])
    
    music_total_plays = {}
    for genre in music_dict:
        music_dict[genre].sort(key = lambda x: (-x[0], x[1]))
        
        total_sum = 0
        for music in music_dict[genre]:
            total_sum += music[0]
            
        music_total_plays[genre] = total_sum
        
    sorted_genres = sorted(music_total_plays.items(), key = lambda x: x[1], reverse = True)
    
    answer = []
    for genre in sorted_genres:
        for i in range(len(music_dict[genre[0]])):
            answer.append(music_dict[genre[0]][i][1])
            if i == 1:
                break
                
    return answer