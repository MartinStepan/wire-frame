package simple.wireframe.services;

public interface ValidationService {

    /**
     * Validate if string contains only letter chars
     * @param attributeName
     * @param attributeValue
     * @return empty string if true, otherwise error message
     */
    String validateAttrValueForLettersOnly(String attributeName, String attributeValue);

    /**
     * Validate if string contains only alphanumeric chars
     * @param attributeName
     * @param attributeValue
     * @return empty string if true, otherwise error message
     */
    String validateAttrValueForAlphanumericOnly(String attributeName, String attributeValue);
}
