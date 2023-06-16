# Solution of Programming Challenge of BCXP
**Classes:** 
- _Country_ and _Weather_ as data containers
- _CsvReader_ to read data from CSV files 
- _DataParser_ to transform data input into usable Country or Weather objects
- _App_ contains the entry point
 
**Unit Tests** are under _AppTest_.

This solution uses the OpenCSV library to read the given CSV files. OpenCSV provides the basic functions for reading and writing CSV files and has an easy-to-use interface. Also considered was Apache Commons CSV. For this small solution, both libraries are suitable. In case of an extensions of the solution, the decision should be weighed again.
