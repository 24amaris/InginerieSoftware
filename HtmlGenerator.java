package htmlgenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HtmlGenerator {

    public static void main(String[] args) {
        // Creăm tag-urile HTML
        HtmlElement html = new HtmlElement("html");
        HtmlElement head = new HtmlElement("head");
        HtmlElement body = new HtmlElement("body");

        HtmlElement title = new HtmlElement("title");
        title.setContent("Exemplu HTML dinamic");

        HtmlElement h1 = new HtmlElement("h1");
        h1.setContent("Salut, lume!");

        HtmlElement p = new HtmlElement("p");
        p.setContent("Acesta este un paragraf cu text <b>bold</b>.");

        HtmlSelfClosingTag img = new HtmlSelfClosingTag("img");
        img.setContent("src=\"imagine.jpg\" alt=\"imagine\"");

        // Adăugăm sub-taguri
        head.addSubTag(title);
        body.addSubTag(h1);
        body.addSubTag(p);
        body.addSubTag(img);

        // Adăugăm head și body în tag-ul html
        html.addSubTag(head);
        html.addSubTag(body);

        // Exportăm în fișier HTML
        String htmlContent = html.toHtml(0);
        exportToHtml(htmlContent);
    }

    public static void exportToHtml(String htmlContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("index.html"))) {
            writer.write("<!DOCTYPE html>\n");
            writer.write(htmlContent);
        } catch (IOException e) {
            System.out.println("Eroare la export: " + e.getMessage());
        }
    }
}
