# Datastore

The data for Flytr will be stored in a collection of JSON files.
Each User and Booking (Flights/Hotels/etc.) will be stored in their
own individual files following the model given below.

An X represents a single numerical digit (0-9).

Flight Schema:

```json
{
    "id": "flight_<UUID>",
    "airport": "Example International Airport",
    "from": "City, State",
    "to": "City, State",
    "departure": "YYYY-MM-DDTHH:MM:SS"
    "arrival": "YYYY-MM-DDTHH:MM:SS"
    "seats": [
        [ true, true, true, true ],
        [ true, true, true, true ],
        [ true, true, true, true ],
        [ true, true, true, true ]
    ],
    "allowsDogs": true
}
```

Hotel Data Schema:

```json
{
    "id": "hotel_<UUID>",
    "name": "Motel *",
    "location": "City, State",
}
```

Hotel Room Schema:

```json
{
    "number": "001",
    "capacity": 4,
    "takenDates": ["YYYY-MM-DDTHH:MM:SS"]
}
```

User Data Schema:

```json
{
    "id": "userdata_<UUID>" 
    "username": "examplerusername",
    "firstName": "John",
    "lastName": "Smith",
    "birthDate": "YYYY-MM-DDTHH:MM:SS",
    "phone": "555-555-5555",
    "email": "jsmith@example.com"
    "passport": "<passport_id>",
    "address": "123 Example St., GitHub, WA 00000",
    "linkedAccounts": ["<userdata_id>"],
    "frequentFlyer": true,
}
```

User Preferences Schema:

```json
{
    "nickname": "sohnjhith",
    "sortKeys": ["<SORTKEY_ENUM>"],
    "filterKeys": ["<FILTERKEY_ENUM>"]
}
```

Dog Schema:

```json
{
    "name": "Kali",
    "breed": "Black Labrodor Mix",
    "weight": 20
}
```

History Booking Receipt Schema:

```json
{
    "id": "receipt_<UUID>",
    "booking": "<booking_id",
    "bookedAt": "YYYY-MM-DDTHH:MM:SS",
    "users": ["John Smith", "Jane Smith"]
}
```

Each JSON file will be located it it's corresponding directory:

```text
database/
├──userdata/
│  ├──username1/
│  │  ├──data.json
│  │  ├──preferences.json
│  │  ├──saved_people.json
│  │  ├──dogs.json
│  │  └──history/
│  │     ├──receipt_<booking_UUID>.json
│  │     └──...
│  └──...
└──bookings/
   ├──flights/
   │  ├──<flight_id>.json
   │  └──...
   ├──hotels/
   │  ├──<hotel_id>/
   │  │  ├──data.json
   │  │  └──rooms/
   │  │     ├──001.json
   │  │     └──...
   │  └──...
   └──...
```

## General Information

We have chosen to separate each booking item and user into their
own file because of the overhead and complexity involved in updating
objects if they were all contained in a single file. This way, instead
of reading a possibly large JSON file into memory, changing some number
of lines, and writing it all back to the file, only a small object file
will need to be overwritten.

Properties in these schemas such as departure, arrival, birthDate, and other
with a set string of "YYYY-MM-DDTHH:MM:SS" represent Java LocalDateTimes.
This format is simple to both parse into memory and write to a file.

As Flytr evolves and later versions are released, these JSON schemas
may have additional properties added on or some properties changed.

## User Schemas

Users will have their own separate directory named with their username and
password which will contain files for their data, preferences, saved people,
and dogs. Saved people refers to people that a user may commonly book with
but either do not have their own account or are not linked to the user's
account. Users will also a subdirectory for their history of bookings.

## Booking Schemas

The Flight schema contains a seats property which is a 2D-array of booleans
representing seats on a flight. True represents an available seat and false
is a taken seat.

Hotels will be separated into separate directories labled with their id
and will contain a data JSON file as well as a subdirectory of JSON files
representing the rooms of the hotel.
