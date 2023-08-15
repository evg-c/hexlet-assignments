package exercise;

// BEGIN
public final class LabelTag implements TagInterface {

    private TagInterface label;
    private String tagTextValue;
    private TagInterface childTag;

    public LabelTag(String tagText, TagInterface child) {
        this.tagTextValue = tagText;
        this.childTag = child;
    }
    @Override
    public String render() {
        return "<label>" + tagTextValue + childTag.render() + "</label>";
    }
}
// END
