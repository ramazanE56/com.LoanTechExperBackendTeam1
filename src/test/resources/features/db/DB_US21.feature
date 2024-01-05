Feature:DB_US21:Verify the number of users with "is_read=1" and "user_id = 1" in the "admin_notifications" table.
  @db
  Scenario: TC_01:Verify the number of users with "is_read=1" and "user_id = 1" in the "admin_notifications" table.

    * The query is prepared and executed to the admin_notifications table.
    * The resultSet returned from the admin_notifications table is validated