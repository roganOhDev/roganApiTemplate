import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
class RoganApiTemplateApplicationTests extends BaseTest {

    @TestFactory
    Collection<DynamicNode> contextLoads() {
        return group(
                single("test", () -> System.out.println("asdfads"))
        );
    }

}
