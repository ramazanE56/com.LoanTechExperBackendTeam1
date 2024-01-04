
  Feature: US_20 In the "Transactions" table, find the sum of the "amount" values according to the "remark"
                 type and verify the ones higher than $1000.
@yts
    Scenario: TC_01 In the "Transactions" table, find the sum of the "amount" values according to the "remark"
               type and verify the ones higher than $1000.

      * The query is prepared and executed to the transactions table.
      * The resultSet returned from the transactions table is validated.