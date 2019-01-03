# Airport!

Your task is to model a system for your _favourite_ airport to manage its flights. You should use the tools you have learnt this week ___where appropriate and useful___.

As there are different ways to model this, take some time before you start to plan this out to avoid ending up in a muddle. Remember to ***TDD***!

## MVP

Each plane should have:
* a type (e.g. *BOEING747*) which stores the passenger capacity (**HINT**: _ENUM_!?)
* an airline
* a collection of passengers

Every flight should have:
* a plane
* flight number
* destination

The airport should have:
* a collection of hangars (to store the planes)
* an airport code (e.g. _GLA_)

The airport should be able to:
* create flights
* assign planes from the hangar to flights
* sell tickets for flights

### Extensions
* The airport wants to keep track of how many people have booked onto each flight
* The airport shouldn't sell tickets for a flight if it is fully booked
* Think about how an airport would assign a plane to a flight. It would be wasteful to assign a super big plane for a teeny tiny flight. Make sure your system assigns the most suitable plane for the flight
* Oh diddums! A plane has broken down on the runway and is unable to fly. The airport should have a method to find the _second_ best replacement plane from the hangar

### Advanced Extensions
* Pat is sitting on a plane on the runway but has left his black and white cat in the terminal! Write the most efficient ***algorithm*** you can to find him as quickly as possible before the plane takes off!
* The airlines are seriously impressed by your work so far and as such have asked you to figure out how much baggage the planes can carry. How would you approach adding this functionality to your system?
* Handle other situations an airport might face! Use your research abilities and tremendous imagination to prepare for different possible scenarios
