debug: so_Basic.c
	gcc -g so_Basic.c -o a.out

output: so_Basic.o
	gcc -g so_Basic.o -o so_Basic

so_Basic.o: so_Basic.c
	gcc -c -Wall so_Basic.c -o so_Basic.o
	# gcc -Og so_Basic.c -o OgVer.o && xxd OgVer.o > OgVer.txt && rm -f OgVer.o
	# gcc -g so_Basic.c -o gVer.o && xxd gVer.o > gVer.txt && rm -f gVer.o

clean:
	rm -f *.o *.out gVer.txt OgVer.txt so_Basic