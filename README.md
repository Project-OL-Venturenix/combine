# Welcome to HK Java MasterCode (Jan 2024)

---

## Question 1: 

You are given a 0-indexed 2D integer array `brackets` where brackets[i] = [ $upper_i$, $percent_i$ ] means that the i^th^ tax bracket has an upper bound of $upper_i$ and is taxed at a rate of $percent_i$. The brackets are sorted by upper bound (i.e. `upper i-1` < `upper i` for `0 < i < brackets.length`).

- Tax is calculated as follows:
  - The first `upper0` dollars earned are taxed at a rate of `percent0`.
  - The next `upper1 - upper0` dollars earned are taxed at a rate of `percent1`.
  - The next `upper2 - upper1` dollars earned are taxed at a rate of `percent2`.
  - And so on.

You are given an integer `income` representing the amount of money you earned. Return the amount of money that you have to pay in taxes. Answers within `10-5` of the actual answer will be accepted.

#### Example 1:

- **Input:** brackets = [  [ 3,50 ],[ 7,10 ],[ 12,25 ]  ], income = 10
- **Output:** 2.65000
- **Explanation:**

Based on your income, you have 3 dollars in the 1st tax bracket, 4 dollars in the 2nd tax bracket, and 3 dollars in the 3rd tax bracket. The tax rate for the three tax brackets is 50%, 10%, and 25%, respectively. In total, you pay `$3 * 50% + $4 * 10% + $3 * 25% = $2.65` in taxes.

#### Example 2:

- ****Input:**** brackets = [  [ 1,0 ],[ 4,25 ],[ 5,50 ]  ], income = 2
- **Output**: 0.25000
- ****Explanation:****
- Based on your income, you have 1 dollar in the 1st tax bracket and 1 dollar in the 2nd tax bracket.
- The tax rate for the two tax brackets is 0% and 25%, respectively.
- In total, you pay `$1 * 0% + $1 * 25% = $0.25` in taxes.

#### Example 3:
- ****Input:**** brackets = [ [ 2,50 ] ], income = 0
- ****Output:**** 0.00000
- ****Explanation:**** You have no income to tax, so you have to pay a total of `$0` in taxes.
 
#### Constraints:
- 1 <= brackets.length <= 100
- 1 <= upperi <= 1000
- 0 <= percenti <= 100
- 0 <= income <= 1000
- upperi is sorted in ascending order.
- All the values of upperi are unique.
- The upper bound of the last tax bracket is greater than or equal to income.

---

## Question 2:
Given three integer arrays `nums1`, `nums2`, and `nums3`, return a distinct array containing all the values that are present in at least two out of the three arrays. You may return the values in any order.

#### Example 1:
- **Input:** nums1 = [ 1,1,3,2 ], nums2 = [ 2,3 ], nums3 = [ 3 ]
- **Output:** [ 3,2 ]
- **Explanation:** The values that are present in at least two arrays are:
  - 3, in all three arrays.
  - 2, in nums1 and nums2.

#### Example 2:
- **Input:** nums1 = [ 3,1 ], nums2 = [ 2,3 ], nums3 = [ 1,2 ]
- **Output:** [ 2,3,1 ]
- **Explanation:** The values that are present in at least two arrays are:
  - 2, in nums2 and nums3.
  - 3, in nums1 and nums2.
  - 1, in nums1 and nums3.

#### Example 3:
- **Input:** nums1 = [ 1,2,2 ], nums2 = [ 4,3,3 ], nums3 = [ 5 ]
- **Output:** [   ]
- **Explanation:** No value is present in at least two arrays.
 
#### Constraints:
- `1 <= nums1.length, nums2.length, nums3.length <= 100`
- `1 <= nums1[i], nums2[j], nums3[k] <= 100`

---

## Question 3:
A **substring** is a contiguous (non-empty) sequence of characters within a string.

A **vowel substring** is a substring that **only** consists of vowels (`'a'`, `'e'`, `'i'`, `'o'`, and `'u'`) and has all five vowels present in it.

Given a string `word`, return the number of **vowel substrings** in word.

#### Example 1:
- **Input:** word = "aeiouu"
- **Output:** 2
- **Explanation:** The vowel substrings of word are as follows:
  - **aeiou**u
  - **aeiouu**

#### Example 2:
- **Input:** word = "unicornarihan"
- **Output:** 0
- **Explanation:** Not all 5 vowels are present, so there are no vowel substrings.

#### Example 3:
- **Input:** word = "cuaieuouac"
- **Output:** 7
- **Explanation:** The vowel substrings of word are as follows:
  - **uaieuo**
  - **uaieuou**
  - **uaieuoua**
  - **aieuo**
  - **aieuou**
  - **aieuoua**
  - **ieuoua**

#### Constraints:
- 1 <= word.length <= 100
- word consists of lowercase English letters only.

---

#### Scoring System: Completion Time + Time Complexity
- Completion Time (All 3 Questions)
  - Less than 30 mins (+9)
  - Less than 45 mins (+6)
  - Less than 60 mins (+3)
- Time Complexity (Code will be submitted for verification by staff members)
  - Question 1:
    - Beat 100% (+5)
    - Beat > 50% (+3)
  - Question 2:
    - Beat 100% (+3)
    - Beat > 50% (+2)
  - Question 3:
    - Beat 100% (+3)
    - Beat > 50% (+1)