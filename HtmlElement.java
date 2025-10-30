package htmlgenerator;

class HtmlElement extends HtmlTag {

    public HtmlElement(String tagName) {
        super(tagName);
    }

    @Override
    public String toHtml(int indentLevel) {
        StringBuilder html = new StringBuilder();
        html.append(getIndentation(indentLevel)).append("<").append(tagName).append(">");
        if (!content.isEmpty()) {
            html.append(content);
        }
        for (HtmlTag subTag : subTags) {
            html.append("\n").append(subTag.toHtml(indentLevel + 1));
        }
        html.append("\n").append(getIndentation(indentLevel)).append("</").append(tagName).append(">");
        return html.toString();
    }
}
