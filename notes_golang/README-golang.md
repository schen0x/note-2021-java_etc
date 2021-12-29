# GOLANG

## TABLE OF CONTENTS

- [GOLANG](#golang)
  - [TABLE OF CONTENTS](#table-of-contents)
  - [CHANNEL](#channel)
    - [CHANNEL INTERNALS](#channel-internals)
    - [CHANNEL INTERNALS, CASE STUDY](#channel-internals-case-study)

## CHANNEL

### CHANNEL INTERNALS

```go
ch := make(chan Task, 3)
```

- the statement allocate a struct `hchan` _on the heap_, `type hchan struct { buf, sendx, recvx, mutex, ...}`
- the `buf` points to a circular queue.
- the `ch` is a pointer to the `hchan` struct
- the send index `sendx` increment on an enqueue
- the receive index `recvx` increment on a dequeue

### CHANNEL INTERNALS, CASE STUDY

```go
// go-routine G1
func main() {
    // ...
    for _, task := range tasks {
        taskCh <- task
    }
    // ...
}
```

```go
// go-routine G2
func worker() {
    // ...
    for {
        task := <- taskCh
    }
    // ...
}
```

- G1 `ch <- task0`:

  1. acquire the lock on the struct
  2. enqueue (_memcpy_)
  3. release the lock

- G2 `t := <-ch`

  1. acquire the lock
  2. dequeue (_memcpy_)
  3. release the lock

- i.e. The only shared memory between G1 and G2 is the pointer to `hchan`
