public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int index = 0;
		int tank = 0;
		int totalGas = 0;
		int totalCost = 0;

		for (int i=0; i<gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
			tank = tank + gas[i] - cost[i];
			if (tank < 0) {
				tank = 0;
				index = i+1;
			}
		}

		return totalCost > totalGas ? -1 : index;


	}



}