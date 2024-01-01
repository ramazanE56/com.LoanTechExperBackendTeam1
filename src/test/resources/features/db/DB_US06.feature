Feature: DB_US06: In the "Support_messages" table in the database,
  verify the "support_ticket_id" of the data whose "message" information is "Tickett".
@q01
  Scenario: TC01 :In the "Support_messages" table in the database, verify the
                  "support_ticket_id" of the data whose "message" information is "Tickett".

    * The query is prepared and executed to the Support_messages table.
    * The resultSet returned from the support_messages table is validated.