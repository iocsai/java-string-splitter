# java-string-splitter
Java challenge from sololearn.com

Generate a string (at least 10 characters long) of random digits(0-9) and letters(A-Z).
Then split it equally in half.
If the string's length is odd, take the middle character and do the following ways:
If it's a digit in the lower half (0-4), put it on the left split string. 
Otherwise, put it on the right half. 
Do the same thing if it's a letter. 
Lower half: (A-M) Upper half: (N-Z)
Continue on splitting the strings until every string only has 1 character.

    Sample:  "AC2Z34NKOP" 
    Output:  "AC2Z34NKOP" 
             "AC2Z3", "4NKOP" 
             "AC2", "Z3", "4NK", "OP" 
             "AC", "2", "Z", "3", "4", "NK", "O", "P" 
             "A", "C", "2","Z", "3", "4", "N", "K", "O", "P"

Built-in split functions are not allowed.

## Built with

 - Java SE JDK 1.8
 - NetBeans IDE 9.0
