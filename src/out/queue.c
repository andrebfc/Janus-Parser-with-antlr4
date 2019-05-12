#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include "queue.h"


Queue *ConstructQueue(int limit) {
    Queue *queue = (Queue*) malloc(sizeof (Queue));
    if (queue == NULL) {
        return NULL;
    }
    if (limit <= 0) {
        limit = 65535;
    }
    queue->limit = limit;
    queue->size = 0;
    queue->head = NULL;
    queue->tail = NULL;

    return queue;
}

void DestructQueue(Queue *queue) {
    NODE *pN;
    while (!isEmpty(queue)) {
        pN = Dequeue(queue);
        free(pN);
    }
    free(queue);
}

int Enqueue(Queue *pQueue, NODE *item) {
    /* Bad parameter */
    if ((pQueue == NULL) || (item == NULL)) {
        return FALSE;
    }
    // if(pQueue->limit != 0)
    if (pQueue->size >= pQueue->limit) {
        return FALSE;
    }
    /*the queue is empty*/
    item->prev = NULL;
    if (pQueue->size == 0) {
        pQueue->head = item;
        pQueue->tail = item;

    } else {
        /*adding item to the end of the queue*/
        pQueue->tail->prev = item;
        pQueue->tail = item;
    }
    pQueue->size++;
    return TRUE;
}

NODE * Dequeue(Queue *pQueue) {
    /*the queue is empty or bad param*/
    NODE *item;
    if (isEmpty(pQueue))
        return NULL;
    item = pQueue->head;
    pQueue->head = (pQueue->head)->prev;
    pQueue->size--;
    return item;
}

int isEmpty(Queue* pQueue) {
    if (pQueue == NULL) {
        return FALSE;
    }
    if (pQueue->size == 0) {
        return TRUE;
    } else {
        return FALSE;
    }
}


void asend(int data, NODE *pN, Queue *pQ,sem_t *mutex, sem_t *write, sem_t *read){

    //sem_wait(&read);
    sem_wait(read);
    sem_wait(mutex);
    //send
    pN = (NODE*) malloc(sizeof (NODE));
    pN->data.info = data;
    Enqueue(pQ, pN);

    sem_post(mutex);
    sem_post(write);
}

int arcv(NODE *pN, Queue *pQ, sem_t *mutex, sem_t *write, sem_t *read){

    int data = 0;
    //sem_wait(&write);
    sem_wait(write);
    sem_wait(mutex);
    pN = Dequeue(pQ);
    data = (int)pN->data.info;
    free(pN);

    sem_post(mutex);
    sem_post(read);
    return data;
}


void ssend(int data, NODE *pN, Queue *pQ,sem_t *mutex, sem_t *write, sem_t *read, sem_t *sync){

      //asend code
      //sem_wait(&read);
      sem_wait(read);
      sem_wait(mutex);
      //send
      pN = (NODE*) malloc(sizeof (NODE));
      pN->data.info = data;
      Enqueue(pQ, pN);

      sem_post(mutex);
      sem_post(write);

      //ssend code
      sem_wait(sync);

}

int srcv(NODE *pN, Queue *pQ, sem_t *mutex, sem_t *write, sem_t *read, sem_t *sync){

        //arcv code
        int data = 0;
        //sem_wait(&write);
        sem_wait(write);
        sem_wait(mutex);
        pN = Dequeue(pQ);
        data = (int)pN->data.info;
        free(pN);

        sem_post(mutex);
        sem_post(read);
        //srcv code
        sem_post(sync);

        return data;
}
