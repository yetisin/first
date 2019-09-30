import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by pyankov on 30.09.2019.
 */
public class SolutionTest {
    @Test
    public void checkAndParseIP() throws Exception {
        ArrayList<Integer> expected = new ArrayList(Arrays.asList(1,1,1,1));
        ArrayList<Integer> actual = Solution.checkAndParseIP("1.1.1.1");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findScopeIP() throws Exception {
        ArrayList<Integer> start = new ArrayList(Arrays.asList(1,1,1,1));
        ArrayList<Integer> end = new ArrayList(Arrays.asList(1,1,1,3));
        Assert.assertEquals(1, Solution.findScopeIP(start,end).size());

        start = new ArrayList(Arrays.asList(1,1,1,1));
        end = new ArrayList(Arrays.asList(1,1,1,2));
        Assert.assertEquals(0, Solution.findScopeIP(start,end).size());

        start = new ArrayList(Arrays.asList(1,1,1,1));
        end = new ArrayList(Arrays.asList(1,1,1,1));
        Assert.assertEquals(0, Solution.findScopeIP(start,end).size());

        start = new ArrayList(Arrays.asList(1,1,1,5));
        end = new ArrayList(Arrays.asList(1,1,1,1));
        Assert.assertEquals(0, Solution.findScopeIP(start,end).size());

        start = new ArrayList(Arrays.asList(1,1,1,5));
        end = new ArrayList(Arrays.asList(1,1,2,3));
        Assert.assertEquals(253, Solution.findScopeIP(start,end).size());
    }

}