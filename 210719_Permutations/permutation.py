from collections import deque

arr = [1, 2, 3, 4]
global count
global isOdd
count = 0    

def rotate(arr):
    res = deque(arr)
    res.rotate(-1)
    return list(res)

def toString(arr, delim):
    return delim.join(map(str,arr))

# logging emojis
# 📕
# 📙
# 📗
# 📘
# 📓
# 📔

def permutation(arr):
    global isOdd, count    
    isOdd = not(len(arr) % 2 == 0)

    def perm(left, right):
        global isOdd, count
        size = len(right)
        #print(f'📗L:{left} R:{right}')             
        if( (isOdd and size == 1) or (not isOdd and size == 2)):
            print(toString(left + right,','))
            #print(f' 📙L:{left} R:{right}')
            count += 1
        else:
            #rotR = list(right)
            rotR = right
            for j in range(0, len(rotR)):           
                #append 1 from right
                nL = list(left)
                nL.append(rotR[0])
                nR = list(rotR[1:])            
                #call perm_ again with left+1 + right remining times
                nRotate = len(nR)
                #print(f' 📕Rlen:{nRotate}')
                for i in range(0, nRotate):             
                    #print(f'📗next== L:{nL} R:{nR}')             
                    perm(nL, nR)
                    nR = rotate(nR)    
                rotR = rotate(rotR)

    rotated = arr    
    for i in range(0, len(arr)):
        perm(rotated[:1], rotated[1:])
        rotated = rotate(rotated)
    print(f'perms:{count}')

permutation(arr)