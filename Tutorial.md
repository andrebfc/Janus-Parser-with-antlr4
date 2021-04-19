# Janus

Janus is likely the very first reversible programming language, designed by Christopher Lutz and Howard Derby in 1986. 

It was later rediscovered by Michael P. Frank and further Robert Glück and Tetsuo Yokoyama after which it became a central research topic in the PIRC group. 

Since then several versions of the language have been developed.

This version introduces 'fork and join' constructor and message passing.

## Example

Here is an example of a program that can give you a first impression. The program computes a Fibonacci pair.

```
procedure fib(int x1, int x2, int n)
    if n = 0 then
        x1 += 1
        x2 += 1
    else
        n -= 1
        call fib(x1, x2, n)
        x1 += x2
        x1 <=> x2
    fi x1 = x2

procedure main()
    int x1
    int x2
    int n
    n += 4
    call fib(x1, x2, n)
```

## Program

A program is defined as a number of procedures. A procedure is defined by the `procedure` keyword followed by a name and a list of the inputs. 

All procedures are defined as call-by-reference, which means that procedures updates input values.

Like in C (and many other languages), programs must include a main procedure. Currently they does not take arguments and can only be defined with `main()`.

The body of a program is a new-line separated list statements.

### Comments
Comment are written with standard C notation.

## Types
The following will describe the different types available. Note that expressions

### int

Integer type is defined by the key word 'int' only in the main function, it's possible to passing the variable to the procedure as argument.

### local, delocal

It's possible to declare temporary integer using reserved key word 'local', and deallocate using 'delocal'.
    
    
            local [definition]
            ...
            ...
            delocal [assertion]
        
### Arrays

Arrays can be defined over any of the above types. An array is always defined to be a specific number of elements. 

Defining an array of seven integers is done by

    int text[7]

Arrays can also be initialised using a C style notation.

    int y[3] = {1,2,3}
    int z[3] = {4}
    

### Struct

Struct data can be defined similar a C syntax,

    struct [tagName]
        [Var declare]
        ....
    end
    
Struct data can be initialized into a function using similar C syntax,

    struct [tagName] [structName]    
    
and using dot notation to access the variable.

    [tagName].[Var]    

### Port

The ports are used on a Message Passing and feature a queue of message.

    port [PortName]

## Swap

The swap operator allows to exchange the contents of two variables.
    
    [Var a] <=> [Var b]
    
This expression is interpreted as:
        
    [Var a] ^= [Var b]
    [Var b] ^= [Var a]
    [Var a] ^= [Var b]


### Conditional and assertions
Following the normal convention of reversible programming the conditional is extended with a `fi` assertion.

```
if [Cond]
then
  [Stmt1]
else
  [Stmt2]
fi [Assert]
```


### Loops
The most general loop construct in Janus is the following, which can be seen as combination of the while-do and do-while loops, with the addition of an entry/iteration assertion.

```
from [Assert]
do
  [Stmt1]
loop
  [Stmt2]
until
  [Cond]
```


### Procedure calls
Procedure calls are made using the `call` keyword. 

As the language is reversible we can also reverse compute (or interpret) procedures using the `uncall` keyword.

### Fork and Join

It's possible to execute more process in concurrence using 'fork and join' constructor. 

The syntax is:
    
    fork 
        [P1]
    and
        [P2]
    join
    
which executes P1 and P2 in parallel.     

Fork and Join constructor allows the user to passing data in P1 and P2 using 'struct'.
    
    fork [StructName]
        [P1]
    and
        [P2]
    join           

### Message passing

There are two way to use message passing, the first is message passing with local memory, this is a default option or 
activable with -m flag. The second way is message passing with shared memory, where the struct on the thread are shared, 
this option is activable with -s flag.

Example:

    java janus fibonacci.jan -s  

The message passing mechanism can be used in a way synchronous or asynchronous using ports. The port is queues of message.

For synchronous message passing it's possible to use ssend(x,p) function where the value 'x' is sent via the 'p' port, 
and srcv(y,p) function which dequeues a value from from port 'p' and stores it in variable 'y'.

For asynchronous message passing it's possible to use asend(x,p) and arcv(y,p) functions. 

In both methods, after the send, the value of 'x' will be 0, and the value of 'y' before the receive should be 0.  

## Print

To print a value:

    print [Var]
or
    print ([Var])
    
If you want to be sure to see the printed value when using the fork and join, you must use the -j flag to wail all processes.

## Local and shared memory

On this janus interpreter it is possible to select type of memory on processes. 

In local memory (default) the 'fork and join' processes make a copy of the structure and use this, you can use this option using the -m flag or nothing in the parsing phase.

Example:
    
    java janus [filename.jan] 
or

    java janus [filename.jan] -m

In shared memory the 'fork and join' processes use a pointer to struct, on this mode the data are shared, for this option using the -s flag.

Example: 

     java janus [filename.jan] -s

## Expressions

### Operator
Janus has the following binary operators:

  * Addition: `+`
  * Subtraction: `-`
  * Multiplication: `*`
  * Integer division: `/`
  * Modulo: `%`
  * Value negation: `~`


### Operator Condition
  * Less-than or equal-to: `<=`
  * Less-than: `<`
  * Greater-than or equal-to: `>=`
  * Greater-than: `>`
  * Equal-to: `=`
  * Not equal-to: `!=`

### Logical operators:
  * Logical and: `&&`
  * Logical or: `||`
  * Logical Negation: `!`

