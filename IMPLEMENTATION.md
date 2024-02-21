# Implementation: The Goal Behind Your Code

Include your pseudocode and/or diagrams showing how you designed your approach to each method


## Phase 1
- Need a head and tail for a list

SLL<T> constructor
- initialize head and tail to null

getHead()
- return this.head

getTail()
- return this.tail

isEmpty()
- return T/F if head==null

addFirst()
- make new node for v, set item to head and if next item is null, set the node to tail as well

toString()
- make a string variable and loop through the list and add it to the string. End with "]"


## Phase 2

addLast()
- make a new node for v and set next as null
- if list empty, set node as tail and head
- else, add node to the existing tail and set node as new tail 

addAfter()
- loop through the list, if item is here and if next item is not null, set a new node after the here
- else if next item is null, set a new node after here and make it as a tail

removeFirst()
- set a new T variable of the removed item(the head)
- set head as the next item
- remove the head from the list


removeLast()
- make new removedItem tail variable 
- loop through the list, if next item is tail, set the item before tail as the tail and set item after as null
- else if item is head and tail(there is only one item in the list), set head and tail to null 

removeAfter()
- here is null, removed item is the tail and head is null
- else, removeditem is the next node of here. if the second node from here is not null, then set here to the second node from the here. if null is after setting the new node, then set the new node as the tail
- else if the second node from here is null, then set the next node null, and tail is here.

size()
- set a count variable, loop through the list, and increment count, then return count


## Phase 3
SelfInsertException() 
- spliceByCopy ()
    if it splice itself, then throw new self insert exception
- spliceByTransfer() 
    if it splice by itself, then throw new self insert exception

MissingElementException()
- removeAfter
- removeLast
- removeFirst
    if it removes something that is not there, then throw MissingElementException()


## Phase 4
Copy Constructor 
- set head and tail to the head and tail of the list
- if(list empty) {addfirst(head); (for each node {add the next item if it is not the tail or add null if item is null)} 

subseqByCopy() 
- make a new list
- add first item, here, to the new list
- loop through the list, append the data using addLast--the end of the new list
- return list 

spliceByCopy()
- if afterhere is null, create new node for list2.head. add that node to the list. previous item is the head
- for each item starting from the node after the head of list2, add item after the previous item and then increment the previous item to the next item to repeat the process. 
- if list is not empty, new node for after here, new variable T for the list 2 head, and add the copied item into the list. 
- loop through the list starting from list2.head, addAfter (node, item), increment afterNode to the next node

subseqByTransfer
- if(afterHere is null), make for loop to add new inserted list to a new list. then make a second loop to remove the items
- else, create a new list. loop through to add new inserted list, then make a second for loop to remove the items from the list. 

spliceByTransfer
- make a new list. 
- if(afterHere is null), make a loop to add the tail , then remove the last nodes
- if afterHere is not null, loop through the size, addAfter, increment the node to the next node, and remove the first node. 
