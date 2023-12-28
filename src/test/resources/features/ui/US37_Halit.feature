

    Feature: As an Administrator, I want to have a page on the site where I can see active users and manage balance
      transactions.

      Background:  Background: In this step, the registered user reaches the user home page
      by entering his username and password.
        * The administrator goes to the web page with the given "adminUrl".
        * The administrator enters a valid "usernameHalit" in the username box.
        * The administrator enters a valid "passwordAdmin" in the password box.
        * The administrator clicks on the login button.
        * The administrator clicks the manage users button under the Dashboard.

      Scenario: TC_01 The 'Active Users' link should appear and be active under the 'Manage Users'
            link in the Naw bar on the Dashboard page.

        * Verify that the Active Users button is visible and active.

      Scenario: TC_02 When the 'Active Users' link is clicked, the 'Active Users List' and list
      titles should be displayed.

        * The administrator clicks Active Users button
        * Verify that the  Active Users List and list titles appears.


      Scenario: TC_03 To access information about any user selected from the list, the 'Details'
      button must be visible and active. When clicked, it should redirect to the 'User Detail - Username' page.

        * The administrator clicks Active Users button
        * Verify that the Details button is visible and active.
        * The administrator clicks  the Details button.
        * It is verified that the User Details-Username page is opened.

      Scenario: TC_04 On the User Detail page, under the 'Balance' heading, the 'view all' icon should be
      visible and active. When the icon is clicked, it should direct you to the 'Transaction Logs' page.

        * The administrator clicks Active Users button
        * The administrator clicks  the Details button.
        * The administrator clicks View All icon.
        * It is verified that the Transaction Logs page is opened.

      Scenario: TC_05 List and list titles should be displayed on the page that opens.

        * The administrator clicks Active Users button
        * The administrator clicks  the Details button.
        * The administrator clicks View All icon.
        * It is verified that the list and list titles are displayed on the Transaction Logs page.

      @a
      Scenario: TC_06 To search within the list, filter icons must be visible and active.

        * The administrator clicks Active Users button
        * The administrator clicks  the Details button.
        * The administrator clicks View All icon.
        * The TRX Username box appears and confirms that it is active.
        * The Type box appears and confirms that it is active.
        * The Remark box appears and confirms that it is active.
        * The Date box appears and confirms that it is active.
        * The filter icon appears and confirms that it is active.

      @wip
      Scenario: TC_07 The 'Add Balance' Button should be visible and active on the Active Users Page. When
      clicked, it should direct you to the Add Balance page.
        * The administrator clicks Active Users button
        * The administrator clicks  the Details button.
        * The Add Balance button appears and confirms that it is active.
        * The administrator clicks Add Balance button.
        * It is verified that the Add Balance page is opened.

      @wip
      Scenario: TC_08 The Amount and Remark text boxes on the Add Balance page should be visible and
          characters should be entered.

        * The administrator clicks Active Users button
        * The administrator clicks  the Details button.
        * The administrator clicks Add Balance button.
        * Amount text box appears and it is verified that characters can be entered.
        * Remark text box appears and it is verified that characters can be entered.

      Scenario: The 'Submit Button' on the page must be visible and active. When clicked, the text
      '$x added successfully' should be displayed.

        * The administrator clicks Active Users button
        * The administrator clicks  the Details button.
        * The administrator clicks Add Balance button.
        * The amount is entered in the Amount text box.
        * A description is entered in the Remark text box.
        * The Submit button appears and confirms that it is active.
        * The administrator clicks Submit button.
        * It is verified that the text $ 1 added successfully is seen.