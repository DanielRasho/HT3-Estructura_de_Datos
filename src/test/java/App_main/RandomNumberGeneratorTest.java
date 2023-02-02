package App_main;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RandomNumberGeneratorTest{

    @Test
    public void WriteFile() {
        RandomNumberGenerator.writeFile("./src/owo.txt", 20, 20);
    }

    @Test
    public void ReadFile(){
        int desiredEntities = 20;
        RandomNumberGenerator.writeFile("./src/owo.txt", 20, desiredEntities);
        List<Integer> entities = RandomNumberGenerator.readFile("./src/owo.txt");
        assertEquals(desiredEntities, entities.size());
    }
}