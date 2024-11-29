import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[][] grid = {
                {0,1,3,2},
                {5,1,2,5},
                {4,3,8,6},
        };
        int expected = 7;
        int actual = new Solution().minimumTime(grid);

        Assert.assertEquals(expected, actual);
    }
}
