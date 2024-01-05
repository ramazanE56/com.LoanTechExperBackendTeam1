Feature:US_09 Delete the requested data by entering "loan_number" in the "loans"
  table on the database and verify that it has been deleted.

  @db
  Scenario: TC_01 Delete the requested data by entering "loan_number" in the "loans"
              table on the database and verify that it has been deleted.


    * The query is prepared and executed to the loans table.
    * The resultSet returned from the loans table delete loan number is validated.