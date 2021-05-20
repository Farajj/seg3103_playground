# seg3103_playground
 Java

To run the Java program (in newmath_java), first I compile it

javac -encoding UTF-8 --source-path src -d dist src/*.java
Then I run it

java -cp ./dist Main
Here is an output of the running program

Newmath (type 'exit' to exit program)
Numerator: 10
Demoninator: 2
10 / 2 = 5
Numerator: exit




JUnit

To run JUnit, I need to compile the application (see above), and then compile the test code

javac -encoding UTF-8 --source-path test -d dist -cp dist:lib/junit-platform-console-standalone-1.7.1.jar test/*.java
Then I run the tests using

java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path




Elixir

To run the Elixir program (in newmath_ex), first I compile it

mix compile
Then I run it

iex -S mix
