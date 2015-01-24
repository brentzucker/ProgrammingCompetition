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