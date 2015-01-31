This repository is for practice problems for the Progamming Team

We have a programming competition in the end of February. 

Please feel free to commit changes if  you see more efficient or a less complicated way of solving a problem. 

#Problem 1 (wordcount.py, poem.txt)

Write a program which reads a filename from the user and opens that file an reads its contents.  You may assume the file is a text file.  Count the number of times each word appears in the text file.  Count words that differ only in case as the same word.  Ignore punctuation (don't count "both" and "both." as different words).

After counting all words in the file, print out the word count for each word you saw.  You should sort your printout such that the most common word appears first, second-most-common word appears second, etc.  You may break ties arbitrarily.

Example input:
poem.txt

(contents of poem.txt):
Two roads diverged in a yellow wood,
And sorry I could not travel both
And be one traveler, long I stood
And looked down one as far as I could
To where it bent in the undergrowth;

Output (I think this is right for the example above, but use it for format rather than correctness):
and 3
i 3
(etc)

#Problem 2 (marriageproblem.java, StableMarriage.java)
Given input on standard input in the following format, solve the stable marriage problem using the traditional algorithm.
Input format:
You may assume there are an equal number of men and women in the problem.
Input will be:
- List of all proposers ("men"), one name per line, followed by a ":", followed by a comma-separated list of proposal reviewers ("women"), which is that man's ranked preference order for marriage partners, most preferred first.
- List of all women, one name per line, followed by a ":", followed by a comma-separated list of men which is that woman's ranked preference order for marriage partners, most preferred first.
You may assume the names contain only capital letters and spaces.  Example input follows:
Conor Marsden: Charlene Fairbairn, Maelys Renaud, Kerri Varley
Neely Albero: Maelys Renaud, Charlene Fairbairn, Kerri Varley
Murray Balboni: Kerri Varley, Charlene Fairbairn, Maelys Renaud
Charlene Fairbairn: Conor Marsden, Neely Albero, Murray Balboni
Maelys Renaud: Neely Albero, Murray Balboni, Conor Marsden
Kerri Varley: Murray Balboni, Neely Albero, Conor Marsden
Output format: list of pairings that form a solution to the stable marriage problem.  Format is "Man / Woman".
Expected output for example input:
Conor Marsden / Charlene Fairbairn
Neely Albero / Maelys Renaud
Murray Balboni / Kerri Varley

#Problem 3 (ProblematicPublicKeys.java)
Problem 4 from
http://eagle.cs.mercer.edu/MUSpringContest/MUSpring2014.pdf

The Problem
On February 15, 2012, the New York Times reported a flaw in the method
of generating keys for
a public­key encryption system (“Researchers Find a Flaw in a Widely
Used Online Encryption
Method” by John Markoff). A public key is essentially the product of
two unique prime numbers.
Unfortunately, the prime numbers being used for generating keys were
not always unique. This
flaw enables an attacker to determine private keys given a set of
flawed public keys simply by
finding the shared factors.
Your job is to write a program that takes flawed public keys and
determines the corresponding
private keys. For the purposes of this problem, a private key consists
of a pair of prime numbers,
2 < K1
, K2 < 2
31
, and the corresponding public key consists of their product K1
* K2
.
Input
The first line of input consists of a single integer P, (1 ≤ P ≤ 100),
which is the number of data
sets that follow. Each data set consists of two or more lines. The
first line of the data set
contains two integer values, N (1 ≤ N ≤ P) and M (2 ≤ M ≤ 100),
separated by a space. N is the
data set number, and M is the number of data values that follow. The
following ⌈M/5⌉ lines
contain M “public keys,” 5 keys per line (except possibly the last),
each key, ki
(0 ≤ i < M,
5 < ki < 2
31
), the product of exactly 2 prime numbers.
Output
For each data set there are several lines of output. The first line
contains only the data set
number. The following lines contain the prime factors of the input data
values in ascending
numeric order, 5 per line, except for the last line. Output values on
the same line are separated
by a space.

Sample Input
3
1 6
221 391 713 1457 901
299
2 4
13193 18721 31897 18527
3 2
2143650557 2140117121
Sample Output
1
13 17 23 31 47
53
2
79 97 167 191 193
3
32717 65413 65521
