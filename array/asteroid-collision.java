class Solution {
    public boolean isCollision(int a, int b) {
        return  a > 0 && b <0;
    }
    public int abs(int n) {
        return Math.abs(n);
    }
    public int[] asteroidCollision(int[] asteroids) {
        int top = -1, n = asteroids.length; boolean isAlive;
        int stack[] = new int[n];
        for(int i = 0; i < n; i++) {
            while(top!= -1 && isCollision(asteroids[stack[top]], asteroids[i]) 
                    && abs(asteroids[i]) > abs(asteroids[stack[top]])) {
                top--;
            }
            if(top != -1) {
                if(!isCollision(asteroids[stack[top]], asteroids[i]))
                    stack[++top] = i;
                else if(abs(asteroids[i]) == abs(asteroids[stack[top]]))
                    top--;
            } else {
                stack[++top] = i;;
            }

        }
        int[] res = new int[top+1];
        while(top >= 0) 
            res[top] = asteroids[stack[top--]];
        return res;
    }
}