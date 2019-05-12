CC = c++

outexe: out.o queue.o
				$(CC) out.o queue.o -o ../outexe -lpthread

out.o: out.cpp queue.h
				$(CC) -c out.cpp

queue.o: queue.c queue.h
				$(CC) -c queue.c