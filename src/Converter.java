import com.sun.tools.javac.Main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Converter
{
    String firstPackage = System.getProperty("user.dir") + "\\BotOOP\\src\\txt\\question base.txt";

    public ArrayList<Question> getQuestions(String path) throws Exception
    {
        {
            var quests = new ArrayList<Question>();
            var count = 0;
            for (String line : Files.readAllLines(Paths.get(path)))
            {
                count++;
                quests.add(new Question(count, line.split("\\|")));
            }
            return quests;
        }
    }

    public ArrayList<Question> getQuestions() throws Exception
    {
        return getQuestions(firstPackage);
    }
}
