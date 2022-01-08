Feature: Adding address

  Scenario Outline: Adding new address in existing account
    Given Web landing page https://mystore-testlab.coderslab.pl opened in browser
    When Click "Sign in"
    And Fill e-mail field with "zadaniezaliczeniowepierwsze@gmail.com"
    And Fill password field with "zadaniezaliczeniowepierwsze"
    And Click "SIGN IN" button
    And Click "ADD FIRST ADDRESS" button or click "ADDRESSES" and then "Create new address" button
    And Fill the form with <alias>, <address>, <city>, <zip/postalcode>, country and <phone>
    And Click "SAVE" button
    And Confirm created address by <alias>, check <address>, <city>, <zip/postalcode>, country and <phone>
    And Click "DELETE" button by <alias>
    Then Address will be deleted and webpage display message: "Address successfully deleted!"

    Examples:
      | alias   |  | address   |  | city     |  | zip/postalcode | |phone|
      | 1       |  | address1  |  | London   |  | 11-111         | |111 111 111|
      | 2       |  | address2  |  | Dublin   |  | 22-222         | |222 222 222|
      | 3       |  | address3  |  | Warszawa |  | 33-333         | |333 333 333|



