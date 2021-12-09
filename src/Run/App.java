package Run;

import java.io.IOException;
import java.sql.Connection;

import Classes.Anime;
import Classes.Episode;
import Classes.Movie;
import Implementation.AnimeCRUD;
import Implementation.ConnectionFactory;
import Implementation.EpisodeCRUD;
import Implementation.MovieCRUD;
import Implementation.TestFILTER;
import Interfaces.CONNECTable;

public class App {
    static CONNECTable connect = new ConnectionFactory();
    static Connection con = connect.getConnection();

    public static void main(String[] args) throws IOException {
        AnimeCRUD.setCon(con);
        EpisodeCRUD.setCon(con);
        MovieCRUD.setCon(con);
        TestFILTER.setCon(con);
        Anime a = new Anime();
        Episode e = new Episode();
        Movie m = new Movie();
        Operate op = new Operate();
        TestFILTER f = new TestFILTER();

        try {
            con = connect.getConnection();
            if (args.length != 0) {
                switch (args[0]) {
                    case "-h":
                        op.helpOperation();
                        break;
                    case "-c":
                        if (args[1].equals("-A"))
                            op.operationCreateTable(a);
                        else if (args[1].equals("-E"))
                            op.operationCreateTable(e);
                        else if (args[1].equals("-M"))
                            op.operationCreateTable(m);

                        break;
                    case "-i":
                        if (args[1].equals("-A"))
                            op.operationInsert(a, args[2]);
                        else if (args[1].equals("-E"))
                            op.operationInsert(e, args[2]);
                        else if (args[1].equals("-M"))
                            op.operationInsert(m, args[2]);
                        break;
                    case "-u":
                        if (args.length == 3) {
                            if (args[1].equals("-A"))
                                op.operationInsert(a, args[2]);
                            else if (args[1].equals("-E"))
                                op.operationInsert(e, args[2]);
                            else if (args[1].equals("-M"))
                                op.operationInsert(m, args[2]);
                        }
                        if (args.length == 4) {
                            if (args[1].equals("-A"))
                                op.operationUpdate(a, Integer.parseInt(args[2]), Double.parseDouble(args[3]));
                            else if (args[1].equals("-E"))
                                op.operationUpdate(e, Integer.parseInt(args[2]), Double.parseDouble(args[3]));
                            else if (args[1].equals("-M"))
                                op.operationUpdate(m, Integer.parseInt(args[2]), Double.parseDouble(args[3]));
                            break;
                        }

                    case "-d":
                        if (args.length == 2) {
                            if (args[1].equals("-A"))
                                op.operationDelete(a);
                            else if (args[1].equals("-E"))
                                op.operationDelete(e);
                            else if (args[1].equals("-M"))
                                op.operationDelete(m);
                        } else {
                            if (args[1].equals("-A")) {
                                if (args[2].equals("id"))
                                    op.operationDelete(a, Integer.parseInt(args[3]));
                            } else if (args[1].equals("-E")) {
                                if (args[2].equals("id"))
                                    op.operationDelete(e, Integer.parseInt(args[3]));
                            } else if (args[1].equals("-M")) {
                                if (args[2].equals("id"))
                                    op.operationDelete(m, Integer.parseInt(args[3]));
                            }

                            if (args[1].equals("-A")) {
                                if (args[2].equals("name"))
                                    op.operationDelete(a, (args[3]));
                            } else if (args[1].equals("-E")) {
                                if (args[2].equals("name"))
                                    op.operationDelete(e, (args[3]));
                            } else if (args[1].equals("-M")) {
                                if (args[2].equals("name"))
                                    op.operationDelete(m, (args[3]));
                            }
                        }
                        break;
                    case "-p":
                        if (args.length == 2) {
                            if (args[1].equals("-A"))
                                op.operationDisplay(a);
                            else if (args[1].equals("-E"))
                                op.operationDisplay(e);
                            else if (args[1].equals("-M"))
                                op.operationDisplay(m);
                        } else {
                            if (args[1].equals("-A")) {
                                if (args[2].equals("id"))
                                    op.operationDisplay(a, Integer.parseInt(args[3]));
                            } else if (args[1].equals("-E")) {
                                if (args[2].equals("id"))
                                    op.operationDisplay(e, Integer.parseInt(args[3]));
                            } else if (args[1].equals("-M")) {
                                if (args[2].equals("id"))
                                    op.operationDisplay(m, Integer.parseInt(args[3]));
                            }

                            if (args[1].equals("-A")) {
                                if (args[2].equals("name"))
                                    op.operationDisplay(a, (args[3]));
                            } else if (args[1].equals("-E")) {
                                if (args[2].equals("name"))
                                    op.operationDisplay(e, (args[3]));
                            } else if (args[1].equals("-M")) {
                                if (args[2].equals("name"))
                                    op.operationDisplay(m, (args[3]));
                            }

                            if (args[1].equals("-A")) {
                                if (args[2].equals("rating"))
                                    op.operationDisplay(a, Double.parseDouble(args[3]));
                            } else if (args[1].equals("-E")) {
                                if (args[2].equals("rating"))
                                    op.operationDisplay(e, Double.parseDouble(args[3]));
                            } else if (args[1].equals("-M")) {
                                if (args[2].equals("rating"))
                                    op.operationDisplay(m, Double.parseDouble(args[3]));
                            }
                        }
                        break;
                    case "-s":
                        if (args.length == 2) {
                            if (args[1].equals("s2l"))
                                f.sortByDurationShortToLong(m);
                            else if (args[1].equals("l2s"))
                                f.sortByDurationLongToShort(m);
                        }
                        if (args.length == 3) {
                            if (args[2].equals("h2l")) {
                                if (args[1].equals("-A"))
                                    f.sortByRatingHighToLow(a);
                                else if (args[1].equals("-E"))
                                    f.sortByratingHighToLow(e);
                                else if (args[1].equals("-M"))
                                    f.sortByratingHighToLow(m);
                            } else if (args[2].equals("l2h")) {
                                if (args[1].equals("-A"))
                                    f.sortByRatingLowToHigh(a);
                                else if (args[1].equals("-E"))
                                    f.sortByratingLowToHigh(e);
                                else if (args[1].equals("-M"))
                                    f.sortByratingLowToHigh(m);
                            } else if (args[2].equals("n2o")) {
                                if (args[1].equals("-A"))
                                    f.sortByDateNewToOld(a);
                                else if (args[1].equals("-E"))
                                    f.sortByDateNewToOld(e);
                                else if (args[1].equals("-M"))
                                    f.sortByDateNewToOld(m);
                            } else if (args[2].equals("o2n")) {
                                if (args[1].equals("-A"))
                                    f.sortByDateOldToNew(a);
                                else if (args[1].equals("-E"))
                                    f.sortByDateOldToNew(e);
                                else if (args[1].equals("-M"))
                                    f.sortByDateOldToNew(m);
                            }
                        }

                        break;
                    case "-f":
                        if (args[1].equals("type"))
                            f.filterByType(e, args[2]);
                        else if (args[1].equals("genre"))
                            f.filterByGenre(a, args[2]);
                        else if (args[1].equals("pc"))
                            f.filterByProductionCompany(a, args[2]);
                        break;
                    default:
                        op.helpOperation();
                        break;
                }
            } else {
                op.helpOperation();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
