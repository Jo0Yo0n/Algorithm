class MyQueue:

    def __init__(self):
        self.lst1 = []
        self.lst2 = []
        

    def push(self, x: int) -> None:
        self.lst1.append(x)

    def pop(self) -> int:
        if not self.lst2:
            while self.lst1:
                self.lst2.append(self.lst1.pop())

        return self.lst2.pop()
        

    def peek(self) -> int:
        if not self.lst2:
            while self.lst1:
                self.lst2.append(self.lst1.pop())
        
        return self.lst2[-1]

    def empty(self) -> bool:
        if not self.lst1 and not self.lst2:
            return True
        else:
            return False
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()