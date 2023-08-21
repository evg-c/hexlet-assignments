package exercise;

//import java.util.HashMap;
import java.util.Map;

// BEGIN
public class Tag {
    private String nameTag;
    private Map<String, String> attributesTag;

    public Tag(String name, Map<String, String> attributes) {
        String nameForTag = name;
        this.nameTag = nameForTag;
//        Map<String, String> attrForTag = new HashMap<>();
//        attrForTag.putAll(attributes);
//        this.attributesTag = attrForTag;
        this.attributesTag = attributes;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameT) {
        this.nameTag = nameT;
    }

    public Map<String, String> getAttributesTag() {
        return attributesTag;
    }

    public void setAttributesTag(Map<String, String> attributesT) {
        this.attributesTag = attributesT;
    }

    @Override
    public String toString() {
        //return "<" + nameTag + " " + attributesTag.toString() + ">";
        return "<" + getNameTag() + attributesTagToString(getAttributesTag()) + ">";
    }

    public String attributesTagToString(Map<String, String> attrs) {
        StringBuilder attrStr = new StringBuilder();
        for (Map.Entry<String, String> oneAttr: attrs.entrySet()) {
            attrStr.append(" " + oneAttr.getKey() + "=\"" + oneAttr.getValue() + "\"");
        }
        return attrStr.toString();
    }
}
// END
