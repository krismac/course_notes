# Multiple Classes Lab

Using TDD, your task is to model a Bus which can pick up and drop off passengers.

## Part A
### Step 1
- Create a Bus class. 
- The Bus should have a route number (e.g. 22) and a destination (e.g. "Ocean Terminal").
- The Bus should have a drive method that returns a string (e.g. "Brum brum").

### Step 2
- Create a Person class.
- The Person class should have attributes of a name and age.

## Part B
- Give the Bus class a new property, 'passengers'. This should be an array, which starts off empty. 
- Add a method to the Bus class which returns how many passengers are on the bus. 
- Add a method to the Bus class which takes in a Person and adds it to the array of passengers. The method could look something like `bus.pick_up(passenger1)` 
- Add a method that drops off a passenger and removes them from the array. This could look like `bus.drop_off(passenger2)`
- Add an 'empty' method to remove all of the passengers - this might be used when the bus reaches its destination, or if the bus breaks down. It should remove all of the passengers from the array.

## Extension
- Create a new class called BusStop. This should have a name attribute. 
- Add an attribute to the BusStop called 'queue'. This should be an empty array that will get filled with instances of the Person class.
- Add a method that adds a person to the queue.

Now imagine that our bus is travelling along the route. For now we will imagine that there is only one bus that goes on this route, so every passenger waiting at each stop wants to get on the bus. 

- Try writing a method that the bus would call, to collect all of the passengers from a stop. This might look like `bus.pick_up_from_stop(stop1)`. This should take all of the passengers waiting in line at the stop, and put them inside of the bus. So the stop will now have nobody in the queue, and the number of people on the bus will increase by however many people the stop had at it. 
