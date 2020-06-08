Feature: Create transaction and read balance

Background:
    * url baseUrl
    * def genUUID = function(){ return java.util.UUID.randomUUID() + '' }
    * def userId =  callonce genUUID
    * def transactionRequest = { userId: x, amount: 10 }

Scenario: Create transaction

  * set transactionRequest.userId = userId
  Given path '/transactions'
  And request transactionRequest
  And header Accept = 'application/json'
  When method post
  Then status 200

Scenario: Get balance

  Given path '/balance/' + userId
  And retry until responseStatus == 200
  When method get
  Then status 200
  And match response.amount == 10