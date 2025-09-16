import queue

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        start_color = image[sr][sc]
        if start_color == color:
            return image

        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]
        row_size = len(image)
        col_size = len(image[0])
        q = queue.Queue()
        q.put((sr, sc))
        
        while q.qsize() > 0:
            cx, cy = q.get()
            image[cx][cy] = color

            for i in range(4):
                ax = cx + dx[i]
                ay = cy + dy[i]
                if ax < 0 or ax >= row_size or ay < 0 or ay >= col_size:
                    continue
                if image[ax][ay] != start_color or image[ax][ay] == color:
                    continue
                q.put((ax, ay))

        return image
