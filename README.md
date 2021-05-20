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

Code run:
<img width="566" alt="java" src="https://user-images.githubusercontent.com/16924891/119040279-37071f00-b983-11eb-8f77-9cef906a297d.png">






JUnit

To run JUnit, I need to compile the application (see above), and then compile the test code

javac -encoding UTF-8 --source-path test -d dist -cp dist:lib/junit-platform-console-standalone-1.7.1.jar test/*.java
Then I run the tests using

java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path

Code run:

<img width="645" alt="junit" src="https://user-images.githubusercontent.com/16924891/119040262-2f477a80-b983-11eb-820b-34ad1926c87b.png">





Elixir

To run the Elixir program (in newmath_ex), first I compile it

mix compile
Then I run it

iex -S mix

Code run:
<img width="512" alt="elixir_iex" src="https://user-images.githubusercontent.com/16924891/119040173-1343d900-b983-11eb-8cb2-7141a6627f1c.PNG">
