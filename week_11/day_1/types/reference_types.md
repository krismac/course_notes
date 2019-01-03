#Primitive Types v Reference Types
You might have been wondering why in previous lessons we spelled String with a capital S but int, double and boolean with a lowercase first letter. This is because that's Java's way of differentiating between primitive and other types.

In Java there are eight primitive types. You might also hear these called value types. This is because all they do is hold a value, and
have no other methods available.

The types are:
boolean (for true/false)
char (for unicode single characters, use single quotes)
byte, short, int, long (all for integers/whole numbers)
float, double (for float/decimal point numbers)

- All have a set amount of memory they take up.

- in Ruby / JS conversion of number sizes is done automatically and the appropriate amount of memory is allocated.

(Write up on board - info table for reference: http://docstore.mik.ua/orelly/java-ent/jnut/ch02_04.htm )

Any other data types are actually Java classes which have extra functionality built in. We've already seen the String class, other examples are arrays and HashMaps. These will all start with a capital letter like any other class, and have methods like length() or toUppercase() or isEmpty().

These other data types are known as reference types. The big difference between these and primitive/value types is that when you assign a variable to one of these they just make a REFERENCE to the information, rather than actually HOLDING the value themselves. This is important because if you make a copy of a reference type variable, such as when you pass some data in as an argument to a function, it is only copying a new reference to the same data, rather than making a clone of the data, which happens if you pass a primitive type in as an argument. Therefore if you do anything to change the data using this copied reference, it also changes the original data set, which can cause problems.



Link to docs for anyone who's particularly interested: http://docstore.mik.ua/orelly/java-ent/jnut/ch02_10.htm
