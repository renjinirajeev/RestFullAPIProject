Feature: user update the booking

  Scenario: verify user can update the booking
    Given user wants to call "/booking" endpoint
    And set header "Content-Type" to "application/json"
    And set body request from the file "createbooking.json"
    Then user perform post call
    Then verify status is 200
    And verify the bookingId is not null
    When user stores booking id to "booking.id"
    And user wants to call "/auth" endpoint
    And set header "Content-Type" to "application/json"
    And set body request from the file "createToken.json"
    Then user perform post call
    Then verify status is 200
    When user stores token value to "api.token"
    And user wants to call "/booking/@id" endpoint
    And set header "Content-Type" to "application/json"
    And set header "Cookie" to "token=@token"
    And set body request from the file "update.json"
    Then user perform put call
    Then verify status is 200


