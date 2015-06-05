"""
    * Ideas:
    * Use Dynamic Programming,
    * for each step, the stair could ether combine with the previous one or as a single step.
    * Ways to climb to ith stair is W(i) = W(i-1) + W(i-2)
    * where W(i-1) is when the ith stair is as a single step
    * and W(i-2) is when the ith stair is paired with the previous one.
"""
class Solution:
    # @param n, an integer
    # @return an integer
    def climbStairs(self, n):
        tmp = [0] * n;
        
        if n < 2:
            return 1;
            
        tmp[0] = 1;
        tmp[1] = 2;
        
        for i in range(2, n):
		tmp[i] = tmp[i-1] + tmp[i-2];
            
        return tmp[n-1];

slu = Solution();
print slu.climbStairs(3);
