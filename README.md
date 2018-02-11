## Introduction

In many situation, when using an ORM tool, lazy loading is a real effective optimization.

The JPA specification states clearly that:

> **The LAZY strategy is a hint of the persistence provider run time that data should be fetched lazily when it is first accessed. The implementation is permitted to eagerly fetch data for which the LAZY strategy hint has been specified.** (JSR 338 - p.429)

So, it's important to know the cases in which the provider ignores the lazy fetch type and eagerly loads the associated entities. This allows us to avoid some unexpected eager loading and unexplained performance problems.

In the following sections, we will try to identify some of this cases, when we use Hibernate as a JPA provider. Also, we will try to find the justification behind it. I have looked for an article about it, but I haven't  found any. So, I decided to take the lead.

## Lazy loading patterns

In PoEAA, the authors presented four patterns to implement Lazy Loading:

* Lazy initialisation
* Virtual proxy
* Value Holder
* Ghost

## When lazy fetch type is not applied

* Case 1: basic attribute
* Case 2: One To One reverse side
* Case 3: already in the persistence context
* Case 4: @NotFound annotation
* Case 5: query
* Case 6: join fetch
* Case 7: graph entity
* Case 8: fetch mode
