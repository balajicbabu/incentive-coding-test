Feature: Request player information 

As a client of the Raffles API
  I want to run tests
  In order to validate 'Request player information' operations
  
Background: 
    
	Scenario: Get player detail by id
		Given a url for requesting player info "http://localhost:8080/players/"
		When I make the rest call using valid player id "123"
		Then status code for requesting the player detail using valid id should be 200
    	
	Scenario: Get player detail by invalid id
		Given a url for requesting player info "http://localhost:8080/players/"
	    When I make the rest call using invalid player id "nofern"
	    Then status code for requesting the player detail using invalid id should be 400
