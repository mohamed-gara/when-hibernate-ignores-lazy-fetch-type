1. Introduction

When using ORM, in many situations, lazy loading is a real effective optimization.

The JPA specification states clearly that:

"The LAZY strategy is a hint to the persistence provider runtime that data should be fetched
lazily when it is first accessed. The implementation is permitted to eagerly fetch data for which the LAZY strategy hint has been specified."

So, it's important to know the cases in which the provider ignores the lazy fetch type and eagerly loads the associatied entities. This allows us to avoid some unexplained performance problems.

In the following sections we will try to identify some cases when using Hibernate. Also, we will try to find the justification behind it. I looked for an article about it, but I didn't find any. So, I decided to take the lead.

2. Lazy loading patterns

In PoEAA, the authors presented four patterns to implement Lazy Loading:

- Lazy initialisation
- Virtual proxy
- Value Holder
- Ghost