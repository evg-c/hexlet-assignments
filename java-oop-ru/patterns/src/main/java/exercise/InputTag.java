package exercise;

// BEGIN
public final class InputTag implements TagInterface {

    private TagInterface input;
    private String type;
    private String value;

    public InputTag(String typeTag, String valueTag) {
        this.type = typeTag;
        this.value = valueTag;
    }
    @Override
    public String render() {
        return "<input type=\"" + this.type + "\" value=\"" + this.value + "\">";
    }
}
// END
