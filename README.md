# TinderQuiz


### Answer some questions turn by turn and find your intellectual match!


## Rules

 - Minimum of 4 Players
 - Each round every player receives a question
 - If you answer it right, don't drink and move on to the next
 - If you fail, drink, move on to the next
 - The game ends after 5 rounds
 - After the end, game checks if you matched with someone
 
 
## How to Play

 - Execute the jar bin
 - Choose a free port
 - Connect to it using netcat
 - Input your name and phone number
 - Play!


## Project:
The idea was to produce a small chat, in which the participants answered a set of questions and in the end, depending on the result, they may or may not find their match, the idea is to find someone who matches within a range of correct answers.


### Development:

Given the current state of the pandemic, the project was developed and organized using Zoom. Firstly, we developed a UML for the project consisted of a client/server apllication using TCP and implementing the architectural pattern MVC, in the initial phase we were all involved in the base of the project, then the group was due in small tasks in each member. We were in charge of developing the server end, while using netcat as a simulator for the client end. This server was capable of handling multiple players and manage player rounds (while one player is answering, others need to wait for their turn, and are able to see the question and the answer given)


#### Technologies/Tools used:
Maven, Git, Java, MVC, UML, Architecture Client-Server (TCP), Netcat


##### Team:
- [Filipe Caçador](https://github.com/FiCacador)
- [Diney Rosário](https://github.com/silvaney007)
- [Tiago Silva](https://github.com/TiagoSilva-artRepo)
- [João Pinheiro](https://github.com/joaopinheiro10)
