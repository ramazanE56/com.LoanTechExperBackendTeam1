
Feature: DB_US27: Verify the first 3 "names" in the loan_plans table according to the "delay_value" and "fixed_charge or percent_charge" values.

  Scenario: TC01: Verify the first 3 "names" in the loan_plans table according to the "delay_value" and "fixed_charge or percent_charge" values.

    * The query is prepared and executedUpdate to the loan_plans table
    * The resultSet returned from the loan_plans table is validated.