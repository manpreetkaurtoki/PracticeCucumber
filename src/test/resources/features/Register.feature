@smoke
Feature:
Register Testcase

Scenario Outline:
Verify user is able to enter register fields

Given user is on register page
When user enter required fields "<FirstName>" "<LastName>" "<City>" "<PostalCode>" "<Email>" "<Phone>"
Then print all entered fields 

Examples:
|   FirstName 	| LastName |  City   	| PostalCode |   Email       |   Phone    |
| 	John		| George   | Brampton 	| L6X903	 | John@gmail.com| 6475362934 |
| 	Mary		| George   | Brampton 	| L6X903	 | Mary@gmail.com| 6474362935 |
| 	Rose		| William  | Mississauga| L6X403	 | Rose@gmail.com| 9055387634 |
| 	Elizabeth	| Arden    | Toronto 	| M9W2H4	 | arden@gmail.com| 437536294 |
| 	Nat			| Katty    | Caledon 	| M9V3e4	 | Katty@gmail.com| 9053629341|