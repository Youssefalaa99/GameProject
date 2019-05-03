import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Attr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xmlFile {

    private int temp;
    private String x;
    private List<ICrosser> rightBankCrosserslist;
    private List<ICrosser> leftBankCrosserslist;

    public void saveGame(State state){

        try {
            File inputFile = new File("./src//SavedGames.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("Player");

            for (temp = 0; temp < list.getLength(); temp++) {

                Node player=list.item(temp);
                NamedNodeMap attr = player.getAttributes();
                Node nodeAttr = attr.getNamedItem("UserName");
                if (state.getUserName().equals(nodeAttr.getTextContent())){
                    Node parent=player.getParentNode();
                    parent.removeChild(player);
                    break;
                }
            }

            Node players=doc.getFirstChild();
            Element player = doc.createElement("Player");
            players.appendChild(player);

            // setting attribute to element
            Attr attrUserName = doc.createAttribute("UserName");
            attrUserName.setValue(state.getUserName());
            player.setAttributeNode(attrUserName);

            Element level = doc.createElement("Level");
            if (state.getStrategy() instanceof LevelOne)
                level.appendChild(doc.createTextNode("Level 1"));
            else if (state.getStrategy() instanceof LevelTwo)
                level.appendChild(doc.createTextNode("Level 2"));
            player.appendChild(level);

            Element rightBankCrossers = doc.createElement("rightBankCrossers");
            rightBankCrosserslist=state.getRightBankCrossers();
            Iterator iterator = rightBankCrosserslist.iterator();
            Element Crosser;
            while(iterator.hasNext()) {
                ICrosser crosser=(ICrosser) iterator.next();
                if (crosser instanceof Farmer) {
                    x = Double.toString(crosser.getWeight());

                            Crosser = doc.createElement("crosser");
                    switch (x) {

                        case "0.0":
                            Crosser.appendChild(doc.createTextNode("Farmer"));
                            break;
                        case "90.0":
                            Crosser.appendChild(doc.createTextNode("Farmer1"));
                            break;
                        case "80.0":
                            Crosser.appendChild(doc.createTextNode("Farmer2"));
                            break;
                        case "60.0":
                            Crosser.appendChild(doc.createTextNode("Farmer3"));
                            break;
                        case "40.0":
                            Crosser.appendChild(doc.createTextNode("Farmer4"));
                            break;

                    }
                            rightBankCrossers.appendChild(Crosser);

                }

                else if(crosser instanceof Herbivorous) {
                    x = Double.toString(crosser.getWeight());
                    Crosser = doc.createElement("crosser");

                    switch (x) {
                        case "0.0":
                            Crosser.appendChild(doc.createTextNode("Herbivorous"));
                            break;
                        case "20.0":
                            Crosser.appendChild(doc.createTextNode("Herbivorous2"));
                            break;


                    }
                    rightBankCrossers.appendChild(Crosser);
                }
                 else{

                Crosser = doc.createElement("crosser");
                Crosser.appendChild(doc.createTextNode(crosser.getClass().toString().substring(6)));
                rightBankCrossers.appendChild(Crosser);
                    }



            }
            player.appendChild(rightBankCrossers);

            Element leftBankCrossers = doc.createElement("leftBankCrossers");
            leftBankCrosserslist=state.getLeftBankCrossers();
            Iterator iterator2 = leftBankCrosserslist.iterator();
            while(iterator2.hasNext()) {
                    ICrosser crosser=(ICrosser) iterator2.next();
                    if (crosser instanceof Farmer) {
                        x = Double.toString(crosser.getWeight());

                        Crosser = doc.createElement("crosser");
                        switch (x) {

                            case "0.0":
                                Crosser.appendChild(doc.createTextNode("Farmer"));
                                break;
                            case "90.0":
                                Crosser.appendChild(doc.createTextNode("Farmer1"));
                                break;
                            case "80.0":
                                Crosser.appendChild(doc.createTextNode("Farmer2"));
                                break;
                            case "60.0":
                                Crosser.appendChild(doc.createTextNode("Farmer3"));
                                break;
                            case "40.0":
                                Crosser.appendChild(doc.createTextNode("Farmer4"));
                                break;

                        }
                        leftBankCrossers.appendChild(Crosser);

                    }

                    else if(crosser instanceof Herbivorous) {
                        x = Double.toString(crosser.getWeight());
                        Crosser = doc.createElement("crosser");

                        switch (x) {
                            case "0.0":
                                Crosser.appendChild(doc.createTextNode("Herbivorous"));
                                break;
                            case "20.0":
                                Crosser.appendChild(doc.createTextNode("Herbivorous2"));
                                break;


                        }
                        leftBankCrossers.appendChild(Crosser);
                    }
                    else{

                        Crosser = doc.createElement("crosser");
                        Crosser.appendChild(doc.createTextNode(crosser.getClass().toString().substring(6)));
                        leftBankCrossers.appendChild(Crosser);
                    }



                }
                player.appendChild(leftBankCrossers);


            Element score = doc.createElement("Score");
            score.appendChild(doc.createTextNode(Integer.toString(state.getNumberOfMoves())));
            player.appendChild(score);

            Element boatPosition = doc.createElement("boatPosition");
            if ((state.getIsBoatOnTheLeftBank()))
                boatPosition.appendChild(doc.createTextNode("Left"));
            else
                boatPosition.appendChild(doc.createTextNode("Right"));
            player.appendChild(boatPosition);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            System.out.println("-----------Modified File-----------");
            StreamResult consoleResult = new StreamResult(inputFile);
            transformer.transform(source, consoleResult);
            }

        catch (Exception e){
            e.printStackTrace();
        }



        //Append to file
    }

    //Needs parameters to identify which state to load
    public State loadGame(String name){
        CrosserFactory factory=new CrosserFactory();
        State state = new State();
        List<ICrosser> rightList=new ArrayList<>();
        List<ICrosser> leftList=new ArrayList<>();
        ICrosser crosser = null;

        try{

        File inputFile = new File("./src//SavedGames.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("Player");
            ////////////////////////
            for (temp = 0; temp < list.getLength(); temp++) {

                Node player=list.item(temp);
                NamedNodeMap attr = player.getAttributes();
                Node nodeAttr = attr.getNamedItem("UserName");
                if (name.equals(nodeAttr.getNodeValue())){

                    NodeList loadElements=player.getChildNodes();
                    System.out.println(loadElements.item(0).getTextContent());
                    if (loadElements.item(0).getTextContent().equals("Level 1")){
                        LevelOne one = new LevelOne();
                        state.setStrategy(one);
                    }
                    else
                    {
                        LevelTwo two=new LevelTwo();
                        state.setStrategy(two);
                    }

                    NodeList rightElements=loadElements.item(1).getChildNodes();
                    for (temp = 0; temp < rightElements.getLength(); temp++) {
                        System.out.println(rightElements.item(temp).getTextContent());
                        switch (rightElements.item(temp).getTextContent()){
                            case "Farmer":
                                crosser=factory.createCrosseer("F1");
                                break;
                            case "Farmer1":
                                crosser=factory.createCrosseer("F1",90.0);
                                break;
                            case "Farmer2":
                                crosser=factory.createCrosseer("F2",80.0);
                                break;
                            case "Farmer3":
                                crosser=factory.createCrosseer("F3",60.0);
                                break;
                            case "Farmer4":
                                crosser=factory.createCrosseer("F4",40.0);
                                break;
                            case "Carnivorous":
                                crosser=factory.createCrosseer("C");
                                break;
                            case "Herbivorous2":
                                crosser=factory.createCrosseer("H",20.0);
                                break;
                            case "Herbivorous":
                                crosser=factory.createCrosseer("H");
                                break;

                            case "Plant":
                                crosser=factory.createCrosseer("P");
                                break;

                        }
                        rightList.add(crosser);

                    }


                    NodeList leftElements=loadElements.item(2).getChildNodes();
                    for (temp = 0; temp < leftElements.getLength(); temp++) {
                        switch (leftElements.item(temp).getTextContent()){
                                case "Farmer":
                                    crosser=factory.createCrosseer("F1");
                                    break;
                                case "Farmer1":
                                    crosser=factory.createCrosseer("F1",90.0);
                                    break;
                                case "Farmer2":
                                    crosser=factory.createCrosseer("F2",80.0);
                                    break;
                                case "Farmer3":
                                    crosser=factory.createCrosseer("F3",60.0);
                                    break;
                                case "Farmer4":
                                    crosser=factory.createCrosseer("F4",40.0);
                                    break;
                                case "Carnivorous":
                                    crosser=factory.createCrosseer("C");
                                    break;
                                case "Herbivorous2":
                                    crosser=factory.createCrosseer("H",20.0);
                                    break;
                                case "Herbivorous":
                                    crosser=factory.createCrosseer("H");
                                    break;

                                case "Plant":
                                    crosser=factory.createCrosseer("P");
                                    break;

                            }
                            leftList.add(crosser);

                    }



                      state.setNumberOfMoves(Integer.parseInt(loadElements.item(3).getTextContent()));
                    if (loadElements.item(4).getTextContent().equals("Left"))
                        state.setBoatOnTheLeftBank(true);
                    else
                        state.setBoatOnTheLeftBank(false);


                    break;
                }
            }

        }

        catch (Exception e){
            e.printStackTrace();
        }
        state.setLeftBankCrossers(leftList);
        state.setRightBankCrossers(rightList);
        System.out.println(state.toString());
        return state;
    }
    }

