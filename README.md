# Jurassic-Fight

[Github Page](https://github.com/0xtter/Jurassic-Fight)

![image](https://user-images.githubusercontent.com/112948108/193612495-f6cc4680-91b2-4c07-a858-76452e66bce5.png)

| Nom | Ptérodactyle | Tyrannosaures | Diplodocus | Mosasaures |
| --- | ------------ | ------------- | ---------- | ---------- |
|     |              |               |            |            |

## Requirements 📑

### Scenario

- [ ] 4 Groups in competition.
- [ ] Alliances between the groups.
- [ ] Specificial individual for each group called "Master".
- [ ] The more a teacher has listened to different messages, the more likely the group is to be the wiser and therefore to be the winner.
- [ ] The Master cannot move.
- [ ] Individuals brings back knwoledge to the master.
- [ ] The exchange of message between two individuals is done according to their group and a possible alliance.
- [ ] Pseudo randomness on the movements.
- [ ] Pseudo randomness on the reception of the messages.
- [ ] Event (like asteroid or tsunami) that can influence the scene.

### Class Diagram

<p style="color:red">Map Class</p>

- [ ] Rectangular shape.
- [ ] Each corner has a 'SafeZone'.
- [ ] Sum of the 4 SafeZones are less than half of the surface of the map.
- [ ] Each master is static in the SafeZone
- [ ] The map is discretized into n*m boxes.
- [ ] The boxes are identifiable by a horizontal index and a vertical index.
- [ ] A method of the Map class will return the tiles available around a tile given as a parameter.
- [ ] A method will return the direction to take to reach your own SafeZone.
- [ ] Obstacles can be generated randomly at the start of the simulation.
- [ ] Each box can contain a maximum of one indidividual or obstacle; when there

### Statechart Diagram

### Activity Diagram

### Simulation

- [ ] The simulation is discrete and at constant time step.
- [ ] At each stage, all mobile individuals have a method running in order to make them evolve on the Map.
- [ ] The order of manipulation of individuals is calculated randomly.
- [ ] The simulation ends when one of the masters has all the messages in the game.
- [ ] If after a fixed number of time steps, the game hasn't ended, It will be forced to end.
- [ ] If so, the winner should be determined by a specific.

### Code

- [ ] Polymorphism (method reacting to the class of the input).
- [ ] Static attribute.
- [ ] Singleton.
- [ ] Pseudo-random method.
- [ ] 

### 