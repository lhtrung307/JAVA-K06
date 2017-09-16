package browser;


import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.media.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.beans.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.scene.web.*;
import javafx.util.Callback;
//Joe T. Nartca (C)
import java.io.*;
import java.net.*;
import java.util.*;
//
public class Webplorer extends Application {
    private static String home = "https://daynhauhoc.com";
    public static void main(String[] args) {
        // check for Proxy...
         // args[0]: HostName or IP= "xxx.xxx.xxx.xxx", args[1]: posrt, any number (up 1000)
        if (args.length == 2) {
            JoeProxy joe = new JoeProxy(args[0],Integer.parseInt(args[1]),Proxy.Type.HTTP);
            joe.setBlacklist("blacklist.txt");
            ProxySelector.setDefault(joe);
        }
        launch(args);
    }
    private TabPane tabs;
    private TextField tf;
    private ProgressBar pb;
    private SingleSelectionModel<Tab> selTab;
    public void start(Stage stage) {
        // create the scene
        stage.setTitle("Joe T. Nartca JFX Browser for DNH (c)");
//        stage.getIcons().add(new Image(Webplorer.class.getResourceAsStream("clover.jpg")));
        Label label = new Label("Site");
        tf = new TextField(home); //set text file = home URL
        tf.setOnAction(e -> {
            loadSite(tf.getText());  //load site tu URL cua text field
        });
        HBox hbox = new HBox(); 
        hbox.setSpacing(5);
        HBox.setHgrow(tf, Priority.ALWAYS);
        // insets(top-right-bottom-left)
        hbox.setPadding(new Insets(15, 10, 5, 10));
        hbox.getChildren().addAll(label, tf);
        tabs = new TabPane();       
        selTab = tabs.getSelectionModel();
        tabs.getTabs().add(aTab(home));
        pb = new ProgressBar();
        BorderPane bp = new BorderPane();        
        bp.setMargin(tabs, new Insets(12,12,12,12));
        // width-Height
        bp.setPrefSize(1000, 700);
        bp.setTop(hbox);
        bp.setCenter(tabs);
        bp.setBottom(pb);
        Group group = new Group( ); 
        group.getChildren( ).add(bp);
        Scene scene = new Scene(group, 1000, 700, Color.ANTIQUEWHITE);
        bp.prefHeightProperty().bind(scene.heightProperty());
        bp.prefWidthProperty().bind(scene.widthProperty());
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
        stage.setScene(scene);
        stage.show();
    }
    
    // create a new Tab
    private Tab aTab(String url) {
        Tab tab = new Tab();
        WebView wView = new WebView();
        WebEngine wNgine = wView.getEngine();
        tab.setText(url.indexOf("://") > 0 ? url.substring(url.indexOf("://")+3):url);
        wNgine.load(url.indexOf("://") > 0 ? url:"http://"+url);
        BorderPane bp = new BorderPane();
        bp.setCenter(wView);
        tab.setContent(bp);
        selTab.select(tab);
        return tab;
    }
    // new Site = new Tab
    public void loadSite(String url) {         
        Platform.runLater(new Runnable() {
             public void run() {
                 tabs.getTabs().add(aTab(url)); //Them mot tab moi vao trinh duyet
                 tf.requestFocus();
             }
        });
    }
}