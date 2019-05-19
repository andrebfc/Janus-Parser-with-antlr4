#ifndef QUEUE_H
#define QUEUE_H

#include <pthread.h>


#define TRUE  1
#define FALSE	0


/* a link in the queue, holds the info and point to the next Node*/
typedef struct {
    int info;
} DATA;

typedef struct Node_t {
    DATA data;
    struct Node_t *prev;
} NODE;

/* the HEAD of the Queue, hold the amount of node's that are in the queue*/
typedef struct Queue {
    NODE *head;
    NODE *tail;
    int size;
    int limit;
} Queue;

Queue *ConstructQueue(int limit);
void DestructQueue(Queue *queue);
int Enqueue(Queue *pQueue, NODE *item);
NODE *Dequeue(Queue *pQueue);
int isEmpty(Queue* pQueue);

void asend(int data, NODE *pN, Queue *pQ,sem_t *mutex, sem_t *write, sem_t *read);
int arcv(NODE *pN, Queue *pQ, sem_t *mutex, sem_t *write, sem_t *read);

void ssend(int data, NODE *pN, Queue *pQ,sem_t *mutex, sem_t *write, sem_t *read, sem_t *sync);
int srcv(NODE *pN, Queue *pQ, sem_t *mutex, sem_t *write, sem_t *read, sem_t *sync);



#endif