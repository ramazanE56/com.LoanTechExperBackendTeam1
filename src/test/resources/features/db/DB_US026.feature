Feature: DB_US026:Calculate the "total_delay_charge" for loans with "loan_id=1" by grouping them according to the "loan_id" value.
  @db
  Scenario: TC01: Calculate the "total_delay_charge" for loans with "loan_id=1" by grouping them according to the "loan_id" value.

    * I calculate the total_delay_charge for the loan
    * the total_delay_charge should be '0.0'