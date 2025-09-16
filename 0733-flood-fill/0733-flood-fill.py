class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        start_color = image[sr][sc]
        if start_color == color:
            return image

        dr = [-1, 0, 1, 0]
        dc = [0, 1, 0, -1]
        row_size = len(image)
        col_size = len(image[0])
        q = deque([(sr, sc)])
        
        while q:
            r, c = q.popleft()
            image[r][c] = color

            for i in range(4):
                ar = r + dr[i]
                ac = c + dc[i]
                if ar < 0 or ar >= row_size or ac < 0 or ac >= col_size:
                    continue
                if image[ar][ac] != start_color or image[ar][ac] == color:
                    continue
                q.append((ar, ac))

        return image
