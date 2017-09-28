# Jumper 

Calculates the number of shortest paths from start location to end location.

For this we used theses concepts:

## Board
The board is an rectangle with N rows and N columns. All its squares are identical. Rows and columns are numbered from 1 to N. 

## Jumper
Jumper is a figure that can move from one board square to another. It's defined by a list of two-dimensional offsets specifying all possible moves.

```
[(1,2), (2,1), (1,-2), (2,-1), (-1,2), (-2,1), (-1,-2), (-2,-1)]
```

## Stones
Some board squares are occupied by stones and are unavailable. Jumper can jump over stones but cannot land on a stone.
Stone location is represented by its coordinates on the board. Any number of squares can be occupied by stones.

```
[(1,6), (2,6), (3,6), (4,6), (5,6), (1,5), (4,5)],
```

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

```
Java 8
Maven
```

### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

```
checkout project 
run mvn install
```

## Running the tests

Explain how to run the automated tests for this system

## Deployment

```
run mvn package
add the input.config file in the same level of the generated .jar file
```

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

