import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class gui extends Application{
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Button btn2 = new Button();
        Button btn3 = new Button();
        Button btn4 = new Button();
        Button btn5 = new Button();
        Button btn6 = new Button();

        btn.setText("News");
        btn2.setText("Music");
        btn3.setText("Books");
        btn4.setText("Morning Edition");
        btn5.setText("Arts & Life");
        btn6.setText("Blacklist");

        btn.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);
        btn4.setMaxWidth(Double.MAX_VALUE);
        btn5.setMaxWidth(Double.MAX_VALUE);
        btn6.setMaxWidth(Double.MAX_VALUE);

        Label lbl =  new Label("");
        RSSParser newsFeed = new RSSParser("http://www.npr.org/rss/rss.php?id=1001");
        RSSParser musicFeed = new RSSParser("http://www.npr.org/rss/rss.php?id=1039");
        RSSParser booksFeed = new RSSParser("http://www.npr.org/rss/rss.php?id=1032");
        RSSParser morningeditionFeed = new RSSParser("http://www.npr.org/rss/rss.php?id=3");
        RSSParser artslifeFeed = new RSSParser("http://www.npr.org/rss/rss.php?id=1008");
        newsFeed.parseFeed();
        musicFeed.parseFeed();
        booksFeed.parseFeed();
        morningeditionFeed.parseFeed();
        artslifeFeed.parseFeed();
        ArrayList<FeedItems> parsedNewsItems = newsFeed.parsedItems;
        ArrayList<FeedItems> parsedMusicItems = musicFeed.parsedItems;
        ArrayList<FeedItems> parsedBooksItems = booksFeed.parsedItems;
        ArrayList<FeedItems> parsedMEItems = morningeditionFeed.parsedItems;
        ArrayList<FeedItems> parsedArtsLifeItems = artslifeFeed.parsedItems;

        GridPane root = new GridPane();
        root.setAlignment(Pos.TOP_LEFT);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(root, 750, 500);
        primaryStage.setScene(scene);
        root.add(lbl, 1, 1);
        root.add(btn, 0, 2);
        root.add(btn2, 0, 4);
        root.add(btn3, 0, 6);
        root.add(btn4, 0, 8);
        root.add(btn5, 0, 10);
        root.add(btn6, 0, 12);

        final TextArea textArea = TextAreaBuilder.create()
                .prefWidth(400)
                .prefHeight(1000)
                .wrapText(true)
                .build();

        final TextArea WordFreq = TextAreaBuilder.create()
                .prefWidth(200)
                .prefHeight(270)
                .wrapText(true)
                .build();

        Text RSSNewsFeedlabel = new Text(10,50, "RSS News Feeds:");
        RSSNewsFeedlabel.setFont(new Font(20));
        Text RSSTitleDescriptionlabel = new Text(10,50, "Titles/Description:");
        RSSTitleDescriptionlabel.setFont(new Font(20));
        Text WordFrequency = new Text(10,50, "Word/Word Count:");
        WordFrequency.setFont(new Font(20));

        root.add(textArea, 10, 2, 1, 15);
        root.add(WordFreq, 0, 16);
        root.add(RSSNewsFeedlabel,0,1);
        root.add(RSSTitleDescriptionlabel,10,1);
        root.add(WordFrequency,0,15);

        primaryStage.setTitle("NPR Feeds");
        primaryStage.setScene(scene);
        primaryStage.show();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                for(FeedItems feedItem : parsedNewsItems){
                    textArea.appendText(feedItem.toString());
                    textArea.appendText("\n");
                }
                WordFreq.clear();
                for(FeedItems feedItem : parsedNewsItems){
                    String description = feedItem.getDescription();
                    Frequency freq = new Frequency(description);
                    WordFreq.appendText(freq.Output());
                    WordFreq.appendText("\n");
                }
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                for(FeedItems feedItem : parsedMusicItems){
                    textArea.appendText(feedItem.toString());
                    textArea.appendText("\n");
                }
                WordFreq.clear();
                for(FeedItems feedItem : parsedMusicItems){
                    String description = feedItem.getDescription();
                    Frequency freq = new Frequency(description);
                    WordFreq.appendText(freq.Output());
                    WordFreq.appendText("\n");
                }
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                for(FeedItems feedItem : parsedBooksItems){
                    textArea.appendText(feedItem.toString());
                    textArea.appendText("\n");
                }
                WordFreq.clear();
                for(FeedItems feedItem : parsedBooksItems){
                    String description = feedItem.getDescription();
                    Frequency freq = new Frequency(description);
                    WordFreq.appendText(freq.Output());
                    WordFreq.appendText("\n");
                }
            }
        });

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                for(FeedItems feedItem : parsedMEItems){
                    textArea.appendText(feedItem.toString());
                    textArea.appendText("\n");
                }
                WordFreq.clear();
                for(FeedItems feedItem : parsedMEItems){
                    String description = feedItem.getDescription();
                    Frequency freq = new Frequency(description);
                    WordFreq.appendText(freq.Output());
                    WordFreq.appendText("\n");
                }
            }
        });

        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                for(FeedItems feedItem : parsedArtsLifeItems){
                    textArea.appendText(feedItem.toString());
                    textArea.appendText("\n");
                }
                WordFreq.clear();
                for(FeedItems feedItem : parsedArtsLifeItems){
                    String description = feedItem.getDescription();
                    Frequency freq = new Frequency(description);
                    WordFreq.appendText(freq.Output());
                    WordFreq.appendText("\n");
                }
            }
        });


        btn6.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage blacklist = new Stage();
                blacklistStage(blacklist);
            }
        });

    }

    private void blacklistStage(Stage blacklist) {
        BlacklistAnalyzer blAnalyzer = new BlacklistAnalyzer();
        GridPane root = new GridPane();
        root.setAlignment(Pos.TOP_LEFT);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(root, 575, 500);
        blacklist.setScene(scene);
        blacklist.setTitle("Blacklisted Words");
        Button addToBlacklist = new Button();
        addToBlacklist.setText("Add to Blacklist");
        root.add(addToBlacklist,0,0);
        final TextArea textArea = TextAreaBuilder.create()
                .prefWidth(400)
                .prefHeight(540)
                .wrapText(true)
                .build();



        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textArea);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefWidth(400);
        scrollPane.setPrefHeight(540);
        try {
            blAnalyzer.analyzeBlacklist();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textArea.appendText(blAnalyzer.blacklistedWords);
        textArea.setWrapText(true);
        root.add(scrollPane,1,0);

        blacklist.show();

        addToBlacklist.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String changedBlacklist = textArea.getText();
                blAnalyzer.saveBlacklist(changedBlacklist);
                blacklist.close();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}

