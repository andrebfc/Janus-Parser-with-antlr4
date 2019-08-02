CC = c++
OUT = ${FILENAME}


$(OUT): $(OUT).o queue.o
				$(CC) $(OUT).o queue.o -o ../$(OUT) -lpthread

$(OUT).o: $(OUT).cpp queue.h
				$(CC) -c $(OUT).cpp

queue.o: queue.c queue.h
				$(CC) -c queue.c
