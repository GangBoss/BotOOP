import com.fasterxml.jackson.annotation.JsonTypeInfo;
import core.User;
import data.user.UserDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest
{
    private UserDatabase database;

    @Before
    public void setUp()
    {
        database = new UserDatabase();
    }

    @Test
    public void addOneBaseConsoleUser()
    {
        var consoleUser = new User<>("TestUser", "console");
        database.addUser(consoleUser);
        Assert.assertTrue(database.hasUser(consoleUser));
    }

    @Test
    public void AddTwoDifferentBaseConsoleUser()
    {
        var consoleUser = new User<>("TestUser", "console");
        var consoleUserTwo = new User<>("TestUser2", "console");
        database.addUser(consoleUser);
        database.addUser(consoleUserTwo);
        Assert.assertTrue(database.hasUser(consoleUser));
        Assert.assertTrue(database.hasUser(consoleUserTwo));
    }

    @Test
    public void AddTwoEqualBaseConsoleUser()
    {
        var consoleUser = new User<>("TestUser", "console");
        var consoleUserTwo = new User<>("TestUser", "console");
        database.addUser(consoleUser);
        database.addUser(consoleUserTwo);
        Assert.assertTrue(database.hasUser(consoleUser));
        Assert.assertTrue(database.hasUser(consoleUserTwo));
    }

    @Test
    public void CheckNotAddedUser()
    {
        var consoleUser = new User<>("TestUser", "console");
        var consoleUserTwo = new User<>("TestUser2", "console");
        database.addUser(consoleUser);
        Assert.assertTrue(database.hasUser(consoleUser));
        Assert.assertFalse(database.hasUser(consoleUserTwo));
    }

    @Test
    public void AddUsersFromOtherPlatforms()
    {
        var consoleUser = new User<>("TestUser", "console");
        var telegramUser = new User<>(123, "telegram");
        database.addUser(consoleUser);
        database.addUser(telegramUser);
        Assert.assertTrue(database.hasUser(consoleUser));
        Assert.assertTrue(database.hasUser(telegramUser));
    }

    @Test
    public void RemoveExsistedUser()
    {
        var consoleUser = new User<>("TestUser", "console");
        database.addUser(consoleUser);
        database.removeUser(consoleUser);
        Assert.assertFalse(database.hasUser(consoleUser));
    }

    @Test
    public void RemoveNonExsistedUser()
    {
        var consoleUser = new User<>("TestUser", "console");
        try
        {
            database.removeUser(consoleUser);
        } catch (Exception ignored)
        {
            return;
        }
        Assert.fail("Remove user should throw error when user not existed in database");
    }

    @Test
    public void GetExsistedUser()
    {
        var consoleUser = new User<>("TestUser", "console");
        database.addUser(consoleUser);
        Assert.assertEquals(consoleUser, database.getUser(consoleUser));
    }

    @Test
    public void GetNonExistedPlatform()
    {
        var consoleUser = new User<>("TestUser", "console");
        Assert.assertNull(database.getUser(consoleUser));
    }

    @Test
    public void GetNonExistedUser()
    {
        var consoleUser = new User<>("TestUser", "console");
        var consoleUserTwo = new User<>("TestUser2", "console");
        database.addUser(consoleUser);
        Assert.assertNull(database.getUser(consoleUserTwo));
    }

    @Test
    public void AddTwoUsersWithEqualPlatformButDifferentIdTypes()
    {
        var consoleUser = new User<>("TestUser", "console");
        var consoleUserTwo = new User<>(123, "console");
        database.addUser(consoleUser);
        database.addUser(consoleUserTwo);
        Assert.assertTrue(database.hasUser(consoleUser));
        Assert.assertTrue(database.hasUser(consoleUserTwo));
    }
}