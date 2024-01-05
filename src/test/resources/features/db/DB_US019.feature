Feature: DB_US019List all records in the "Users" table with "lastname" in reverse order and "firstname" in reverse order. The first lastname of the list is verified
  @db
  Scenario: TC01: List all records in the "Users" table with "lastname" in reverse order and "firstname" in reverse order. The first lastname of the list is verified


    * Retrieve users in reverse order by lastname and firstname
    * Verify the first lastname in the list
