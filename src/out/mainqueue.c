#include <stdlib.h>
#include <stdio.h>
#include <semaphore.h>
#include "queue.h"

pthread_t p0,p1;
void *prog_0(void *arg);
void *prog_1(void *arg);
int count = 0;
#define limit 1500

Queue *pQ;// = ConstructQueue(limit);
NODE *pN;

sem_t mutex;
sem_t write;
sem_t read;
sem_t sync;

int r;

int main() {
    //inizializzo semafori
    sem_init(&read,0,limit);
    sem_init(&write,0,0);
    sem_init(&mutex,0,1);
    sem_init(&sync,0,0);

    //creo thread
    pQ = ConstructQueue(limit);
    pthread_create(&p0,NULL,prog_0,NULL);
    pthread_create(&p1,NULL,prog_1,NULL);
    pthread_join(p0,NULL);
    pthread_join(p1,NULL);
    DestructQueue(pQ);

    printf("************MAIN***********\n    RECEIVED: %d\n",r);
    return (EXIT_SUCCESS);
}

void *prog_0(void *arg){

    int i;
    for (i = 0; i < 30; i++) {
        int data = 100 + i;
        asend(data,pN,pQ,&mutex,&write,&read);
        //ssend(data,pN,pQ,&mutex,&write,&read,&sync);
    }
}

void *prog_1(void *arg){
    int i;
    //int r;
    for (i = 0; i < 30; i++){
        //r = srcv(pN,pQ,&mutex,&write,&read,&sync);
        r = arcv(pN,pQ,&mutex,&write,&read);
    }

    printf("prog1 received: %d\n",r);

}