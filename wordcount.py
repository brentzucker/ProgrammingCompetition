#Write a program which reads a filename from the user and opens that file an reads its contents.  You may assume the file is a text file.  Count the number of times each word appears in the text file.  Count words that differ only in case as the same word.  Ignore punctuation (don't count "both" and "both." as different words).
#
#After counting all words in the file, print out the word count for each word you saw.  You should sort your printout such that the most common word appears first, second-most-common word appears second, etc.  You may break ties arbitrarily.
#
#Example input:
#poem.txt
#
#(contents of poem.txt):
#Two roads diverged in a yellow wood,
#And sorry I could not travel both
#And be one traveler, long I stood
#And looked down one as far as I could
#To where it bent in the undergrowth;
#
#Output (I think this is right for the example above, but use it for format rather than correctness):
#and 3
#i 3
#(etc)

#get user file name
filename = raw_input()

infile = file(filename, 'r')

word_list = []
word_map = {}

line = infile.readline()
while line != "" :
	#Removes the special characters (punctuation) from the line
	line = line.translate(None, "?.;:,\n")

	#puts the words in all lowercase so they can be counted as the same word
	line = line.lower()

	word_list = line.split()
	
	#add words to dictionary
	for w in word_list :
		if word_map.has_key(w) == False:
			word_map[w] = 1
		else :
			word_map[w] += 1

	line = infile.readline()
infile.close()

#print contents of dictionary in sorted order
for w in sorted(word_map, key=word_map.get, reverse=True):
	print w +" "+ str(word_map[w])