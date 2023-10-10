package example;

import org.apache.log4j.PropertyConfigurator;

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class Main {

  public static void main(String[] args) {
    String PWD = System.getenv("PWD");
    PropertyConfigurator.configure(PWD + "/src/main/resources/log4j.xml");
    final String connectionStr = "jdbc:postgresql://db:26257/animal?sslmode=disable";

    example.chain.ILink obj = new example.chain.Driver();

    if (obj.hasResource("org.postgresql.Driver", "root", "", connectionStr)){
      example.db.print.output.IOutput output = new example.db.print.output.ToFile();
      for ( String tbl : new String[]{"dog"})
        example.db.DBQuery.query("root", "", connectionStr, tbl, output);
    }
  }
}
