Capstone Project - Phase 1
-Option D: The Decision Engine (Trees)

--------------------------------------

-Game Graphics Rendering Engine
The project is for a system for game graphics rendering that decides on quality and render distance of objects given from inputs of user settings and in-game distance. The goal is to optimize user preference, hardware optimization, and performance. The most appropriate structure for this task should be a decision tree. It is simple and clear to follow taking inputs and deciding how results are output based on such.

-------------------------------------

Big-O Expectations
Depending on how program checks inputs and conditions from leaf to root, the decision tree should have O(h) time complexity with h being tree's height. If balanced it could get close to O(log n) and for the worst case could get to O(n).

-------------------------------------

UML Diagram

-----------------------------
 Node 
-----------------------------
| - condition: String |
| - left: Node |
| - right: Node |
| - result: String |
-----------------------------

          |
          v

----------------------------------
 DecisionTree 
----------------------------------
| - root: Node |
----------------------------------
| + evaluate(distance, |
| renderDistance, |
| renderQuality, |
| shaderQuality, |
| objectQuality, |
| gameDistance ): String |
----------------------------------

          |
          v

----------------------
 Main 
----------------------
| + main(): void |
----------------------
