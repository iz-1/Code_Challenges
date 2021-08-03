// Problem 1: Given two Strings A and B. Find the length of the Longest Common Subsequence (LCS) of the given Strings.
// Input: A = Minneapolis, B = Minnesota.
function lcs(strA, strB){
    let len = 0;
    // check each letter's substring length
    for(let i = 0; i < strA.length; ++i){
        let sChar = strA[i];
        let bIndex = strB.indexOf(sChar);
        if(bIndex < 0)
            continue;

        // check substring length using offset
        let substrLenMax = Math.min(strB.length - bIndex, strA.length - i) - 1;
        let substrLen = 0;
        //console.log(`substrLen: ${substrLenMax} bLen:${strB.length - bIndex} aLen:${strA.length - i}`);        
        for(let j = 0; j < substrLenMax; ++j) {            
            //console.log(`a: ${strA[i+j]} b: ${strB[bIndex+j]}`);
            if(strB[bIndex+j] != strA[i+j]) {
                break;
            }
            if(j > substrLen) {
                substrLen = j;
            }
        }

        if(substrLen + 1 > len)
            len = substrLen + 1;
        //console.log(`length: ${len}`);
    }
    //console.log(`found length: ${len}`);
    return len;
}

let res = lcs('Minneapolis', 'Minnesota');
console.log(res);

// Logical Reasoning:
// 3) This question is based on a certain code language. Understand the logic in the coding and answer the following question.
// If PROCESSOR is coded as D4F3C5C1E1S1S1E3C6, what is the code for QUADRANT?
Q1U1A1D1R1A1N1T1
//letter is product of alpha value multipled by number