package utilities;

public class QueryManage {


  private String chatUsersQuery = "select count(*) from u168183796_qawonder.chat_users where create_staff_id=1";

  private String studentsQuery = "Select * From u168183796_qawonder.students Where firstname= 'Brian' AND lastname= 'Kohlar'";

  private String onlineExamQuery = "SELECT exam ,AVG(passing_percentage) FROM u168183796_qawonder.onlineexam group by exam";




  //*********Getter**********

    public String getChatUsersQuery() {
        return chatUsersQuery;
    }

    public String getStudentsQuery() {
        return studentsQuery;
    }

    public String getOnlineExamQuery() {
        return onlineExamQuery;
    }
}
