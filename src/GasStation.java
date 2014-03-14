/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation {
    public static void main(String []args){
        int []gas = {1,2,3,3};
        int []cost = {2,1,5,1};
        GasStation gasStation = new GasStation();
        gasStation.canCompleteCircuit(gas, cost);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int restGas = 0;
        int startIndex = 0, runtimeIndex = 0;
        for(int i = 0; i < gas.length; i++){
            restGas += gas[i]-cost[i];
        }
        if(restGas < 0)
            return -1;
        restGas = 0;
        while(true){
            if(restGas + gas[runtimeIndex] - cost[runtimeIndex] >= 0){
                restGas = restGas + gas[runtimeIndex] - cost[runtimeIndex];
                runtimeIndex = (runtimeIndex + 1) % gas.length;
                if(runtimeIndex == startIndex)
                    break;
            }else{
                restGas = restGas - gas[startIndex] + cost[startIndex];
                if(startIndex == runtimeIndex){
                    runtimeIndex = (runtimeIndex + 1) % gas.length;
                    restGas = 0;
                }
                startIndex = (startIndex + 1) % gas.length;
            }
        }
        return startIndex;
    }
}
