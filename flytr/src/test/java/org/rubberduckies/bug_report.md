# Bugs

1. Null Flight Transfer Lists
	- Description: When there are only direct flight results, the transfer flight results come back as null.
	There is no check for null results before iterating over them.
	- Test Case: testFlightSearchDirect, testFlightSearchToInvalidLocation, 
	testFlightSearchInvalidDepartureTime, testFlightSearchInvalidArrivalTime, 
	- Location of Error: BookingController class, searchFlight method

2. Flight Search Null Departure Location
	- Description: The search method is unable to compare a null object.
	- Test Case: testFlightSearchFromNull
	- Location of Error: BookingController class, searchFlight method

3. Flight Search Null Arrival Location
	- Description: The search method is unable to compare a null object.
	- Test Case: testFlightSearchToNull
	- Location of Error: BookingController class, searchFlight method

4. Flight Search Null Departure Time
	- Description: The search method is unable to get the day of year from a null object.
	- Test Case: testFlightSearchDepartureTimeNull
	- Location of Error: BookingController class, searchFlight method

5. Flight Search Null Arrival Time
	- Description: The search method is unable to get the day of year from a null object.
	- Test Case: testFlightSearchArrivalTimeNull
	- Location of Error: BookingController class, searchFlight method

6. UserController Returns Incorrect User when Logging In
    - Description: The login() method for the UserController returns the incorrect user occasionally when multiple users share the same password.
    - Test Case: loginValidUserSamePassword
    - Location of Error: UserController, login() method
