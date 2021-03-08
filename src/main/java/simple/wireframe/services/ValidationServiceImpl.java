package simple.wireframe.services;

import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    private boolean onlyLetterChars(String s) {
        return s.matches("^[a-zA-Z]+$");
    }

    private boolean onlyAlphaNumericChars(String s) {
        return s.matches("^[a-zA-Z0-9]+$");
    }

    @Override
    public String validateAttrValueForLettersOnly(String attributeName, String attributeValue) {
        if(onlyLetterChars(attributeValue)) {
            return "";
        } else {
            return attributeName + " don´t contains only letter chars";
        }
    }

    @Override
    public String validateAttrValueForAlphanumericOnly(String attributeName, String attributeValue) {
        if(onlyAlphaNumericChars(attributeValue)) {
            return "";
        } else {
            return attributeName + " don´t contains only alphanumeric chars";
        }
    }
}
