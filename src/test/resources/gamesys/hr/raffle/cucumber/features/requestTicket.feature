Feature: Validate ticket requests 

As a client of the Raffles API
  I want to run tests
  In order to validate 'Request Ticket' operations
  
	Scenario: Request ticket using id
		
		Given a url for requesting ticket using player id and raffle id "http://localhost:8080/ticket-api/ticket-requests"	
   		When I make the rest call using player id and raffle id
		"""
		    {
				"playerId":	123,
				"raffleId":12
			}
		"""
		Then status code for the player and raffle id "http://localhost:8080/ticket-api/ticket-requests" should be 400
		Then response for the player and raffle id should contain: 
		"""    
		    {
				"reason":"Raffle not found"
			}
    	"""