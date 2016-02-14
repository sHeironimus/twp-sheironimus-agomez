import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class RSSParser {

    public ArrayList<FeedItems> parsedItems = new ArrayList<>();
    public String url = null;

    public RSSParser(String u) {
        this.url = u;
    }

    public void parseFeed(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(url);
            document.getDocumentElement().normalize();
            NodeList items = document.getElementsByTagName("item");
            for (int i = 0; i < items.getLength(); i++) {
                FeedItems feedItems = new FeedItems();
                Node node = items.item(i);
                if (node.getNodeType() != Node.ELEMENT_NODE)
                    continue;
                Element element = (Element) node;

                NodeList titleList = element.getElementsByTagName("title");
                NodeList descriptionList = element.getElementsByTagName("description");
                Element titleElem = (Element) titleList.item(0);
                Element descriptionElem = (Element) descriptionList.item(0);

                String titleText = titleElem.getTextContent();
                String descriptionText = descriptionElem.getTextContent();
                if(titleText.contains("<em>")){
                    titleText = titleText.replace("<em>", "");
                    titleText = titleText.replace("</em>", "");
                }
                if(descriptionText.contains("<em>")){
                    descriptionText = descriptionText.replace("<em>", "");
                    descriptionText = descriptionText.replace("</em>", "");
                }
                feedItems.setTitle(titleText);
                feedItems.setDescription(descriptionText);
                parsedItems.add(feedItems);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}