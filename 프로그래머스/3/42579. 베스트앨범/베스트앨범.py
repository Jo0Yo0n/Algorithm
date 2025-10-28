def solution(genres, plays):
    genre_total_plays = {}
    genre_songs = {}
    
    for i, (g, p) in enumerate(zip(genres, plays)):
        genre_total_plays[g] = genre_total_plays.get(g, 0) + p
        genre_songs.setdefault(g, []).append((p, i))
        
    answer = []
    
    sorted_genre = sorted(genre_total_plays.keys(), key=lambda g: genre_total_plays[g], reverse = True)
    
    for g in sorted_genre:
        sorted_songs = sorted(genre_songs[g], key=lambda x: (-x[0], x[1]))
        
        for s in sorted_songs[:2]:
            answer.append(s[1])
            
    return answer