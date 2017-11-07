class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if(n == 0) return -1;
        int sum = 0, tank = 0, start = 0;
        for(int i = 0; i < n; i++) {
        	tank += gas[i] - cost[i];
            if(tank< 0){
                start = i + 1;
                sum += tank;
                tank = 0;
            }
        }
        return sum + tank < 0 ? -1 : start;
    }
    
    
    /*
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if(n == 0) return -1;
        if(n == 1) return gas[0] >= cost[0] ? 0 : -1;
        
        for(int i = 0; i < n; i++){
            int prev = i == 0 ? n - 1 : i - 1;
            if(gas[i] <= cost[i] || gas[prev] >= cost[prev]) continue;
            int cur = i;
            int sum = 0;
            for(int k = 0; k < n; k++) {
                sum += gas[cur];
                if(sum < cost[cur]) break;
                sum -= cost[cur];
                cur = (i + 1) % n;
            }
            if(n == 0) return cur;
        }
        return -1;
    }
    */
}