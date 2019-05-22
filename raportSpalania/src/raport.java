import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class raport {
    static String daneZBazy;
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {

            String polaczenieURL = "jdbc:mysql://127.0.0.1/raporty?user=root&password=";
            String query = "Select * FROM spalanie";
            Connection conn = null;
            conn = DriverManager.getConnection(polaczenieURL);
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            System.out.println("Witaj w aplikacji Raport Spalania v0.1");

            String queryOstatniprzebieg = "SELECT przebieg FROM spalanie ORDER BY id DESC LIMIT 1 ";
            ResultSet result = stmt.executeQuery(queryOstatniprzebieg);
            while (result.next()) {
                String ostatniPrzebieg = result.getString("przebieg");
                if (ostatniPrzebieg == null) {
                    System.out.println("Brak danych odnośnie ostatniego tankowania");
                }
                System.out.println("Ostatni zapisany przebieg pojazdu to: " + ostatniPrzebieg + " km");
            }
            conn.close();
        } catch (ClassNotFoundException wyjatek) {
            System.out.println("Problem ze sterownikiem");
        } catch (SQLException wyjatek) {
            //e.printStackTrace();
            //System.out.println("Problem z logowaniem\nProsze sprawdzic:\n nazwę użytkownika, hasło, nazwę bazy danych lub adres IP serwera");
            System.out.println("SQLException: " + wyjatek.getMessage());
            System.out.println("SQLState: " + wyjatek.getSQLState());
            System.out.println("VendorError: " + wyjatek.getErrorCode());
        }

            Scanner scan = new Scanner(System.in);

            System.out.print("Wprowadź przebieg pojazdu: ");
            double przebieg = scan.nextDouble();

            System.out.print("Wprowadź tankowanie: [w litrach] ");
            double tankowanie = scan.nextDouble();


        try {

            String polaczenieURL = "jdbc:mysql://127.0.0.1/raporty?user=root&password=";
            String query = "Select * FROM spalanie";
            Connection conn = null;
            conn = DriverManager.getConnection(polaczenieURL);
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            String queryOstatniprzebieg = "SELECT przebieg FROM spalanie ORDER BY id DESC LIMIT 1 ";
            ResultSet result = stmt.executeQuery(queryOstatniprzebieg);
            while (result.next())
            {
                double ostatniPrzebieg = result.getDouble("przebieg");
                double averange = (tankowanie/(przebieg-ostatniPrzebieg)) * 100;

                System.out.print("Średnie spalania wynosi: ");
                System.out.format("%.2f%n",averange);

                String queryDodaj = "INSERT INTO spalanie (przebieg, ilosc_paliwa, srednie_spalanie) VALUES(" + przebieg + ", " + tankowanie + ", " + averange + ")";
                stmt.executeUpdate(queryDodaj);

            }
            conn.close();
            }
            catch (ClassNotFoundException wyjatek)
            {
                System.out.println("Problem ze sterownikiem");
            }
            catch (SQLException wyjatek)
            {
                    //e.printStackTrace();
                    //System.out.println("Problem z logowaniem\nProsze sprawdzic:\n nazwę użytkownika, hasło, nazwę bazy danych lub adres IP serwera");
                    System.out.println("SQLException: " + wyjatek.getMessage());
                    System.out.println("SQLState: " + wyjatek.getSQLState());
                    System.out.println("VendorError: " + wyjatek.getErrorCode());
            }

            System.out.println("Czy chcesz zobaczyć 3 ostatnie tankowania? [Wybierz 1]");
            System.out.println("Zakończ program? [Wybierz 0]");

            Scanner scan1 = new Scanner(System.in);
                int zobaczTankowania = scan1.nextInt();
                if (zobaczTankowania == 1)
                {
                    try
                    {
                        String polaczenieURL = "jdbc:mysql://127.0.0.1/raporty?user=root&password=";
                        String query = "SELECT * FROM spalanie ORDER BY id DESC LIMIT 3";
                        Connection conn = null;
                        conn = DriverManager.getConnection(polaczenieURL);
                        Class.forName("com.mysql.jdbc.Driver");
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery(query);


                        System.out.println("Raport poprzednich 3 tankowań: ");

                        while (rs.next())
                        {
                        wyswietlDaneZBazy(rs);
                         }

                    }
                        //Wyrzuć wyjątki jężeli nastąpią błędy z podłączeniem do bazy danych lub blędy zapytania o dane
                        catch (ClassNotFoundException wyjatek)
                        {
                            System.out.println("Problem ze sterownikiem");
                        }
                        catch (SQLException wyjatek)
                        {
                            //e.printStackTrace();
                            //System.out.println("Problem z logowaniem\nProsze sprawdzic:\n nazwę użytkownika, hasło, nazwę bazy danych lub adres IP serwera");
                            System.out.println("SQLException: " + wyjatek.getMessage());
                            System.out.println("SQLState: " + wyjatek.getSQLState());
                            System.out.println("VendorError: " + wyjatek.getErrorCode());
                        }
                }
                else
                    System.out.println("Dziękujemy za skorzystanie z aplikacji");
    }

    static void wyswietlDaneZBazy(ResultSet rs) {

        try
        {
            daneZBazy = rs.getString(2);
            System.out.print("Ilość zatankowanego paliwa" +" "+daneZBazy + " ");
            daneZBazy = rs.getString(3);
            System.out.print("Ilość przejechanych km: "+daneZBazy+ " ");
            daneZBazy = rs.getString(4);
            System.out.println("Średnie spalanie: "+daneZBazy);
        }
        catch (SQLException e)
        {
           // e.printStackTrace();
        }
    }
}










