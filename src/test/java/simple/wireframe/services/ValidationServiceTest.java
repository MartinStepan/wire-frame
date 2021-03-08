package simple.wireframe.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ValidationServiceImpl.class)
public class ValidationServiceTest {

    @Autowired
    ValidationService validationService;

    @Test
    public void testOnlyLetterChars()
    {
        Assertions.assertEquals(validationService.validateAttrValueForLettersOnly("name", "value"), "");
    }

    @Test
    public void testNotOnlyLetterChars()
    {
        Assertions.assertNotEquals(validationService.validateAttrValueForLettersOnly("name", "value"), "");
    }

    @Test
    public void testOnlyAlphanumericChars()
    {
        Assertions.assertEquals(validationService.validateAttrValueForAlphanumericOnly("name", "value123"), "");
    }

    @Test
    public void testNotOnlyAlphanumericChars()
    {
        Assertions.assertNotEquals(validationService.validateAttrValueForAlphanumericOnly("name", "value123"), "");
    }
}
