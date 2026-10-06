# Session Context for Handoff

## User Profile
- Primary languages: **Go** (main), **Python**, **C++** (DSA)
- Learning Java + Spring Boot for a job interview
- Does NOT want code written for them unless explicitly asked — they type it, you explain
- Draw parallels to Go first, C++ second, Python third
- Reference Go codebase at `~/Code/Abhiyan` (messy role-based auth server)

## Learning Goals (in order)
1. ~~Hello World~~ done
2. **Data structures + primitives** — done
3. Binary tree implementation (next)
4. Classes + OOP — constructors, inheritance, interfaces, role hierarchy
5. Concurrency demo — virtual threads, ExecutorService, CompletableFuture
6. Spring Boot — replicate key Abhiyan endpoints

## Final Project Goal
Recreate key endpoints from the Abhiyan Go server in Spring Boot:
- Role-based auth: `employee < admin < super_admin` hierarchy
- CORS middleware
- DB calls (Spring Data JPA / Flyway for migrations)
- Concurrency (some endpoints spawn goroutines in Go → need Java threading)
- Tests (JUnit 5 + Mockito)

## Key Concepts Covered So Far

### static
- `static` method/field = belongs to the class, not an instance
- Go equivalent: package-level function
- `public static void main(String[] args)` is the entry point — JVM calls it before any object exists

### Access modifiers
- `private` — class only
- *(none)* package-private — same package only (Go unexported equivalent)
- `protected` — same package + subclasses in other packages
- `public` — everywhere

### Interface vs Abstract
- `interface` = pure contract, explicit `implements`, compile error if you skip a method
- `abstract class` = partial implementation, can have some methods implemented, subclasses must fill in `abstract` methods
- Go interfaces are implicit (duck typing); Java interfaces are explicit

### Generics and primitives
- Java has two type universes: primitives (`int`, `double`, etc.) and reference types (everything else extends `Object`)
- Java generics use **type erasure** — `ArrayList<T>` becomes `ArrayList<Object>` at runtime
- Primitives don't extend Object → can't be used as generic type params
- Fix: wrapper types (`Integer`, `Double`, etc.) + autoboxing (runtime, not compile time)
- Go generics work like C++ templates (compile-time monomorphization) → no this restriction

### int[] vs ArrayList<Integer>
- `int[]` = fixed size, contiguous ints, primitive, cache-friendly (like C++ `int[]`)
- `ArrayList<Integer>` = dynamic, stores references to boxed Integer objects on heap (like C++ `vector<int>` but with boxing overhead)
- Go's `[]int` is closer to `int[]` — contiguous, no boxing

### Data structure syntax
```java
// Fixed array
int[] arr = new int[n];           // zero-initialized automatically
Arrays.fill(arr, -1);             // fill with value

// 2D array inline init
int[][] matrix = {{1,0}, {0,1}};

// ArrayList
List<Integer> list = new ArrayList<>();
list.add(3);
list.get(0);      // NOT list[0]
list.size();      // NOT list.length

// HashMap
Map<Integer, List<Integer>> map = new HashMap<>();
map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
map.getOrDefault(key, new ArrayList<>());
for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) { ... }

// Queue (BFS)
Queue<Integer> q = new ArrayDeque<>();
q.offer(val);     // enqueue
q.poll();         // dequeue, returns null if empty (safe)
q.push(val);      // also enqueue (stack-style name, same effect on ArrayDeque)
q.getFirst();     // peek without removing
q.isEmpty();
```

### Range-for loop
```java
for (int neighbor : list) { }   // equivalent to Go's: for _, neighbor := range list
```

### Compile and run
```bash
javac *.java
java Main
```

## Concurrency (explained, not coded yet)
- Java 21+ **Virtual Threads** ≈ Go goroutines (lightweight, JVM-scheduled, M:N, user space)
- Classic Java threads = heavyweight OS threads (like C++ std::thread)
- No GIL — true parallelism unlike Python
- No `select` statement; channels approximated by `BlockingQueue`
- `CompletableFuture` ≈ promises/futures
- `ExecutorService` = thread pool

## Spring Boot Quick Reference (explained, not coded yet)

| Gin (Go) | Spring Boot |
|---|---|
| `r.GET("/path", handler)` | `@GetMapping("/path")` on a method |
| `gin.HandlerFunc` | method in `@RestController` class |
| `r.Use(middleware)` | `HandlerInterceptor` or Spring Security filter |
| `c.JSON(200, obj)` | just return the object |
| `c.ShouldBindJSON(&req)` | `@RequestBody MyRequest req` |
| `c.Param("id")` | `@PathVariable String id` |
| `c.Query("filter")` | `@RequestParam String filter` |

DB:
- `sqlx` → Spring JDBC / JOOQ
- `sqlalchemy` ORM → Spring Data JPA / Hibernate
- `atlas`/`golang-migrate` → Flyway or Liquibase

Testing:
- `testing` + `testify` → JUnit 5 + AssertJ + Mockito
- `httptest` → MockMvc

## What's Next
1. Implement a binary tree in Java (practice class syntax, constructors, recursion)
2. Then OOP deep dive: constructors, inheritance, interfaces, abstract classes
3. Then concurrency demo
4. Then Spring Boot
