
Feature:DB_US29: Delete a data according to the "id=?" value in the update_logs table and verify that it has been deleted
@db
  Scenario: TC01: Delete a data according to the "id=?" value in the update_logs table and verify that it has been deleted


    * The query is prepared and executed to the update_logs table
    * Verify that update_logsid is deleted



