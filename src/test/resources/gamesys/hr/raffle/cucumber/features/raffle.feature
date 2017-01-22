Feature: Test the raffle

As a client of the Raffles API
  I want to run tests
  In order to validate 'Create Raffle' operations
  
	Scenario: Create a raffle for one player
		Given a url for testing the raffle "http://localhost:8080/raffles"
		When I make the rest call using raffle data
		  """
		  {
		  "name":"Raffle",
		  "code":"aaabbbcccddd",
		  "numberOfTickets":5
		  }
		  """
		Then status code for creating the raffle "http://localhost:8080/raffles" should be 200
		Then response for creating the raffle should contain: 
			"""
			{
				"id":13,
				"name":"Raffle",
				"code":"aaabbbcccddd",
				"numberOfTickets":5,
				"remainingTickets":5
			}
			"""