package com.example.filmoyunu2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FilmApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FilmApplication.class.getResource("film.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("GUESS MOVİe");
        stage.setScene(scene);
        stage.show();
    }

    public static  void main(String[] args) throws IOException {


        String dosyaYolu = "C:\\Users\\ayselcetin\\Desktop\\filmOyunu2\\src\\imdb_top_250.csv";
        String satir;
        ArrayList<String> filmler = new ArrayList<>();

        //filmleri hucre hucre okuduk
        try (FileReader fileReader = new FileReader(dosyaYolu);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while ((satir = bufferedReader.readLine()) != null) {
                String[] hucreler = satir.split(";"); // Noktalı virgülle ayrılmış hücreleri ayır

                for (String hucre : hucreler) {
                    String filmAdi = hucreler[1]; // Film adının olduğu sütunu seçtik
                    filmler.add(filmAdi);

                    System.out.print(hucre + "\t");
                }
                System.out.println();
            }
            //random film secme

            Random random = new Random();
            int randomIndex = random.nextInt(filmler.size());
            String randomFilm = filmler.get(randomIndex);

            System.out.println("Rastgele Seçilen Film: " + randomFilm);
            // Dosya okuma işlemleri burada yapılacak
        } catch (IOException e) {
            e.printStackTrace();
        }

        launch(args);


    }
}