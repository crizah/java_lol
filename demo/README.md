
  The mental model:

  ┌────────────────────────┬───────────────────────────────────────────────┐
  │           Go           │                  Spring Boot                  │
  ├────────────────────────┼───────────────────────────────────────────────┤
  │ go mod init            │ start.spring.io                               │
  ├────────────────────────┼───────────────────────────────────────────────┤
  │ go.mod                 │ pom.xml                                       │
  ├────────────────────────┼───────────────────────────────────────────────┤
  │ go get                 │ add to pom.xml, Maven downloads on next build │
  ├────────────────────────┼───────────────────────────────────────────────┤
  │ .env + godotenv.Load() │ application.properties + env vars             │
  ├────────────────────────┼───────────────────────────────────────────────┤
  │ go run ./cmd/api       │ ./mvnw spring-boot:run                        │
  ├────────────────────────┼───────────────────────────────────────────────┤
  │ Atlas migration files  │ Flyway V1__*.sql files                        │
  └────────────────────────┴───────────────────────────────────────────────┘


  Compile to a jar (your actual question):

  ./mvnw package                    # compiles + runs tests + produces target/demo-0.0.1-SNAPSHOT.jar
  ./mvnw package -DskipTests        # skip tests (faster, like go build)

  java -jar target/demo-0.0.1-SNAPSHOT.jar   # run it

  Go parallel:
  go build -o bin/server ./cmd/api    →    ./mvnw package -DskipTests
  ./bin/server                        →    java -jar target/app.jar

  The jar is a fat jar — it contains all dependencies bundled in, like a statically linked Go binary. You ship just the jar file.





 src/main/java/com/yourname/abhiyan/
  ├── AbhiyanApplication.java        # main() lives here, don't touch
  │
  ├── controller/                    # handlers/ equivalent
  │   ├── AuthController.java
  │   ├── UserController.java
  │   └── TaskController.java
  │
  ├── service/                       # services/ equivalent
  │   ├── AuthService.java
  │   ├── UserService.java
  │   └── TaskService.java
  │
  ├── repository/                    # db/sqlc/ equivalent
  │   ├── UserRepository.java        # interface, Spring generates impl
  │   └── TaskRepository.java
  │
  ├── model/                         # DB table definitions (entities)
  │   ├── User.java
  │   └── Task.java
  │
  ├── dto/                           # request/response structs
  │   ├── LoginRequest.java
  │   ├── LoginResponse.java
  │   └── CreateTaskRequest.java
  │
  ├── security/                      # middleware/ equivalent
  │   ├── JwtFilter.java             # RequireAuth equivalent
  │   ├── SecurityConfig.java        # wires all security rules
  │   └── JwtUtil.java
  │
  └── config/                        # misc Spring config beans
      └── AppConfig.java

bullshit language, no wonder it employed so many people. its cos() the language is dumb and so so so verbose
