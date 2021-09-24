# SYSTEM related?

//Security, Optimization, Algorithms, PC Basic
//A: Algorithms, S: Security. O: Optimization
========================================

# Chapter A01, Sets

## arrays

## Bloom filter  
### Description
    //For quickly and effectively determining whether an element is present or not in a storage.
    //A bit array of m bits, all set to 0. With k different hash function defined, each of which maps or hashes the incoming element to a position m_k in m. (k different function or reuse one hash function of good distribution with different offset.)
    //Add an element: go through k functions with the element, get k mapping result (several m_k), set those bits to 1. (for example, set bits 2, 6, 8 to 1, the m of length 8 looks like: 10100010).
    //Find the k m_k bits of the incoming element, if any bits is 0, then the element is not present.
### Limitation
    //Not able to delete an element. "Removal can be simulated by having a second Bloom filter that contains items that have been removed. However, false positives in the second filter become false negatives in the composite filter, which may be undesirable."
    #Solution#: to not delete data. e.g., in DB, mark an entry as "deleted" but retain the data.
## hash tables

## linked lists

## self-balancing binary search tree

## tries


# Chapter S01, Cache
## Cache panetration
### Definition
    //when both cache and database query result return null.
    //Problem: a query has to go though both the cache as well as the database to confirm that a data does not exist. This behavior drastically increases IO.

### Cause
    + malicious attack
    + logic error
      
### Solution
    + Cache the empty data when an query returns empty
    + Apply a #[[#Bloom filter][Bloom filter]]# before the cache. The filter stores all keys and is able to quickly and efficiently determine the existence in the current database.

## Cache breakdown
### Definition
    //cached data expires and at the same time, large amount of query on the expired data cause direct hit on DB, thus increase load.

### Cause
    //concurrency
    
### Solution
    + apply a lock on the cache before modify it. So that other threads wait till the modification complete, then access the cache.

## Cache avalanche
### Definition
    //Large amount of cache expire at the same time or the cache service is down, result in direct hit on DB.
### Solution
    + use cluster to ensure some cache server instance will be available. Consider using #Redis#.
    + alternatively configure e.g. #hystrix circut breaker#, (when calls to a particular service exceed threshold and failure percentage is greater than threshold percentage, the circuit opens and the call is not made. A fallback maybe provided by the developer) and rate limit so that the core system can still serve traffic and avoid high load
    + may adjust the expiration time for different keys to avoid the scenario

      
# Chapter S02, Password Storage History from spring-security
  Since with modern hardware, billions of hash calculation per second can be performed, the SHA-256 with salt become insecure either.
  Thus a #work factor# should be considered, which can grow as hardware gets better. e.g. system takes 1 second to verify a password on the system.
  Some examples of "adaptive one-way functions" are:
      + bcrypt
      + PBKDF2
      + scrypt
      + argon2
        
   However, these resource intensive methods would inevitably degrade the perfomance. To alleviate the problem, users are encouraged to exchange the long term credentials(i.e. username and password) for a short term credential (i.e. session, OAuth Token, etc), which can be validated quickly without any loss in security. //However this concept, on the otherhand, could be easily misinterpreted. The misinterpretation could already be widly observed in the socity, especially: compulsory use of OTP calculator and cellphone two-step authentication. Those practices are gradually constituting an less secure world. Service should be built to serve its user, not the other way around.

# DISTRIBUTED DATABASE ARCHITECTURE

## CASE STUDY: EVE

- [the db architecture of EVE](https://www.gamedeveloper.com/design/infinite-space-an-argument-for-single-sharded-architecture-in-mmos)

### General Arch

1. large amount of the background content(the shape of solar systems) are procedurely generated. (like in RTS games)

2. Clients -> Sol Nodes(Proxy) -> single SQL
    - the Sol Nodes(Proxy) might be a process in a multi-core computer-blade.

### Yulai problem

> A few smart players determined that the Yulai solar system was particularly well connected to the various areas of the star cluster, and started selling their wares there in bulk.
> Those few canny marketeers on their own weren't a problem, but it didn't stay that way for long -- as more buyers visited the system more sellers set up shop there.
> As more sellers flocked in it became more desirable to buy there. Pretty soon it seemed like the entire playerbase was shopping in Yulai, and that system's population made up a noticeable percentage of the total online playerbase at any given time.
> In an effort to curb the growth of this trade hub before it started causing serious server issues, we made some changes to the map by shifting jump routes around to lessen the appeal of Yulai. Within a few months the "Yulai problem" became the "Jita problem," as players figured out the new best location and moved all their business there instead.
> The formation of such hubs seems to be an inherent human phenomenon, and while we still have regular design discussions about effective ways to distribute market activity more evenly without distorting the market itself, it's eventually something that we solved with hardware and software solutions.
> ... -------------------------------------------------------
> An area that has required constant attention and work from our operations team is how much we can break down a heavily laden area of the game world into chunks, and spread this load over multiple nodes. Currently at this level we can allocate a maximum of one server node to power an entire solar system, and one server node runs mostly on a single CPU core, splitting off networking and other asynchronous operations to another core.
> The design headaches that occur around the "Jita problem" mentioned above are specifically where we start to run into this limitation. When thousands of players go into the Jita system, or engage in fleet battles, we have often had trouble finding enough CPU power to handle the immense amount of processing required to keep the game simulation running lag-free. In the server room we keep Jita running on its own dedicated machine -- the biggest, meanest blade server that we can get our hands on.
> Software-based improvements like StacklessIO and 64-bit server code (see "running out of memory" above) really made a huge difference to our capacity in this area. Last year saw a three-pronged assault in our "War on Lag," where we rolled out StacklessIO, EVE64, and some top of the line server hardware almost simultaneously.
> The result was that our capacity in Jita went from around 600 players to 1,200 players -- a 100% improvement in capacity in under 6 months. Work continues in this fashion in order to again double this number, because we know that we will need to.

### the Great War problem

> The second clustering issue is almost the polar opposite to the problem of market hubs -- that of huge battles for strategic objectives. Whereas hubs are permanent and predictable fixtures, fleet-sized combat tends to be transitory and unpredictable. In our case at least, the emergent gameplay that delivers such value regularly compels huge political power blocs numbering thousands of players to make spirited attempts to beat the life out of their rivals.
> Without warning a particular system's population will shoot up from maybe half a dozen players to over 1200, generating a huge spike in server load before rapidly dropping back down to its original level. The abstract design solution to this is to spread the combat out across multiple systems simultaneously, but this is directly opposed to the ageless military principle of "hit them with everything we've got." It is an ongoing challenge to figure out how to implement this in practice in such a way that it's actually beneficial for military commanders to split their forces under the majority of common circumstances.

- in short, EVE use one powerful hardware(1 core + 64bit memory spaces) to handle a hot cluster. Also, separatable tasks are delegated to other cores on the computer-blade.

### asynchronous programming

- EVE uses stackless python, Since:
  + `tasklets`  virtually eliminates the need for complex locking and synchronization.
  + a model of non-blocking I/O. suspend the tasklet on calling `socket.recv()`, resume again when request is complete.

### DB statistics

- number of calls on each stored procedure
- how often an index is scanned
- DB code review