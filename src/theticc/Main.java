package theticc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import theticc.*;

import java.util.ArrayList;
import java.util.Random;


public class Main extends Application {

    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    Button button_5;
    Button button_6;
    Button button_7;
    Button button_8;
    Button button_9;

    int ActivePayer = 1;

    ArrayList<Integer>  Player_one = new ArrayList<>();
    ArrayList<Integer>  Player_two = new ArrayList<>();
    ArrayList<Integer>  Player_CPU = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{

         button_1 = new Button();
         button_2 = new Button();
         button_3 = new Button();
         button_4 = new Button();
         button_5 = new Button();
         button_6 = new Button();
         button_7 = new Button();
         button_8 = new Button();
         button_9 = new Button();




        button_1.setOnAction(event->{
            PlayGame(1, button_1);
        });

        button_2.setOnAction(event->{
            PlayGame(2, button_2);
        });

        button_3.setOnAction(event->{
            PlayGame(3, button_3);
        });

        button_4.setOnAction(event->{
            PlayGame(4, button_4);
        });

         button_5.setOnAction(event->{
            PlayGame(5, button_5);
        });

        button_6.setOnAction(event->{
            PlayGame(6, button_6);
        });

        button_7.setOnAction(event->{
            PlayGame(7, button_7);
        });

        button_8.setOnAction(event->{
            PlayGame(8, button_8);
        });

        button_9.setOnAction(event->{
            PlayGame(9, button_9);
        });



       // StackPane sp = new StackPane();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));

        styleButton();


        gridPane.add(button_1,0,0);
        gridPane.add(button_2,1,0);
        gridPane.add(button_3,2,0);
        gridPane.add(button_4,0,1);
        gridPane.add(button_5,1,1);
        gridPane.add(button_6,2,1);
        gridPane.add(button_7,0,2);
        gridPane.add(button_8,1,2);
        gridPane.add(button_9,2,2);

        Scene scene = new Scene(gridPane, 400, 370);
       // scene.getStylesheets().add(TheTicc.Class.getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ticc");
        primaryStage.sizeToScene();
        primaryStage.show();


    }

    void PlayGame(int CellId, Button SelectedButton){
        System.out.println("Cell"+CellId);
        if(ActivePayer == 1)
        {
            SelectedButton.setText("X");
            Player_one.add(CellId);
            ActivePayer=2;
            CPU_Player();
        } else if(ActivePayer == 2)
        {
            SelectedButton.setText("0");
            Player_two.add(CellId);
            ActivePayer=1;
        }

        SelectedButton.setDisable(true);
        CheckWinner();
    }


    public static void main(String[] args) {
        launch(args);
    }

    void styleButton(){
        button_1.setMinSize(63, 63);
        button_2.setMinSize(63, 63);
        button_3.setMinSize(63, 63);
        button_4.setMinSize(63, 63);
        button_5.setMinSize(63, 63);
        button_6.setMinSize(63, 63);
        button_7.setMinSize(63, 63);
        button_8.setMinSize(63, 63);
        button_9.setMinSize(63, 63);

    }

    void CheckWinner(){
        int Winner = -1;
        //player 1
        if(Player_one.contains(1) && Player_one.contains(2) && Player_one.contains(3)){ Winner = 1;}
        if(Player_one.contains(4) && Player_one.contains(5) && Player_one.contains(6)){Winner = 1;}
        if(Player_one.contains(7) && Player_one.contains(8) && Player_one.contains(9)){Winner = 1;}
        String Winner_Message = "";

         if (Winner !=-1){

            if (Winner == 1){ Winner_Message = "The Winner is :Player 1"; }
            else if(Winner == 2){Winner_Message = "The Winner is :Player 2";}

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("Winner");
            alert.setContentText(Winner_Message);
            alert.show();
        }




    }

    void CPU_Player(){
        ArrayList<Integer> Null_Cells = new ArrayList<Integer>();

        for(int c =1 ; c < 10; c++){
            if(!(Player_one.contains(c) || Player_two.contains(c))){
                Null_Cells.add(c);
            }
        }

        Button SelectedButton;
        Random r = new Random();
        int Rand_Indexer = r.nextInt(Null_Cells.size()-0)+0;
        int cell = Null_Cells.get(Rand_Indexer);
        switch (cell){
            case 1: SelectedButton = button_1; break;
            case 2: SelectedButton = button_2; break;
            case 3: SelectedButton = button_3; break;
            case 4: SelectedButton = button_4; break;
            case 5: SelectedButton = button_5;break;
            case 6: SelectedButton = button_6;break;
            case 7: SelectedButton = button_7;break;
            case 8: SelectedButton = button_8;break;
            case 9: SelectedButton = button_9;break;
            default: SelectedButton = button_2;
        }

        PlayGame(cell, SelectedButton);
    }
}

