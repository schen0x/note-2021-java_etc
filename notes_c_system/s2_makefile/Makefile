# syntax:
# <target>: <dependencies>
#     <action>

output: main.o hello_world.o
	# -o link object files to an excutable.
	g++ main.o hello_world.o -o output

main.o: main.cpp
	# -c for compile but do not link
	g++ -c main.cpp

hello_world.o: hello_world.cpp hello_world.h
	g++ -c hello_world.cpp


clean:
	rm *.o output 