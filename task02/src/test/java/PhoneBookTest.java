import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by pyankov on 30.09.2019.
 */
public class PhoneBookTest {
    @Test
    public void findFio() throws Exception {
        PhoneBook phoneBook = new PhoneBook();
        ArrayList<String> expected = new ArrayList(Arrays.asList("1. +8 800 2000 500", "2. +8 800 2000 600"));
        ArrayList<String> actual = phoneBook.findFio("Иванов И.И.");
        Assert.assertEquals(expected, actual);
    }

}