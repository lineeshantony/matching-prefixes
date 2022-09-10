#Matching Prefixes

##Problem Statement
Given a list of string prefixes of variable length, the assignment is to implement a method that takes a string as a parameter,
and returns the longest prefix that matches the input string. A prefix matches if the input string starts with that prefix.
The list of prefixes to match should be taken as configuration by your solution.


##Application

Created the app as a spring-boot maven application. 
When the application starts it will invoke the PrefixInserter to read sample_prefixes.txt file (configurable from application.yml) and preprocess the prefixes to a trie like datastructure to store characters of the prefix for easy search.
The core logic of storing and retrieving the longest prefix can be found in PrefixMatcher.
 - The insert(prefix) method will be used to inserting prefixes from a file when the program begins.
 - The fetchLongestPrefix(inputString) will be use to find the longest matching prefix for the given string.

I have created an api to pass the string that needs to be tested.

#To start and test the application please follow the below steps:
1) Run maven clean install
    >mvn clean install   
2) Spring boot run
    >mvn spring-boot:run
      
3) Open browser and hit the api using the below
    http://localhost:8080/prefixMatcher/{inputString}  
    It will check the longest matching prefix (if any) that matches the inputString in sample_prefixes.txt file in resources folder.   
      
      
    E.g. http://localhost:8080/prefixMatcher/2y3fKTSabc will return 2y3fKTS


4) Also can be tested using testcases. Modify or add new test cases to PrefixMatcherTest
