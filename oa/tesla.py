# you can write to stdout for debugging purposes, e.g.
# print("this is a debug message")

def solution(S, C):
    # write your code in Python 3.8.10
    if len(S) <= 1:
        return 0
    res = 0
    sum = C[0]
    c = S[0]
    m = C[0]
    for i in range(1, len(S)):
        if S[i] == c:
            sum += C[i]
            m = max(m, C[i])
        elif sum != C[i - 1]:
            sum -= m
            res += sum
            sum = C[i]
            m = 0
        else:
            sum = C[i]
            m = 0
        c = S[i]
    if sum != C[len(S) - 1]:
        sum -= m
        res += sum
    
    return res