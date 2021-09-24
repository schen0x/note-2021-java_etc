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
