package utilities;

public class QueryManage {


  private String chatUsersQuery = "select count(*) from u168183796_qawonder.chat_users where create_staff_id=1";

  private String studentsQuery = "Select * From u168183796_qawonder.students Where firstname= 'Brian' AND lastname= 'Kohlar'";

  private String onlineExamQuery = "SELECT exam ,AVG(passing_percentage) FROM u168183796_qawonder.onlineexam group by exam";

  private String supportMessagesQuery = "SELECT support_ticket_id FROM u168183796_qaloantec.support_messages WHERE message = 'Tickett'";

  private String categoriesQuery ="INSERT INTO categories (id, name, description) VALUES (5, 'ismailtemiz', 'SDET')";
  private String categoriesIdListQuery ="SELECT * FROM u168183796_qaloantec.categories";

  private String update_logsQuery = "UPDATE u168183796_qaloantec.update_logs SET update_log = ? WHERE version = ? AND id = ?";







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

    public String getSupportMessagesQuery() {
        return supportMessagesQuery;
    }

    public String getCategoriesQuery() {
        return categoriesQuery;
    }

    public String getCategoriesIdListQuery() {

        return categoriesIdListQuery;
    }

    public String getUpdate_logsQuery() {
        return update_logsQuery;
    }
}
