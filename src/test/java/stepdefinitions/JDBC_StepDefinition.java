package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;

import utilities.DBUtils;
import utilities.QueryManage;
import utilities.ReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static utilities.DBUtils.*;


public class JDBC_StepDefinition extends DBUtils {

    ResultSet resultSet;

    QueryManage queryManage = new QueryManage();
    static String expectedData;
    static String actualData;
    String query;
    Faker faker = new Faker();

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {

        createConnection();

    }

    @Given("Query hazirlanir ve chat_users tablosuna execute edilir.")
    public void query_hazirlanir_ve_chat_users_tablosuna_execute_edilir() throws SQLException {

        query = queryManage.getChatUsersQuery();

        resultSet = getStatement().executeQuery(query);

    }

    @Given("Chat_users tablosundan donen resultSet dogrulanir.")
    public void chat_users_tablosundan_donen_result_set_dogrulanir() throws SQLException {

        expectedData = "11";

        resultSet.next();
        actualData = resultSet.getString(1);

        assertEquals(expectedData, actualData);
    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        closeConnection();
    }

    //********** Query02 ***********

    @Given("Query hazirlanir ve students tablosuna execute edilir.")
    public void query_hazirlanir_ve_students_tablosuna_execute_edilir() throws SQLException {

        query = queryManage.getStudentsQuery();

        resultSet = getStatement().executeQuery(query);

    }

    @Given("Students tablosundan donen resultSet`teki email bilgisi dogrulanir.")
    public void students_tablosundan_donen_result_set_teki_email_bilgisi_dogrulanir() throws SQLException {

        expectedData = "brain@gmail.com";

        resultSet.next();

        actualData = resultSet.getString("email");

        assertEquals(expectedData, actualData);

    }


    //********* Query03 ***********

    @Given("Query hazirlanir ve onlineexam tablosuna execute edilir.")
    public void query_hazirlanir_ve_onlineexam_tablosuna_execute_edilir() throws SQLException {

        query = queryManage.getOnlineExamQuery();

        resultSet = getStatement().executeQuery(query);

    }

    @Given("Onlineexam tablosundan donen resultSet`teki bilgiler listelenir.")
    public void onlineexam_tablosundan_donen_result_set_teki_bilgiler_listelenir() throws SQLException {

        while (resultSet.next()) {

            System.out.println(" exam : " + resultSet.getString(1) + " ->   ortalama: " +
                    resultSet.getString(2));

        }
    }

    //********** Query04 ***************

    @Given("Query hazirlanir ve transport_feemaster tablosuna executeUpdate edilir.")
    public void query_hazirlanir_ve_transport_feemaster_tablosuna_execute_update_edilir() {


    }

    @Given("The query is prepared and executed to the Support_messages table.")
    public void query_hazirlanir_ve_support_messages_tablosuna_execute_edilir() throws SQLException {
        query = queryManage.getSupportMessagesQuery();

        resultSet = getStatement().executeQuery(query);
    }

    @Given("The resultSet returned from the support_messages table is validated.")
    public void support_messages_tablosundan_donen_result_set_dogrulanir() throws SQLException {
        expectedData = "2";

        resultSet.next();
        actualData = resultSet.getString("support_ticket_id");

        assertEquals(expectedData, actualData);
    }

    @Given("The query is prepared and executedUpdate to the transport_feemaster table.")
    public void the_query_is_prepared_and_executed_update_to_the_transport_feemaster_table() throws SQLException {

        String queryIdList = queryManage.getCategoriesIdListQuery();
        resultSet = getStatement().executeQuery(queryIdList);
        List<Integer> existingIds = new ArrayList<>();
        while (resultSet.next()) {
            existingIds.add(resultSet.getInt("id"));
        }
            int newId = 1;
           while (existingIds.contains(newId)) {
               newId++;
           }


int rowcount = getStatement().executeUpdate("INSERT INTO  categories  (id, name, description) VALUES (" + newId + ", 'ismailtemiz', 'SDET')");
            System.out.println("Eklenecek yeni ID: " + newId);
            ReusableMethods.wait(3);

        resultSet = getStatement().executeQuery("SELECT name, description  FROM categories WHERE id = "+newId+";");
        if (resultSet.next()) {
            // Verinin doğrulama işlemini yapın
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            assertEquals("ismailtemiz", name);
            assertEquals("SDET", description);
        }

        if(rowcount > 0){
            System.out.println("Ekleme işlemi başarıyla gerçekleştirildi.");
        } else{
            System.out.println("Ekleme işlemi başarısız oldu.");
        }
    }


    @Given("The query is prepared and executedUpdate to the update_logs table.")
    public void the_query_is_prepared_and_executed_update_to_the_update_logs_table() throws SQLException {

                query=queryManage.getUpdate_logsQuery();
                 String updateLog= faker.lorem().word();
                preparedUpdate(query,updateLog,"Windows 10",79);
                 System.out.println("Update_log :"+updateLog);
    }
}