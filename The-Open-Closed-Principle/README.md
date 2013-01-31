TheLadders' SOLID Exercises - The Open/Closed Principle
===============

Watch [the code-cast](http://www.cleancoders.com/codecast/clean-code-episode-10/show) then dig into the exercise.

---

Crack open the class ConfidentialResumeHandler and check out the two public methods. Both violate the Open-Closed Principle.

* How do these particular methods violate the Open-Closed Principle?
* What happens if you add another value to the ConfidentialPhraseCategory enumeration? How would you refactor these methods to prevent violation of the principle when the enumeration itself is modified?
* If you then expanded the scope of the principle to the ConfidentialPhraseCategory enumeration as well, so that it too would be closed to modification but open to extension, how might you need to refactor both the methods and the enumeration?

Go ahead and try refactoring the code and answer the questions above.
