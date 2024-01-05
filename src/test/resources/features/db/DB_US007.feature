
Feature: DB_US07 :In the "support_tickets" table in the database,
  verify the "subject" information of the data whose "ticket" value starts with 4.
@db
  Scenario: TC01:In the "support_tickets" table in the database, verify the "subject" information of the data whose "ticket" value starts with 4.

    * The query is prepared and executed to the support_tickets table.
    * The resultSet returned from the support_tickets table is validated.