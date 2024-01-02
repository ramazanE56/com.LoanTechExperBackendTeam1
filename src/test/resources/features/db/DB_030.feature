@MKR
Feature: US030: Delete a file according to the "support_message_id=?" value in the "support_attachments" table and verify that it has been deleted.

  Scenario: TC01: Delete a file according to the "support_message_id=?" value in the "support_attachments" table and verify that it has been deleted.


    * The query is prepared and executed to the support_attachment table to add new a row.
    * The query is prepared and executed to the support_attachment table.
    * Verify that supportmessageid is deleted.



