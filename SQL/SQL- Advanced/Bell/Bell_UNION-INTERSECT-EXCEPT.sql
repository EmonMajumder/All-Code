/*
Scenario: Bell has multiple product divisions and types of people that are their customers
or employees.
Examples:   Cable customers
            Cell phone customers
            Retailers
            Suppliers
            Bell employees, etc.

If we assume all these different types of data are held in different database systems, we
will NOT have "related" data in the database sense, IE. common values related by foreign-to
primary key relationships.

However, there are situations when you need to use or compare data across multiple NON-RELATED
data sets. This is what Set Operations are for.

Scenario: Bell wants to send a huge email blast to all associated people (customers, employees, 
suppliers, etc.), so they need a consolidated list of unique email addresses.
People can conceivably appear in more than one of the different databases listed above.
Ex. A customer might have both Cable and Cell service with Bell, or a Bell employee might also
be a customer with cable and cell service.

After creating the sample database with the DDL script, examine the test data. The queries below
intended to illustrate the result differences between the set operators UNION, INTERSECT and EXCEPT.
*/

--Review the data in each table
SELECT * FROM BELL_CABLECUSTOMERS;
SELECT * FROM BELL_MOBILITYCUSTOMERS;
SELECT * FROM BELL_EMPLOYEES;

--UNION - Combine two result sets (removes duplicates)
SELECT CustomerName, EmailAddress FROM BELL_CABLECUSTOMERS
UNION
SELECT CustName, Email FROM BELL_MOBILITYCUSTOMERS
UNION
SELECT EmpName, EmpEmail FROM BELL_EMPLOYEES;

--UNION ALL - Combine two result sets (including duplicates)
SELECT CustomerName, EmailAddress FROM BELL_CABLECUSTOMERS
UNION ALL
SELECT CustName, Email FROM BELL_MOBILITYCUSTOMERS
UNION ALL
SELECT EmpName, EmpEmail FROM BELL_EMPLOYEES;

--INTERSECT - The intersection of the result sets, IE. Exists in both sets (matches)
SELECT CustomerName, EmailAddress FROM BELL_CABLECUSTOMERS
INTERSECT
SELECT CustName, Email FROM BELL_MOBILITYCUSTOMERS;

--EXCEPT - Result set of A minus any matches from the result set of B. IE. Does not exist in B (non-matches)
SELECT CustomerName, EmailAddress FROM BELL_CABLECUSTOMERS
EXCEPT
SELECT CustName, Email FROM BELL_MOBILITYCUSTOMERS;S

--Notice that the order of the sets matters, just like in basic subtraction. If we reverse the
--order of the tables, we get different results.
SELECT CustName, Email FROM BELL_MOBILITYCUSTOMERS
EXCEPT
SELECT CustomerName, EmailAddress FROM BELL_CABLECUSTOMERS;