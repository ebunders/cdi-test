CDI tutorial: http://java.dzone.com/articles/cdi-di-p1

Amazing stuff I learned:

@Inject:     Injection at all points (not static) with @Inject
@Default     Implementations are 'default' by default (blah),a single default is injected by... you get it.
             default impl can be overridden in beans.xml, this even overrides @Produce
@Alternative but you can annotate them with @alternative.
@Name You can name your bean for easy lookup with @Name("name")
@Produce    marker for factory method.

Qualifiers
All objects have (a) Qualifier(s). By default objects have @Default and @Any
Qualifiers are used to resolve what to inject, by matching them up. The idea is you write your own, mark the injectable with it
at class level, and mark the 'to be injected' field with it as well.

hierarchy high wins from low:
- Qualifiers
- beans.xml default
- @Produce factory
- @Default annotation

The default system is great if you want one implementation in the whole system (say: logger factory)
The Qualifier system is great if you want different implementations for different uses (say Writers to different backends)
Qualifiers are for composition, defaults more for configuration. (as I see it)

note: an injectable with a custom qualifier and also @Default, is no longer considered a match. Weird...
note: you can annotate the return type of a @Produce method with a custom qualifier, and it works. Yay!

@PostConstruct annotated methods will be called after injection, before 'the business'. use for
runtime configuration based on...


