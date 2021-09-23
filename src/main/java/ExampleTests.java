import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ExampleTests extends ExamplePages {
    public ExampleTests() throws IOException {
    }

    ExamplePages examplePages = new ExamplePages();

    @Before
    public void pFactory() {
        PageFactory.initElements(driver, examplePages);
    }

    @Test
    public void orderVacuumCleaner_1() throws IOException {
        examplePages.orderVacuumCleaner();
    }

}
