import core.PlatformType;
import core.User;
import data.user.UserDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseTest
{

    @Before
    public void SetUp(){
        UserDatabase.clear();
    }

    @Test
    public void addOneBaseConsoleUser()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        UserDatabase.addUser(consoleUser);
        Assert.assertTrue(UserDatabase.hasUser(consoleUser));
    }

    @Test
    public void AddTwoDifferentBaseConsoleUser()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        var consoleUserTwo = new User<>("TestUser2", PlatformType.Console);
        UserDatabase.addUser(consoleUser);
        UserDatabase.addUser(consoleUserTwo);
        Assert.assertTrue(UserDatabase.hasUser(consoleUser));
        Assert.assertTrue(UserDatabase.hasUser(consoleUserTwo));
    }

    @Test
    public void AddTwoEqualBaseConsoleUser()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        var consoleUserTwo = new User<>("TestUser", PlatformType.Console);
        UserDatabase.addUser(consoleUser);
        UserDatabase.addUser(consoleUserTwo);
        Assert.assertTrue(UserDatabase.hasUser(consoleUser));
        Assert.assertTrue(UserDatabase.hasUser(consoleUserTwo));
    }

    @Test
    public void CheckNotAddedUser()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        var consoleUserTwo = new User<>("TestUser2", PlatformType.Console);
        UserDatabase.addUser(consoleUser);
        Assert.assertTrue(UserDatabase.hasUser(consoleUser));
        Assert.assertFalse(UserDatabase.hasUser(consoleUserTwo));
    }

    @Test
    public void AddUsersFromOtherPlatforms()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        var telegramUser = new User<>(123, PlatformType.Telegram);
        UserDatabase.addUser(consoleUser);
        UserDatabase.addUser(telegramUser);
        Assert.assertTrue(UserDatabase.hasUser(consoleUser));
        Assert.assertTrue(UserDatabase.hasUser(telegramUser));
    }

    @Test
    public void RemoveExistedUser()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        UserDatabase.addUser(consoleUser);
        UserDatabase.removeUser(consoleUser);
        Assert.assertFalse(UserDatabase.hasUser(consoleUser));
    }

    @Test
    public void RemoveNonExistedUser()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        try
        {
            UserDatabase.removeUser(consoleUser);
        } catch (Exception ignored)
        {
            return;
        }
        Assert.fail("Remove user should throw error when user not existed in database");
    }

    @Test
    public void GetExistedUser()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        UserDatabase.addUser(consoleUser);
        Assert.assertEquals(consoleUser, UserDatabase.getUser(consoleUser));
    }

    @Test
    public void GetNonExistedPlatform()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        Assert.assertNull(UserDatabase.getUser(consoleUser));
    }

    @Test
    public void GetNonExistedUser()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        var consoleUserTwo = new User<>("TestUser2", PlatformType.Console);
        UserDatabase.addUser(consoleUser);
        Assert.assertNull(UserDatabase.getUser(consoleUserTwo));
    }

    @Test
    public void AddTwoUsersWithEqualPlatformButDifferentIdTypes()
    {
        var consoleUser = new User<>("TestUser", PlatformType.Console);
        var consoleUserTwo = new User<>(123, PlatformType.Console);
        UserDatabase.addUser(consoleUser);
        UserDatabase.addUser(consoleUserTwo);
        Assert.assertTrue(UserDatabase.hasUser(consoleUser));
        Assert.assertTrue(UserDatabase.hasUser(consoleUserTwo));
    }
}
