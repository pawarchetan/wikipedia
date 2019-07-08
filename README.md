# wikipedia

#### Technology used :
* Java8
* JUnit
* Gradle
* IDE used --> IntelliJ

#### How to run :
* Run `Solution.java` file.

#### Design considerations :
* We are assuming that when we will run actual solution on production environment, we will take input from user so that we will not have to do parsing/sequencing(as everything will be in ordered)
* Expose only required entities from `Solution.java` considering the boundary for a entire solution. We have exposed only `Wikipedia` and `Answer` from `Solution.java`.
* `Wikipedia` should not have a knowledge about line sequence ordering, it should be only responsible for giving answer to a question from paragraphContent and answers list. Thats why ordering/sequencing has been done before calling wikipedia.
* **Wikipedia.ask(question) :** Whenever we get a question, we ask Wikipedia to answer this question from the content wikipedia have.
* Private constructors has been used whenever required for immutability purpose.
* **Similarity score :** Similarity score has been calculated based on the intersection between two sentences by identfiying common words. Score has been calculated for (Sentence to Question) and (Sentence to Answer) and product of them has been considered to get best potential match.
* **Potential match :** Potential match has been determined by product of similarity score between question and sentence and similarity score between answer and sentence.
Potential match (answer) = Max(score(sentence,question) * (score(sentence,answer))
#### Code coverage :
* Above 95%, most of the code has been covered (measured using Intellij IDEA plugin)
