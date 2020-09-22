# Predictive_text_project
In this exercise, I designed and developed a predictive text system. For simplicity, I assumed that the user does not need punctuation or numerals. I also limited my solutions to producing only lower-case words.
I first implement a prototype and design a simple dictionary. I then implement searching and storing. The method signatureToWords finds the possible words that could correspond to a given signature and returns them as a set.
I read and store the dictionary in memory as a list of pairs. As the list will be sorted and in memory, a faster look-up technique can be used.
I then further improve the system by using a Map data structure. I finally create another improved implementation of the Dictionary interface using my own tree data structure. This allows the words or parts of words that match partial signatures, so that the users will be able to see the parts of the words they want to use as they type.
