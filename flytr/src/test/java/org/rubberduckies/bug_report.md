# Bug Report

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

6. Flight Transfer Search From Non-Matching Location
	- Description: The transfer search method returns an empty arraylist instead of null.
		While the method functions, "no results" should be standardized -- either null or empty.
	- Test Case: testFlightTransferSearchFromInvalidLocation
	- Location of Error: BookingController class, transferSearch method

7. Flight Transfer Search Non-Matching Departure Time
	- Description: The transfer search method returns an empty arraylist instead of null.
		While the method functions, "no results" should be standardized -- either null or empty.
	- Test Case: testFlightTransferSearchInvalidDepartureTime
	- Location of Error: BookingController class, transferSearch method

8. Flight Transfer Search Non-Matching Arrival Time
	- Description: The transfer search method results as if arrival time was correct when it was not 
	- Test Case: testFlightTransferSearchInvalidArrivalTime
	- Location of Error: BookingController class, transferSearch method

9. Flight Incomplete Transfer Matching Complete Transfers
	- Description: The isIncompleteTransfer method returns true for complete transfers
	- Test Case: testFlightIncompleteTransferCompletesTransfer
	- Location of Error: BookingController class, isIncompleteTransfer method

10. Flight Incomplete Transfer Departure Location Matching Search Departure Location
	- Description: The isIncompleteTransfer method returns true when the departure location and time match
		the search departure location and time. See (#9) for related issue.
	- Test Case: testFlightIncompleteTransferFromInvalidLocation
	- Location of Error: BookingController class, isIncompleteTransfer method

11. UserController Returns Incorrect User when Logging In
    - Description: The login() method for the UserController returns the incorrect user occasionally when multiple users share the same password.
    - Test Case: loginValidUserSamePassword
    - Location of Error: UserController, login() method
    
12. HotelRoom Returns Invalid ArrayList with Incorrect Dates
    - Description: The getTakenDates() method for the HotelRoom returns an invalid arraylist when the checkIn date comes  before the checkOut date on a calendar.
    - Test Case: testAddTakenDate_InvalidDates
    - Location of Error: HotelRoom, getTakenDates method
