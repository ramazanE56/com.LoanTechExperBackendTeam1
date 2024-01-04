Feature: US_06: As a user, I want to be able to update the user profile information in the system through API connection.

  Scenario: TC_01: When a PATCH request with valid authorization information and correct data (firstname, lastname, address, state, zip, city) is sent to the user/profile endpoint, the returned status code should be 200, and the message in the request body should be verified as "Profile updated successfully"

