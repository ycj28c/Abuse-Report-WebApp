/*
 * can generate vo class automaticly in mysql database
 */
package tools;

import java.sql.DriverManager;

public class GenerateTest {
public static void main(String[] args) {
    //第一种方法
	AutoGenerateVO util1 = new AutoGenerateVO();
    util1.setDRIVER("com.mysql.jdbc.Driver");
    util1.setURL("jdbc:mysql://127.0.0.1:3306/51test");
    util1.setUSERNAME("root");
    util1.setPASSWORD("1234");
    util1.setPojoFilePath("d:/AutoGenerateVO");  //set the saving path
    util1.setPackageName("mvc.vo"); //set the saving package name
    util1.createPOJO();
    //第二种方法
    /*
    GenerateVO util2 = new GenerateVO("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/testjava","root","root");
    util2.setPojoFilePath("d:/pojos");
    util2.setPackageName("com.doudoufamily.vo");
    util2.createPOJO();*/
}
}