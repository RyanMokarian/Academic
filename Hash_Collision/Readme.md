Title: Hash collision study to compare probing algorithms

Category: Data Structure

Author: Ryan Mokarian

Task:
Use the words given above in Q1 to create a hash table of appropriate size to be about 70% full.
The hash conversion is by using the character position in an 26 character alphabet using the folding
method(A-Z, with A having the value 1 and Z having the value 26).
For example the word YOU is converted to the numeric value 25+15+21=61; then 61 is used to map
the key to a slot in the hash table.
Use the following collision resolution schemes presented in class:
Separate Chaining
Linear Probing
Quadratic Probing
Double Hashing
Show for each scheme the hash table and any supplementary structure. For each, give the average number
of probes to search each word in the list.
