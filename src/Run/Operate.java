package Run;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Classes.Anime;
import Classes.Episode;
import Classes.Movie;
import Implementation.AnimeCRUD;
import Implementation.EpisodeCRUD;
import Implementation.MovieCRUD;

public class Operate {
    public AnimeCRUD ani = new AnimeCRUD();
    public EpisodeCRUD epi = new EpisodeCRUD();
    public MovieCRUD mov = new MovieCRUD();
    Scanner scan = new Scanner(System.in);

    public void helpOperation() {
        System.out.println("-----help operation------\n");
        System.out.println("-----flags information");
        System.out.printf("[flag]\t\t[reason]\n<-A>\t\ttable flag for anime table\n<-E>\t\ttable flag for Episodes table\n<-M>\t\ttable flag for Movies table\n");
        System.out.println("<h2l>\t\tsort flag high to low rating");
        System.out.println("<l2h>\t\tsort flag low to high rating");
        System.out.println("<s2l>\t\tsort flag short to long duration movie");
        System.out.println("<l2s>\t\tsort flag long to short duration movie");
        System.out.println("<n2o>\t\tsort flag new to old date");
        System.out.println("<o2n>\t\tsort flag old to new date\n");


        System.out.println("-----Operations information\n");

        System.out.printf("CREATE particular table in database\n\t<-c> [Table Flag]\n\texample: app -c -A\n\n");

        System.out.printf("INSERT data into a table \n\t<-i> [Table Flag] <filePath>\n\texample: app <-i> -A src/Anime.csc\n\t\n");

        System.out.printf("DISPLAY/print entire data in a table \n\t<-p> [Table Flag]\n\texample: app -p -A\n\n");
        System.out.printf("DISPLAY/print data based on a particular attribute (id,name,rating) in a table \n\t<-p> [Table Flag] <attributeName> <attributeValue>\n\texample: app -p -A id 2\n\n");

        System.out.printf("DELETE entire data in a table \n\t<-d> [Table Flag]\n\texample: app -d -A\n\n");
        System.out.printf("DELETE data based on a particular attribute (id,name) in a table \n\t<-d> [Table Flag] <attributeName> <attributeValue>\n\texample: app -d -A id 2\n\n");

        
        System.out.printf("UPDATE entire data in a table \n\t<-u> [Table Flag] <filePath>\n\texample: app -u -A src/UpdateAnime.csv\n\n");
        System.out.printf("UPDATE rating by taking id in a table \n\t<-u> [Table Flag] idValue newRating\n\texample: app -u -A 2 5.5\n\n");

        System.out.printf("SORT entire data by duration from shortTolong or longToshort in movie table \n\t<-s> [sortFlag] \n\texample: app -s s2l\n\n");
        System.out.printf("SORT entire data by rating from highTolow or lowTohigh in table \n\t<-s> [Table Flag] [sortFlag] \n\texample: app -s -A h2l\n\n");
        System.out.printf("SORT entire data by release date from newToold or oldTonew in table \n\t<-s> [Table Flag] [sortFlag] \n\texample: app -s -A n2o\n\n");


        System.out.printf("FILTER data by attributes(type,gener,pc) in a table \n\t<-f> <attributeName> <value>\n\texample: app -f type value\n\n");
    }

    public void operationCreateTable(Anime a) {
        ani.create();
    }

    public void operationCreateTable(Episode e) {
        epi.create();
    }

    public void operationCreateTable(Movie m) {
        mov.create();
    }

    public void operationInsert(Anime a, String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String animeLine = null;
        while ((animeLine = reader.readLine()) != null) {
            a = new Anime(animeLine);
            ani.insert(a);
        }
        reader.close();
        System.out.println("Insertion Successful");
    }

    public void operationInsert(Episode e, String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String episodeLine = null;
        while ((episodeLine = reader.readLine()) != null) {
            e = new Episode(episodeLine);
            epi.insert(e);
        }
        reader.close();
        System.out.println("Insertion Successful");

    }

    public void operationInsert(Movie m, String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String movieLine = null;
        while ((movieLine = reader.readLine()) != null) {
            m = new Movie(movieLine);
            mov.insert(m);
        }
        reader.close();
        System.out.println("Insertion Successful");
    }

    public void operationUpdate(Anime a, int id, double rating) throws IOException {
        ani.update(a, id, rating);
        System.out.println("Update Successful");
    }

    public void operationUpdate(Episode e, int id, double rating) throws IOException {
        epi.update(e, id, rating);
        System.out.println("Update Successful");

    }

    public void operationUpdate(Movie m, int id, double rating) throws IOException {
        mov.update(m, id, rating);
        System.out.println("Update Successful");

    }

    public void operationDisplay(Anime a) {
        List<Anime> aList = new ArrayList<>();
        aList = ani.printAll();
        Iterator<Anime> ill = aList.iterator();
        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;

            }
        } while (true);

    }

    public void operationDisplay(Episode e) {
        List<Episode> eList = new ArrayList<>();
        eList = epi.printAll();
        Iterator<Episode> ill = eList.iterator();
        int x = 10;

        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;
            }
        } while (true);

    }

    public void operationDisplay(Movie m) {
        List<Movie> mList = new ArrayList<>();
        mList = mov.printAll();
        Iterator<Movie> ill = mList.iterator();
        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;
            }
        } while (true);
    }

    public void operationDisplay(Anime a, int id) {
        List<Anime> aList = new ArrayList<>();
        aList = ani.printByID(id);
        Iterator<Anime> ill = aList.iterator();

        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;

            }
        } while (true);
    }

    public void operationDisplay(Episode e, int id) {
        List<Episode> eList = new ArrayList<>();
        eList = epi.printByID(id);
        Iterator<Episode> ill = eList.iterator();
        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;
            }
        } while (true);
    }

    public void operationDisplay(Movie m, int id) {
        List<Movie> mList = new ArrayList<>();
        mList = mov.printByID(id);
        Iterator<Movie> ill = mList.iterator();
        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;
            }
        } while (true);
    }

    public void operationDisplay(Anime a, String name) {
        List<Anime> aList = new ArrayList<>();
        aList = ani.printByName(name);
        Iterator<Anime> ill = aList.iterator();

        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;

            }
        } while (true);
    }

    public void operationDisplay(Episode e, String name) {
        List<Episode> eList = new ArrayList<>();
        eList = epi.printByEpName(name);
        Iterator<Episode> ill = eList.iterator();
        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;
            }
        } while (true);
    }

    public void operationDisplay(Movie m, String name) {
        List<Movie> mList = new ArrayList<>();
        mList = mov.printByMovieName(name);
        Iterator<Movie> ill = mList.iterator();
        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;
            }
        } while (true);
    }

    public void operationDisplay(Anime a, double rating) {
        List<Anime> aList = new ArrayList<>();
        aList = ani.printAnime(rating);
        Iterator<Anime> ill = aList.iterator();

        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;
            }
        } while (true);
    }

    public void operationDisplay(Episode e, double rating) {
        List<Episode> eList = new ArrayList<>();
        eList = epi.printEpisode(rating);
        Iterator<Episode> ill = eList.iterator();
        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;
            }
        } while (true);
    }

    public void operationDisplay(Movie m, double rating) {
        List<Movie> mList = new ArrayList<>();
        mList = mov.printMovie(rating);
        Iterator<Movie> ill = mList.iterator();
        int x = 10;
        do {
            for (int i = 0; i < x; i++) {
                if (ill.hasNext())
                    System.out.println(ill.next());
            }
            System.out.println("--Enter <1> to continue, or Enter <0> to exit---");
            int i = scan.nextInt();
            if (i == 0 || !ill.hasNext()) {

                break;
            }
        } while (true);
    }

    public void operationDelete(Anime a) {
        ani.delete();
        System.out.println("Delete Successful");
    }

    public void operationDelete(Episode e) {
        epi.delete();
        System.out.println("Delete Successful");

    }

    public void operationDelete(Movie m) {
        mov.delete();
        System.out.println("Delete Successful");

    }

    public void operationDelete(Anime a, int id) {
        ani.delete(id);
        System.out.println("Delete Successful");

    }

    public void operationDelete(Episode e, int id) {
        epi.deleteByID(id);
        System.out.println("Delete Successful");

    }

    public void operationDelete(Movie m, int id) {
        mov.deleteByID(id);
        System.out.println("Delete Successful");

    }

    public void operationDelete(Anime a, String name) {
        ani.delete(name);
        System.out.println("Delete Successful");

    }

    public void operationDelete(Episode e, String name) {
        epi.deleteByEpisodeName(name);
        System.out.println("Delete Successful");

    }

    public void operationDelete(Movie m, String name) {
        mov.deleteByMovieName(name);
        System.out.println("Delete Successful");

    }

}
