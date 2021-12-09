## Details
            Group No : 40
    Members               Roll No
SAMPREETH JANGALA       S20200010079 
KARTHIKEYA BETHU        S20200010090 
NITISH REDDY NANDYALA   S20200010142 
BASAVACHARI BOPPUDI     S20200010043 
HARITEJA UMMANENI       S20200010076

## Tools used
            Java and Mysql
We wrote the code in java language and used Mysql for database.

## Porject Information
We create the command line project for storing the Anime data in database.

In src file we have sub pakages like ----

SQLDetails      ->Mysql details here 
            Details.java            for storing sql details 
   
Run             -> App.java and corresponding methods are here
            App.java                class that has main method.
            Operate.java            has methods that is called by App.java by corresponding command line arguments

Classes         -> we kept all classes here
            Anime.java              has details,constructors,methods of Anime class
            Episode.java            has details,constructors,methods of Episode class
            Movie.java              has details,constructors,methods of Movie class

Interfaces      -> we kept all interfaces here 
            CONNECTable.java        interface for getconnection
            CRUDable.java           interface for CRUD operations
            FITERable.java          interface for filter operations

Implementation  -> implementations of interfaces are here
            AnimeCRUD.java          implemments CRUDable interface and has CRUD operations for Anime class   
            ConnectionFactory.java  implements to get connection with sql
            EpisodeCRUD.java        implemments CRUDable interface and has CRUD operations for Episode class
            MovieCRUD.java          implemments CRUDable interface and has CRUD operations for Movie class
            TestFILTER.java         implemments Filteable interface and has soring and filter operations for all there classes

CSV_files       ->all csv files here
            Anime.csv               csv file for Anime details
            Episode.csv             csv file for Episode details
            Movie.csv               csv file for Movie details