package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.ApiUtils;
import utilities.DBUtils;
import utilities.QueryManage;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class JDBC_StepDefinition extends ApiUtils {

    ResultSet resultSet;

    QueryManage queryManage = new QueryManage();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {

        DBUtils.createConnection();

    }
    @Given("Query hazirlanir ve chat_users tablosuna execute edilir.")
    public void query_hazirlanir_ve_chat_users_tablosuna_execute_edilir() throws SQLException {

        String query= queryManage.getChatUsersQuery();

        resultSet= DBUtils.getStatement().executeQuery(query);

    }

    @Given("Chat_users tablosundan donen resultSet dogrulanir.")
    public void chat_users_tablosundan_donen_result_set_dogrulanir() throws SQLException {

       String expectedData= "11";

       resultSet.next();
       String actualData = resultSet.getString(1);

        assertEquals(expectedData,actualData);
    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        DBUtils.closeConnection();
    }

    //********** Query02 ***********

    @Given("Query hazirlanir ve students tablosuna execute edilir.")
    public void query_hazirlanir_ve_students_tablosuna_execute_edilir() throws SQLException {

            String query = queryManage.getStudentsQuery();

            resultSet =  DBUtils.getStatement().executeQuery(query);

    }
    @Given("Students tablosundan donen resultSet`teki email bilgisi dogrulanir.")
    public void students_tablosundan_donen_result_set_teki_email_bilgisi_dogrulanir() throws SQLException {

        String expectedData= "brain@gmail.com";

        resultSet.next();

        String actualData = resultSet.getString("email");

        assertEquals(expectedData,actualData);

    }


    //********* Query03 ***********

    @Given("Query hazirlanir ve onlineexam tablosuna execute edilir.")
    public void query_hazirlanir_ve_onlineexam_tablosuna_execute_edilir() throws SQLException {

        String query = queryManage.getOnlineExamQuery();

        resultSet =  DBUtils.getStatement().executeQuery(query);

    }
    @Given("Onlineexam tablosundan donen resultSet`teki bilgiler listelenir.")
    public void onlineexam_tablosundan_donen_result_set_teki_bilgiler_listelenir() throws SQLException {

        while(resultSet.next()){

            System.out.println( " exam : "+ resultSet.getString(1)+ " ->   ortalama: " +
                    resultSet.getString(2));

        }
    }

    //********** Query04 ***************

    @Given("Query hazirlanir ve transport_feemaster tablosuna executeUpdate edilir.")
    public void query_hazirlanir_ve_transport_feemaster_tablosuna_execute_update_edilir() {



    }



}
