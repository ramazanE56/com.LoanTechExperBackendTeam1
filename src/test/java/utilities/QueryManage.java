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


    private String categoriesListExcelQuery = "SELECT * FROM u168183796_qaloantec.categories";




    private String gatewaysListQuery="SELECT code FROM gateways ORDER BY code DESC LIMIT 5";
    private String adminNotificationsQuery="SELECT COUNT(*) FROM admin_notifications WHERE is_read = 1 AND user_id = 1";
    private String depositsGatewayCurrenciesQuery="SELECT SUM(amount) AS toplam_usd FROM deposits WHERE method_currency = 'USD'";



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
    public String getGatewaysListQuery() {
        return gatewaysListQuery;
    }

    public String getAdminNotificationsQuery() {
        return adminNotificationsQuery;
    }

    public String getDepositsGatewayCurrenciesQuery() {
        return depositsGatewayCurrenciesQuery;
    }


    public String getCategoriesListExcelQuery() {
        return categoriesListExcelQuery;
    }
}