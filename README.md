#graph #bst #binarytreesearch

# Aim
Starting from a collection of books, we want to implement a tool that allows us to simplify the search for books by genre; in addition to characterizing the behavior of users while performing said searches.
Each book is made up of a title, an author, a number of pages and a set of genres, which describe the content of the book. Examples of these genres are art, science, police, among others.

# Stage 1. Search by genre.
In this first stage we want to implement the necessary logic to obtain a collection of books that contains a particular genre, entered by the user.
The tool will begin by storing the entire collection of books in memory and then filtering by a given genre, presenting the user with the resulting collection of books.
To optimize the search process, it is necessary to implement an index by genre, which will simplify access to only a subset of all existing books.
Input: The program will take an input .csv file
Output: The program should generate a .csv file with the titles of the books that meet the given genre.

# Stage 2. Search statistics.
In this last stage of the work we want to carry out an analysis of the use of the search engine by users; punctually the relationship between the genres entered in the different searches. It is assumed that the tool allows you to enter a set of categories to search, with which the resulting collection of books will contain only the books that meet all the categories entered.
Several .csv files will be provided as input to the program with the successive genres that were entered in different searches carried out. From this information we want to build a graph, where:  
● Each vertex represents a genre that was included in some search; and  
● An arc that connects two vertices will indicate the number of times that after searching for the first gender immediately afterwards, the second gender was searched.  
Using this graph as a structure, the following services must be implemented:  
● Get the N most searched genres after searching for genre A.  
● From a genre To find, in polynomial time, the sequence of genres that has the highest search value. We are going to define the search value of a sequence as the sum of the arcs that compose it.  
● Obtain the graph only with the genera related to a genus A; That is to say, starting from genre A, a closed link was achieved between one or more genres that allowed us to return to the starting genre.  
