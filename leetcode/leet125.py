def isPalindrome(self, s: str) -> bool:
    strs = []
    for char in s:
        if char.isalnum():  # 영문자, 숫자 여부 판별
            strs.append(char.lower())

    # 팰린드롬 여부 판별
    while len(strs) > 1:
        if strs.pop(0) != strs.pop():
            print('false')
            return False
    print('true')
    return True
