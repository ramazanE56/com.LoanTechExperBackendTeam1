package utilities;

public class QueryManage {


    private String chatUsersQuery = "select count(*) from u168183796_qawonder.chat_users where create_staff_id=1";

    private String studentsQuery = "Select * From u168183796_qawonder.students Where firstname= 'Brian' AND lastname= 'Kohlar'";

    private String onlineExamQuery = "SELECT exam ,AVG(passing_percentage) FROM u168183796_qawonder.onlineexam group by exam";

    private String supportMessagesQuery = "SELECT support_ticket_id FROM u168183796_qaloantec.support_messages WHERE message = 'Tickett'";

    private String categoriesQuery = "INSERT INTO categories (id, name, description) VALUES (5, 'ismailtemiz', 'SDET')";
    private String categoriesIdListQuery = "SELECT * FROM u168183796_qaloantec.categories";

    private String update_logsQuery = "UPDATE u168183796_qaloantec.update_logs SET update_log = ? WHERE version = ? AND id = ?";

    private String supportTicketsQuery = "SELECT subject FROM u168183796_qaloantec.support_tickets WHERE ticket LIKE '4%'";

    private String usersMobileUpdateQuery = "UPDATE users SET mobile = ? WHERE username LIKE '%e_'";
    private String supportAttachmentQuery = "DELETE FROM support_attachments WHERE support_message_id = ?";
    private String supportAttachmentVerifyQuery = "SELECT id, support_message_id, attachment, created_At, updated_At  FROM u168183796_qaloantec.support_attachments WHERE support_message_id = ?";
    private String supportAttachmentAddQuery="INSERT INTO support_attachments (`id`, `support_message_id`, `attachment`, `created_at`) VALUES (?, ?, ?, ?)";
    // Arif Emre
    private String DepositsQuery = "SELECT charge FROM deposits WHERE amount < 500000 AND trx = '4GC9SMZUS69S';";
    private String adminNotifications = "SELECT * FROM admin_notifications WHERE user_id = 2 AND id > 20;";
    private String admindeposits = "SELECT * FROM deposits WHERE amount BETWEEN 100 AND 500;";




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

    public String getSupportTicketsQuery() {
        return supportTicketsQuery;
    }

    public String getUsersMobileUpdateQuery() {
        return usersMobileUpdateQuery;

    }

    public String getSupportAttachmentQuery(){
        return supportAttachmentQuery;
    }

    public String getSupportAttachmentVerifyQuery(){
        return supportAttachmentVerifyQuery;
    }

    public String getSupportAttachmentAddQuery(){
        return supportAttachmentAddQuery;
    }

    // Arif Emre
    public String getDepositsQuery() {    return DepositsQuery;}
    public String getAdminNotifications() {return adminNotifications;}
    public String getAdmindeposits() { return admindeposits;}





}