# OpenChat kata

**Change to the `openchat-springboot` branch for the Spring Boot version of the kata.**

This exercise was created by Sandro Mancuso for the excellent video series about 
[Outside-in TDD](https://cleancoders.com/video-details/comparativeDesign-episode-1). 

The original source is at https://github.com/sandromancuso/cleancoders_openchat

This version was modified for Spring Boot, and also to make it easier to start for learners.

## Instructions

We are about to implement the backend for an online chat application, similar to Twitter.

The APIs are described in the APIs.md document, and also in the integration tests.

The integration tests are all disabled, save one, and that one is failing!

We are aiming for a standard Spring Boot backend design, with

 - A _controller_ for every API
 - A _command_ object for every request, and a corresponding _response_ object
 - A _service_ for every API
 - A set of _domain objects_ that represent domain concepts (e.g., `User`)
 - A _repository_ that hides persistency issues (can be implemented with a simple Map in memory)

Your job is to:

 1. Read through the integration tests to understand what we're trying to achieve. 
 2. Run all integration tests, and verify that the one integration test is failing; 
    observe the error and understand why we are getting that error.
 3. Examine the unit tests; one unit test has been provided to make it easier and faster to start
 4. Run the unit tests; verify that the test is failing, and understand why it is failing
 5. Change the production code to make the unit test pass
 6. Create a unit test for the RegisterNewUserService, and then make it pass
 7. Create a unit test for the UsersRepository, and then make it pass.  It's OK to implement it 
    with a simple Map in memory.
 8. Run the integration tests again; fix any remaining integration errors to make it pass.



## How to

**Run unit tests**

> ./gradlew test

**Run integration tests**

> ./gradlew integrationTest
 
**Start the application**

> ./gradlew bootRun
 

