package exercise;

//import java.util.ArrayList;
import java.util.Map;
import java.util.List;
//import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private String bodyTag;
    private List<Tag> childTag;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.bodyTag = body;
//        List<Tag> listChildren = new ArrayList<>();
//        listChildren.addAll(children);
//        this.childTag = listChildren;
        this.childTag = children;
    }

    public String getBodyTag() {
        return bodyTag;
    }

    public void setBodyTag(String bodyT) {
        this.bodyTag = bodyT;
    }

    public List<Tag> getChildTag() {
        return childTag;
    }

    public void setChildTag(List<Tag> childT) {
        this.childTag = childT;
    }

    @Override
    public String toString() {
        return super.toString() + getBodyTag() + listToString(getChildTag()) + "</" + super.getNameTag() + ">";
    }

    public String listToString(List<Tag> children) {
//        return childTag.stream()
//                .collect(Collectors.toList()).toString();
        StringBuilder allTag = new StringBuilder();
        for (Tag oneTag: children) {
            allTag.append(oneTag.toString());
        }
        return allTag.toString();
    }
}
// END
