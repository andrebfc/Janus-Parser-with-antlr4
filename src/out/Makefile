CC = c++
OUT = ${FILENAME}


$(OUT): $(OUT).o queue.o
				$(CC) $(OUT).o queue.o -o ../../$(OUT) -lpthread

$(OUT).o: $(OUT).cpp ./../concurrency/queue.h
				$(CC) -c $(OUT).cpp

queue.o: ./../concurrency/queue.c ./../concurrency/queue.h
				$(CC) -c ./../concurrency/queue.c

clean:
				rm -f *.o *.cpp
