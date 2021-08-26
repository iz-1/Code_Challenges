// Weekly Coding Challenge: Word Bucket

// Write a function that divides a phrase into word buckets, with each bucket containing n or fewer characters. 
//Only include full words inside each bucket.

// Examples
// bucketize("she sells sea shells by the sea", 10)
// ➞ ["she sells", "sea shells", "by the sea"]

// bucketize("the mouse jumped over the cheese", 7)
// ➞ ["the", "mouse", "jumped", "over", "the", "cheese"]

// bucketize("fairy dust coated the air", 20)
// ➞ ["fairy dust coated", "the air"]

// bucketize("a b c d e", 2)
// ➞ ["a", "b", "c", "d", "e"]

// Notes
// Spaces count as one character.
// Trim beginning and end spaces for each word bucket (see final example).
// If buckets are too small to hold a single word, return an empty array: []
// The final goal isn't to return just the words with a length equal (or lower) to the given n, but to return the entire given phrase bucketized (if possible). 
// So, for the specific case of "by" the only word with a proper length, the phrase can't be bucketized, and the returned array has to be empty.

const DEBUG = false

function debug(str){
    if(DEBUG)
        console.log(str)
}

// assume phrase is trimmed at start/end
function bucketize(phrase, len) {
    let buckets = []

    // method-1, split string tokenize by space then build buckets with strings that fit the length criteria

    // method-2, loop phrase until limit or space is found then add to bucket

    let bucketStartIndex = 0
    let bucketEndIndex = 0
    
    // outer loop over spaces
    let spaceIndex = phrase.indexOf(' ', 0)
    let bucketSize = 0
    while(spaceIndex > -1) {
        debug(spaceIndex)

        bucketSize = spaceIndex - bucketStartIndex
        // wait for overflow to determine word(s) in bucket
        if(bucketSize == len) {
            let words = phrase.substring(bucketStartIndex, spaceIndex)
            debug(`adding1 ${words}`)            
            buckets.push(words)
            bucketStartIndex = spaceIndex = bucketEndIndex + 1
        } else if(bucketSize > len) {
            if(bucketEndIndex - bucketStartIndex <= len) {
                let words = phrase.substring(bucketStartIndex, bucketEndIndex)
                debug(`space ${spaceIndex} adding2 ${words}`)
                buckets.push(words)
            }
            bucketStartIndex = spaceIndex = bucketEndIndex + 1
        } else {
            bucketEndIndex = spaceIndex
        }

        spaceIndex = phrase.indexOf(' ', spaceIndex+1)
    }
    
    // add last bucket(s)
    let remaining = phrase.substring(bucketStartIndex, phrase.length)

    if( remaining.length > 0 && remaining.length <= len) {
        buckets.push(phrase.substring(bucketStartIndex, phrase.length))
    }else{
        for(word of remaining.split(' ')) {
            buckets.push(word)
        }
    }

    return buckets
}

let result = null
result = bucketize("she sells sea shells by the sea", 10)
console.log(result)
// ➞ ["she sells", "sea shells", "by the sea"]

// const str = "the mouse jumped over the cheese"
// console.log(str.substring(25))
result = bucketize("the mouse jumped over the cheese", 7)
console.log(result)
// ➞ ["the", "mouse", "jumped", "over", "the", "cheese"]

result = bucketize("fairy dust coated the air", 20)
console.log(result)
// ➞ ["fairy dust coated", "the air"]

result = bucketize("a b c d e", 2)
console.log(result)
// ➞ ["a", "b", "c", "d", "e"]

