# Cryptography
A simple java program that contains most classic ciphers like (Caecer cipher/ Rail fance cipher/ playfair cipher/ vigenere cipher)
# Caecer cipher
In Caeser code Caeser cipher depends on ASCII table to shift the order of the characters as it will shift the letters, numbers, symbols, and spaces.
# Railfance cipher
In Railfance code, Railfance cipher working on plaintext with spaces to calculate the ciphertext. That code will create a matrix with rows equal to number of letters(including spaces) and columns equal to number of key. Then it will enter the plaintext in the matrix diagonally. Finally it will take letters row by row to produce the ciphertext.
# Playfair cipher
In playfair code, playfair cipher working on plaintext without spaces to calculate the ciphertext. It working by creating a 5x5 matrix that starts with the keyword letters then the remaining alphabits (Note: the letter "I" and letter "J" considered as one letter that put in one cell and the cipher algorithm decide which letter to choose depending on the programmer). In that code we always choose letter "I" to be appear in produced text. When the plaintext's letters was in odd number, the encryption algorithm will add "X" and the decryption algorithm will add "Q".
# Vigenere cipher
In vigenere code, vigenere cipher working on plaintext wihtout spaces to calculate the cipher. That cipher working like Caeser cipher but each letter in PT/CT will be shifted depending on the number of keyword-letter's order.
# Notes
Each cipher has its decryption algorithm which is the inverse of encryption algorithm
To run the code you must run the MainProg file that will execute a simple GUI frame to choose the cipher you want. Then you will enter the PT/CT in the first field and the key in the second one then choose the operation you want (encryption/decryption). Finally click on the calculate button to get the CT/PT
