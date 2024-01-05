Feature: DB_004 : In the "Deposits" table in the database, verify the "charge" value of the data with
                  "trx=4GC9SMZUS69S" among the data with "amount" value below $500,000.
  @db
Scenario: TC_01 : In the "Deposits" table in the database, verify the "charge" value of the data with
                  "trx=4GC9SMZUS69S" among the data with "amount" value below $500,000.


  * The query is prepared and executed to the deposits table.
  * The resultSet returned from the deposits table is validated.


