package htmlgenerator;

import java.util.ArrayList;
import java.util.List;

abstract class HtmlTag {
    protected String tagName;
    protected List<HtmlTag> subTags = new ArrayList<>();
    protected String content = "";

    public HtmlTag(String tagName) {
        this.tagName = tagName;
    }

    public void addSubTag(HtmlTag subTag) {
        subTags.add(subTag);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public abstract String toHtml(int indentLevel);

    protected String getIndentation(int indentLevel) {
        return "  ".repeat(indentLevel);
    }
}
