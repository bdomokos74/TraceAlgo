#### TraceAlgo

TraceAlgo is an educational tool to visualize the working of algorithms. The backend provides a
web API to run the algorithm with specific input parameters. While running the algorithm, it takes snapshots
of the state at each step. The steps are returned as a JSON string. The the UI reads the input data,
calls the algorithm, and let you go step by step, or step back and forth between the states recorded at each step.

Build the Java backend this way: `mvn package`

Run like this: `java -jar target/TraceAlgo-1.0.0.jar`

Then browse to [http://localhost:8080/mergesort?input=4,3,2,1,6,7](http://localhost:8080/mergesort?input=4,3,2,1,6,7)
