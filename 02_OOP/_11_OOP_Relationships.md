# OOP Relationships & Class Relationships in Java

This file covers the major relationships used in Object-Oriented
Programming and how they are represented conceptually in Java.

------------------------------------------------------------------------

## 1. Overview of OOP Relationships

Classes can be related to each other in different ways:

-   **IS-A** → Inheritance
-   **HAS-A** → Association
    -   Aggregation
    -   Composition
-   **Uses-A** → Dependency
-   **1:1, 1:N, N:1, M:N** → Multiplicity/cardinality between objects

A simple way to remember them:

``` text
IS-A       → Inheritance
HAS-A      → Association
PART-OF    → Aggregation / Composition
USES-A     → Dependency
```

------------------------------------------------------------------------

# 2. IS-A Relationship --- Inheritance

An **IS-A relationship** means one class is a specialized form of
another class.

In Java, an IS-A relationship is created using:

-   `extends` → class inheritance
-   `implements` → interface implementation

### Example

``` text
Animal
  ▲
  │ IS-A
  │
  Dog
```

A `Dog` **IS-A** `Animal`.

### Diagram

``` mermaid
classDiagram
    Animal <|-- Dog
    Animal <|-- Cat

    class Animal {
        +eat()
    }

    class Dog {
        +bark()
    }

    class Cat {
        +meow()
    }
```

### Java

``` java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
```

Here:

``` text
Dog IS-A Animal
Cat IS-A Animal
```

### Important

Inheritance represents an **IS-A** relationship, not merely code reuse.

Use inheritance when the child genuinely represents a specialized form
of the parent.

------------------------------------------------------------------------

# 3. HAS-A Relationship --- Association

A **HAS-A relationship** means one class is related to or contains a
reference to another class.

Association is a broad relationship between two independent classes.

### Example

``` text
Student ─────────── College
        associated with
```

A `Student` can be associated with a `College`, but both can exist
independently.

### Diagram

``` mermaid
classDiagram
    Student --> College : associated with

    class Student {
        +name
    }

    class College {
        +name
    }
```

### Java

``` java
class College {
    String name;
}

class Student {
    String name;
    College college;
}
```

The `Student` class has a reference to `College`.

------------------------------------------------------------------------

# 4. Association

**Association** is the general relationship between two classes where
objects know about or interact with each other.

It can be:

-   One-to-one
-   One-to-many
-   Many-to-one
-   Many-to-many

Association does not necessarily mean ownership.

### Example

``` text
Teacher ───────── Student
         teaches
```

A teacher and students can exist independently.

``` mermaid
classDiagram
    Teacher "1" --> "many" Student : teaches

    class Teacher {
        +name
    }

    class Student {
        +name
    }
```

This is a **1:N association**.

------------------------------------------------------------------------

# 5. Multiplicity / Cardinality

Multiplicity describes **how many objects** of one class can be
associated with an object of another class.

Common multiplicities:

  Notation   Meaning
  ---------- --------------
  `1`        Exactly one
  `0..1`     Zero or one
  `*`        Many
  `0..*`     Zero or many
  `1..*`     One or many

------------------------------------------------------------------------

## 5.1 One-to-One --- 1:1

One object is associated with exactly one object of another class.

### Example

``` text
Person ───────── Passport
   1                 1
```

``` mermaid
classDiagram
    Person "1" --> "1" Passport : owns
```

Conceptually:

``` text
One Person → One Passport
One Passport → One Person
```

------------------------------------------------------------------------

## 5.2 One-to-Many --- 1:N

One object can be associated with many objects.

### Example

``` text
Department
    │
    │ 1
    │
    │
    │ N
    ▼
Employees
```

``` mermaid
classDiagram
    Department "1" --> "0..*" Employee : has
```

Conceptually:

``` text
One Department → Many Employees
One Employee   → One Department
```

### Java

``` java
class Department {
    String name;
    Employee[] employees;
}

class Employee {
    String name;
}
```

------------------------------------------------------------------------

## 5.3 Many-to-One --- N:1

Many objects are associated with one object.

``` text
Employee  ───┐
Employee  ───┼──> Department
Employee  ───┤
Employee  ───┘
```

``` mermaid
classDiagram
    Employee "0..*" --> "1" Department : works in
```

This is the reverse view of a 1:N relationship.

------------------------------------------------------------------------

## 5.4 Many-to-Many --- M:N

Many objects of one class can be associated with many objects of another
class.

### Example

``` text
Students  ⇄  Courses
```

A student can enroll in many courses, and a course can have many
students.

``` mermaid
classDiagram
    Student "0..*" --> "0..*" Course : enrolls in
```

Conceptually:

``` text
Many Students → Many Courses
```

------------------------------------------------------------------------

# 6. Aggregation --- Weak HAS-A

**Aggregation** is a specialized form of association representing a
**whole-part relationship** where the part can exist independently of
the whole.

### Example

``` text
Department ◇──── Employee
```

An employee can exist even if the department object is removed.

### Diagram

``` mermaid
classDiagram
    Department o-- Employee : has
```

The **hollow diamond (`◇`)** represents aggregation.

### Example

``` text
University ◇──── Professor
```

``` text
University
    ◇
    │
    ├──── Professor
    ├──── Professor
    └──── Professor
```

If the `University` object is destroyed, the `Professor` objects can
still exist independently.

### Java

``` java
class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }
}

class University {
    Professor professor;

    University(Professor professor) {
        this.professor = professor;
    }
}
```

The `Professor` object is created outside `University` and passed into
it.

``` java
Professor p = new Professor("Dr. Sharma");
University u = new University(p);
```

This demonstrates the independent lifecycle of the part.

------------------------------------------------------------------------

# 7. Composition --- Strong HAS-A

**Composition** is a stronger form of aggregation.

The part is strongly owned by the whole and normally cannot meaningfully
exist independently of that particular whole.

### Example

``` text
House ◆──── Room
```

A `Room` is considered a part of a particular `House`.

### Diagram

``` mermaid
classDiagram
    House *-- Room : contains
```

The **filled diamond (`◆`)** represents composition.

### Java

``` java
class Room {
    void show() {
        System.out.println("Room");
    }
}

class House {
    private Room room;

    House() {
        room = new Room();
    }
}
```

Here, `House` creates its own `Room`.

``` text
House
  │
  ◆
  │
 Room
```

The `Room` object is created as part of the `House` object's
construction.

------------------------------------------------------------------------

# 8. Aggregation vs Composition

Both represent a whole-part relationship, but their ownership and
lifecycle differ.

  Feature                      Aggregation             Composition
  ---------------------------- ----------------------- --------------
  Relationship                 Weak HAS-A              Strong HAS-A
  Ownership                    Weak                    Strong
  Lifecycle                    Independent             Dependent
  Part can exist separately?   Yes                     Generally no
  UML symbol                   `◇`                     `◆`
  Example                      University--Professor   House--Room

### Quick visual

``` text
AGGREGATION

University
    ◇
    │
 Professor

Professor can exist independently.


COMPOSITION

House
    ◆
    │
  Room

Room belongs strongly to the House.
```

------------------------------------------------------------------------

# 9. Association vs Aggregation vs Composition

These three are related concepts:

``` text
Association
    │
    ├── General relationship
    │
    └── Whole-Part relationship
            │
            ├── Aggregation
            │      Weak ownership
            │
            └── Composition
                   Strong ownership
```

Another way to remember:

``` text
Association
    ↓
"These objects are related."


Aggregation
    ↓
"This object has those objects,
but they can live independently."


Composition
    ↓
"This object strongly owns those objects."
```

------------------------------------------------------------------------

# 10. Dependency --- USES-A Relationship

A **dependency** means one class temporarily uses another class.

The dependent class does not necessarily store the other class as a
field.

### Example

``` text
Order ─ ─ ─ ─ > PaymentService
       uses
```

``` mermaid
classDiagram
    Order ..> PaymentService : uses
```

The dashed arrow represents dependency.

### Java

``` java
class PaymentService {
    void pay() {
        System.out.println("Payment processed.");
    }
}

class Order {
    void checkout(PaymentService service) {
        service.pay();
    }
}
```

`Order` depends on `PaymentService` for the `checkout()` operation.

------------------------------------------------------------------------

# 11. IS-A vs HAS-A vs USES-A

``` text
IS-A
 ↓
Inheritance

Dog ──IS-A──> Animal
```

``` text
HAS-A
 ↓
Association / Aggregation / Composition

Car ──HAS-A──> Engine
```

``` text
USES-A
 ↓
Dependency

Order ──USES-A──> PaymentService
```

### Comparison

  -----------------------------------------------------------------------
  Relationship            Meaning                 Common Java mechanism
  ----------------------- ----------------------- -----------------------
  IS-A                    Specialized form        `extends`, `implements`

  HAS-A                   Contains/associated     Object reference
                          with                    

  Aggregation             Weak whole-part         Object reference passed
                                                  from outside

  Composition             Strong whole-part       Object created/owned by
                                                  containing class

  USES-A                  Temporary usage         Method parameter/local
                                                  usage
  -----------------------------------------------------------------------

------------------------------------------------------------------------

# 12. General Relationship Diagram

The following diagram summarizes the major OOP relationships:

``` mermaid
classDiagram

    Animal <|-- Dog
    Student --> College
    University o-- Professor
    House *-- Room
    Order ..> PaymentService

    class Animal
    class Dog
    class Student
    class College
    class University
    class Professor
    class House
    class Room
    class Order
    class PaymentService
```

Legend:

``` text
<|--  Inheritance / IS-A

-->   Association / HAS-A

o--   Aggregation / weak HAS-A

*--   Composition / strong HAS-A

..>   Dependency / USES-A
```

------------------------------------------------------------------------

# 13. Relationship Hierarchy to Remember

``` text
                    OOP Relationships
                           │
          ┌────────────────┼────────────────┐
          │                │                │
        IS-A             HAS-A            USES-A
          │                │                │
     Inheritance       Association      Dependency
                           │
                    ┌──────┴──────┐
                    │             │
               Aggregation    Composition
                 Weak HAS-A    Strong HAS-A
```

------------------------------------------------------------------------

# 14. Important Exam Points

-   **IS-A** relationship represents inheritance.
-   `extends` creates class inheritance.
-   `implements` represents an interface-based IS-A relationship.
-   **HAS-A** usually refers to an object reference between classes.
-   **Association** is the general relationship between objects.
-   **Aggregation** represents a weak whole-part relationship.
-   **Composition** represents a strong whole-part relationship.
-   In aggregation, the part can exist independently.
-   In composition, the part is strongly tied to the lifecycle of the
    whole.
-   **Multiplicity** describes how many objects participate in a
    relationship.
-   `1:N` means one object is associated with many objects.
-   `N:1` means many objects are associated with one object.
-   `M:N` means many objects can be associated with many objects.
-   **Dependency** represents temporary usage of another class.
-   UML commonly uses:
    -   `◇` for aggregation
    -   `◆` for composition
    -   dashed arrow for dependency
    -   hollow triangle arrow for inheritance

------------------------------------------------------------------------

# 15. Quick Revision

``` text
IS-A
Dog IS-A Animal
        ↓
Inheritance


HAS-A
Car HAS-A Engine
        ↓
Association


PART-OF
House ◆── Room
        ↓
Composition


WEAK PART-OF
University ◇── Professor
              ↓
          Aggregation


USES-A
Order - - -> PaymentService
              ↓
          Dependency


MULTIPLICITY
1:1  → One-to-One
1:N  → One-to-Many
N:1  → Many-to-One
M:N  → Many-to-Many
```
