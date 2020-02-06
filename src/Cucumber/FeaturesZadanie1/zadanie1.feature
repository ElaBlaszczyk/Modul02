Feature: New address

Scenario Outline: New address for the user

 Given User is on the My story page
 When User is going to change address page
 And a keyword <Eliss> is entered in input alias field
 And a keyword <Ela> is entered in input First name field
 And a keyword <Blaszczyk> is entered in input Last name field
 And a keyword <Milimex> is entered in input Company field
 And a keyword <123456> is entered in input Vat number field
 And a keyword <Mickiewicza> is entered in input Address field
 And a keyword <5> is entered in input Address Complement field
 And a keyword <Warszawa> is entered in input City field
 And a keyword <41-100> is entered in Postal Code field
 And a keyword United Kingdom is selected
 And a keyword <666666666> is entered in input Phone field
 And the save button is selected
 And the address changed and checked



  Examples:
   | Eliss | Ela | Blaszczyk | Milimex | 123456 | Mickiewicza | 5 | Warszawa | 41-100 | 666666666 |
   | Eliss | Ela | Blaszczyk | Milimex | 123456 | Mickiewicza | 5 | Warszawa | 41-100 | 666666666 |
   | Eliss | Ela | Blaszczyk | Milimex | 123456 | Korfantego  | 77| Poznan   | 45-200 | 666666666 |
