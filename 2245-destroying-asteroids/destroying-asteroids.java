class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n = asteroids.length;
        Arrays.sort(asteroids);
        if(asteroids[n-1] <= mass) return true;
        long sum = mass;
        for(int i=0;i<n;i++){
            if(asteroids[i] > sum) return false;
            sum += asteroids[i];
        }
        return true;
    }
}