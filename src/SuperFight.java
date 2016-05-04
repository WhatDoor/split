import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sebastian on 14/12/2015.
 */
public class SuperFight extends Application{
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> traits = new ArrayList();
    ArrayList<String> locations = new ArrayList();
    Random random = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    Text name1;
    Text traita;
    Text traitb;
    Text location;
    Text name2;
    Text trait1;
    Text trait2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            BufferedReader nameReader = new BufferedReader(new FileReader("names.txt"));
            String name;

            while((name = nameReader.readLine()) != null) {
                System.out.println(name);
                names.add(name);
            }

            nameReader.close();

            BufferedReader traitReader = new BufferedReader(new FileReader("trait.txt"));
            String trait;

            while((trait = traitReader.readLine()) != null) {
                System.out.println(trait);
                traits.add(trait);
            }

            traitReader.close();

            BufferedReader locationReader = new BufferedReader(new FileReader("location.txt"));
            String location;

            while((location = locationReader.readLine()) != null) {
                System.out.println(location);
                locations.add(location);
            }

            locationReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setHgap(20);
        layout.setVgap(10);

        Button roll1 = new Button("Reroll!");
        roll1.setOnMouseClicked(e -> {
            roll1();
        });
        GridPane.setConstraints(roll1, 0, 0);
        name1 = new Text("name1");
        name1.setFont(Font.font(20));
        GridPane.setConstraints(name1, 1, 0);
        traita = new Text("traita");
        traita.setFont(Font.font(20));
        GridPane.setConstraints(traita, 2, 0);
        traitb = new Text("traitb");
        traitb.setFont(Font.font(20));
        GridPane.setConstraints(traitb,3,0);

        Button roll = new Button("Roll!");
        roll.setOnMouseClicked(e -> {
            rerollAll();
        });
        GridPane.setConstraints(roll, 0, 1);
        Text vs = new Text("VS");
        vs.setFont(Font.font(25));
        vs.setFill(Color.RED);
        GridPane.setConstraints(vs, 1, 1);
        location = new Text("location");
        location.setFont(Font.font(25));
        GridPane.setConstraints(location,2,1);

        Button roll2 = new Button("Reroll!");
        roll2.setOnMouseClicked(e -> {
            roll2();
        });
        GridPane.setConstraints(roll2,0,2);
        name2 = new Text("name1");
        name2.setFont(Font.font(20));
        GridPane.setConstraints(name2, 1, 2);
        trait1 = new Text("trait1");
        trait1.setFont(Font.font(20));
        GridPane.setConstraints(trait1, 2, 2);
        trait2 = new Text("trait2");
        trait2.setFont(Font.font(20));
        GridPane.setConstraints(trait2, 3, 2);

        layout.getChildren().addAll(roll1, name1, traita, traitb, roll, vs, location, roll2, name2, trait1, trait2);
        layout.setMinWidth(600);

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
        //primaryStage.setResizable(false);

        rerollAll();
    }

    private void rerollAll() {
        name1.setText(names.get(random.nextInt(names.size())));
        name2.setText(names.get(random.nextInt(names.size())));

        trait1.setText(traits.get(random.nextInt(traits.size())));
        trait2.setText(traits.get(random.nextInt(traits.size())));
        traita.setText(traits.get(random.nextInt(traits.size())));
        traitb.setText(traits.get(random.nextInt(traits.size())));

        location.setText(locations.get(random.nextInt(locations.size())));
    }

    private void roll1() {
        name1.setText(names.get(random.nextInt(names.size())));
        traita.setText(traits.get(random.nextInt(traits.size())));
        traitb.setText(traits.get(random.nextInt(traits.size())));
    }

    private void roll2() {
        name2.setText(names.get(random.nextInt(names.size())));
        trait1.setText(traits.get(random.nextInt(traits.size())));
        trait2.setText(traits.get(random.nextInt(traits.size())));
    }
}
