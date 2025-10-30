package htmlgenerator;

class HtmlSelfClosingTag extends HtmlTag {

    public HtmlSelfClosingTag(String tagName) {
        super(tagName);
    }

    @Override
    public String toHtml(int indentLevel) {
        return getIndentation(indentLevel) + "<" + tagName + " />";
    }
}
