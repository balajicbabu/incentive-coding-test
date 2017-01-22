Feature: Test player registration

As a client of the Raffles API
  I want to run tests
  In order to validate 'Register Player' operations
  
	Scenario: Register the player

		Given a url for registering player "http://localhost:8080/players"
		When I make the rest call using player data
		"""
		    {
			"name":	"Player1",
			"email":"player@domain.com",
			"dob":"10/12/1990"
			}
		""" 
		Then status code for the valid player data "http://localhost:8080/players" should be 200
		Then response for the valid player data should contain: 
			"""    
		    {
				"id":	2,
				"name":	"Player1",
				"email":"player@domain.com",
				"dob":	"10/12/1990"
			}
    		"""
    		
	Scenario: Register the player by invalid email id
		When I make the rest call using invalid email id
		"""
		    {
			"name":	"Player2",
			"email":"player_domain.com",
			"dob":"10/12/1990"
			}
		""" 
		Then status code for the invalid player email id "http://localhost:8080/players" should be 400
		Then response for the invalid player email id should contain: 
			"""
			{
				"reason":"Wrong email format"
			}    
    		"""
    
	Scenario: Register the player by invalid dob
		When I make the rest call using invalid dob
		"""
		   {
			"name":	"player1",
			"email":"player@domain.com",
			"dob":	"02/02/2012"
		   }
		""" 
		Then status code for the invalid player dob "http://localhost:8080/players" should be 400
		Then response for the invalid player dob should contain: 
		"""    
		   {
			"reason":"Invalid birth date. Player needs to be at least 18."
		   }
    	"""