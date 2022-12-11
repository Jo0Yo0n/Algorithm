king, queen, look, bishop, knight, pawn = map(int, input().split())

king = 1 - king
queen = 1 - queen
look = 2 - look
bishop = 2 - bishop
knight = 2 - knight
pawn = 8 - pawn

print(king, queen, look, bishop, knight, pawn)
