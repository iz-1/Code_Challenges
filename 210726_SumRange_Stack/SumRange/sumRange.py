# Problem 1: Find the Contiguous Subarray with Sum to a Given Value in an array.

# Given an array of positive integer and given value X, find Contiguous sub array whose sum is equal to X.
# For example:

# 1
# 2
# 3
# 4
# 5
# 6
# arr[]={14, 12, 70, 15, 99, 65, 21, 90};
# X =97.
# Sum found between index 1 to 3
# Elements are 12, *70 and 15

arr = [14, 12, 70, 15, 99, 65, 21, 90]
X = 97

#assume range exists
def rangeSum(values, answer): 
    nValues = len(values)+1 # check sum(start:end) inclusive
    for i in range(0, nValues): # main loop
        for j in range(i+1, nValues): # range sum
            s = sum(values[i:j])
            #print(f'i:{i} j:{j} sum:{s}')
            if(s == answer):
                return values[i:j]
            elif(s > answer):
                break

result = rangeSum(arr, X)
print(result)