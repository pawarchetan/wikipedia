# wikipedia

#### Technology used :
* Java8
* JUnit
* Gradle
* IDE used --> IntelliJ

#### How to run :
* Run `Solution.java` file.

#### Implementation details :
* **Parser package :** contains `WikipediaParser.java` which is responsible for parsing Wikipedia input to list of questions, answers and actual paragraph.
* **matcher package :** contains `QuestionAnswerMatcher.java`, which is responsible for finding all matching answers to question and picking best potential match out of it based on similarity score.
* **model package :**
  * `Answer.java` : used to repesent answer which will be get printed.
  * `Question.java` : used to process question, processing inludes finding all matching answers from given answers to a question, picking best match from all answers.
  * `Sentence.java` : used to process a particular sentence (question, content, answer), processing includes stemming, making it singular, finding the intersection between two list to find similarity etc.
  * `WikipediaInput.java` : used to represent parse wikipedia content to List of questions, answers and content.

#### Code coverage :
* Above 85%, most of the code has been covered (measured using Intellij IDEA plugin)

#### Assumptions made :
* The important assumption made is : We have already read text file using Java/IO and we have got string which contains Wikipedia paragraph, questions and answers.

#### Future scope :
* More negative test scenarios
