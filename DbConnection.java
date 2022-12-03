// Connect to SQLite Database using JDBC Bridge
// Displaying the contents of table S in database S_P_SP.
// Java core packages
import java.awt.*;
import java.sql.*;
import java.util.*;
// Java extension packages
import javax.swing.*;
public class DbConnection extends JFrame {
   // constructor connects to database, queries database,
   // processes results and displays results in window
   public DbConnection()
   {
      super( "S Table of S_P_SP Database" );
      // connect to database S_P_SP and query database
      try {
         // load database driver class
    	  Class.forName("org.sqlite.JDBC");

         // connect to database
         Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\S_P_SP.db"); //Replace with your path to your database
         // create Statement to query database
         Statement statement = connection.createStatement();

         // query database
         ResultSet resultSet =
            statement.executeQuery( "SELECT * FROM s" );
         // process query results
         StringBuffer results = new StringBuffer();
         ResultSetMetaData metaData = resultSet.getMetaData();
         int numberOfColumns = metaData.getColumnCount();
         for ( int i = 1; i <= numberOfColumns; i++ ) {
            results.append( metaData.getColumnName( i )
               + "\t" );
         }
         results.append( "\n" );
         while ( resultSet.next() ) {
            for ( int i = 1; i <= numberOfColumns; i++ ) {
               results.append( resultSet.getObject( i )
                  + "\t" );
            }
            results.append( "\n" );
         }
         // close statement and connection
         statement.close();
         connection.close();

         // set up GUI and display window
         JTextArea textArea = new JTextArea(
            results.toString() );
         Container container = getContentPane();
         container.add( new JScrollPane( textArea ) );
         setSize( 300, 100 );  // set window size
         setVisible( true );   // display window
      }  // end try

      // detect problems interacting with the database
      catch ( SQLException sqlException ) {
         JOptionPane.showMessageDialog( null,
            sqlException.getMessage(), "Database Error",
            JOptionPane.ERROR_MESSAGE );
         System.exit( 1 );
      }

      catch(ClassNotFoundException cnfex) {

          System.out.println("Problem in loading or "
                  + "registering SQLite JDBC driver");
          cnfex.printStackTrace();
      }
   }  // end DbConnection constructor definition
   // launch the application
   public static void main( String args[] )
   {
      DbConnection window = new DbConnection();
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
}  // end class DbConnection
