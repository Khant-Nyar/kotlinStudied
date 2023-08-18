package com.khantnyar.recyclerview.models


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class CustomerApiResponse(
    @SerializedName("data") var customers: ArrayList<Customers> = arrayListOf(),
    @SerialName("message") val message: String?,
    @SerialName("model_id") val modelId: Int?,
    @SerialName("object_name") val objectName: String?,
    @SerialName("permisssions") val permisssions: Permisssions?,
    @SerialName("responseCode") val responseCode: Int?,
    @SerialName("success") val success: Boolean?
) {
    @Serializable
    data class Permisssions(
        @SerialName("create") val create: Boolean?,
        @SerialName("delete") val delete: Boolean?,
        @SerialName("read") val read: Boolean?,
        @SerialName("write") val write: Boolean?
    )
}
@Serializable
data class Customers(
    @SerialName("active") val active: Boolean?,
    @SerialName("active_limit") val activeLimit: Boolean?,
    @SerialName("additional_info") val additionalInfo: Boolean?,
    @SerialName("bank_ids") val bankIds: List<BankId?>?,
    @SerialName("blocking_stage") val blockingStage: Double?,
    @SerialName("charge_option") val chargeOption: Boolean?,
    @SerialName("city") val city: Boolean?,
    @SerialName("color") val color: Int?,
    @SerialName("comment") val comment: Boolean?,
    @SerialName("commercial_company_name") val commercialCompanyName: Boolean?,
    @SerialName("commercial_partner_id") val commercialPartnerId: List<CommercialPartnerId?>?,
    @SerialName("company_id") val companyId: List<CompanyId?>?,
    @SerialName("company_name") val companyName: Boolean?,
    @SerialName("company_registry") val companyRegistry: Boolean?,
    @SerialName("country_id") val countryId: List<CountryId?>?,
    @SerialName("create_date") val createDate: String?,
    @SerialName("create_uid") val createUid: List<CreateUid?>?,
    @SerialName("customer_rank") val customerRank: Int?,
    @SerialName("customer_status") val customer_status: String?,
    @SerialName("date") val date: Boolean?,
    @SerialName("day") val day: Boolean?,
    @SerialName("debit_limit") val debitLimit: Double?,
    @SerialName("delivery_order") val deliveryOrder: Int?,
    @SerialName("display_name") var display_name: String?,
    @SerialName("email") val email: String?,
    @SerialName("email_normalized") val emailNormalized: String?,
    @SerialName("employee") val employee: Boolean?,
    @SerialName("employee_ids") val employeeIds: List<EmployeeId?>?,
    @SerialName("followup_status") val followupStatus: Boolean?,
    @SerialName("function") val function: Boolean?,
    @SerialName("id") val id: Int?,
    @SerialName("image_1024") val image1024: Boolean?,
    @SerialName("image_128") val image128: Boolean?,
    @SerialName("image_1920") val image1920: Boolean?,
    @SerialName("image_256") val image256: Boolean?,
    @SerialName("image_512") val image512: Boolean?,
//        @SerialName("industry_id") val industryId: List<Any?>?,
    @SerialName("invoice_ids") val invoiceIds: List<InvoiceId?>?,
    @SerialName("invoice_list") val invoiceList: List<Invoice?>?,
    @SerialName("invoice_warn") val invoiceWarn: String?,
    @SerialName("invoice_warn_msg") val invoiceWarnMsg: Boolean?,
    @SerialName("is_company") val isCompany: Boolean?,
    @SerialName("is_published") val isPublished: Boolean?,
    @SerialName("lang") val lang: String?,
    @SerialName("last_time_entries_checked") val lastTimeEntriesChecked: Boolean?,
    @SerialName("loyal") val loyal: Int?,
    @SerialName("message_bounce") val messageBounce: Int?,
    @SerialName("message_follower_ids") val messageFollowerIds: List<MessageFollowerId?>?,
    @SerialName("message_ids") val messageIds: List<MessageId?>?,
//        @SerialName("message_main_attachment_id") val messageMainAttachmentId: List<Any?>?,
    @SerialName("mobile") val mobile: Boolean?,
    @SerialName("morning_evening") val morningEvening: Boolean?,
    @SerialName("name") val name: String?,
    @SerialName("owner_name") var owner_name: String?= "null",
//        @SerialName("parent_id") val parentId: List<Any?>?,
    @SerialName("partner_gid") val partnerGid: Int?,
    @SerialName("partner_latitude") val partnerLatitude: Double?,
    @SerialName("partner_longitude") val partnerLongitude: Double?,
    @SerialName("partner_share") val partnerShare: Boolean?,
    @SerialName("phone") val phone: Boolean?,
    @SerialName("phone_sanitized") val phoneSanitized: Boolean?,
    @SerialName("picking_warn") val pickingWarn: String?,
    @SerialName("picking_warn_msg") val pickingWarnMsg: Boolean?,
    @SerialName("purchase_line_ids") val purchaseLineIds: List<PurchaseLineId?>?,
    @SerialName("purchase_warn") val purchaseWarn: String?,
    @SerialName("purchase_warn_msg") val purchaseWarnMsg: Boolean?,
    @SerialName("ref") val ref: Boolean?,
    @SerialName("ref_company_ids") val refCompanyIds: List<RefCompanyId?>?,
    @SerialName("sale_order_ids") val sale_order_ids: List<SaleOrderId?>?,
    @SerialName("sale_warn") val saleWarn: String?,
    @SerialName("sale_warn_msg") val saleWarnMsg: Boolean?,
    @SerialName("signup_expiration") val signupExpiration: Boolean?,
    @SerialName("signup_token") val signupToken: Boolean?,
    @SerialName("signup_type") val signupType: Boolean?,
//        @SerialName("state_id") val stateId: List<Any?>?,
    @SerialName("street") val street: Boolean?,
    @SerialName("street2") val street2: Boolean?,
    @SerialName("supplier_rank") val supplierRank: Int?,
//        @SerialName("team_id") val teamId: List<Any?>?,
//        @SerialName("title") val title: List<Any?>?,
    @SerialName("type") val type: String?,
    @SerialName("tz") val tz: Boolean?,
    @SerialName("user_id") val userId: List<UserId?>?,
    @SerialName("user_ids") val userIds: List<UserId?>?,
    @SerialName("vat") val vat: Boolean?,
    @SerialName("visitor_ids") val visitorIds: List<VisitorId?>?,
    @SerialName("warning_stage") val warningStage: Double?,
    @SerialName("website") val website: Boolean?,
//        @SerialName("website_id") val websiteId: List<Any?>?,
    @SerialName("write_date") val writeDate: String?,
    @SerialName("write_uid") val writeUid: List<WriteUid?>?,
    @SerialName("zip") val zip: Boolean?,
    val customerOrderStatus: Boolean?,
) {
    @Serializable
    data class BankId(
        @SerialName("id") val id: Int?
    )

    @Serializable
    data class CommercialPartnerId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class CompanyId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class CountryId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class CreateUid(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class EmployeeId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class InvoiceId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class Invoice(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class MessageFollowerId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class MessageId(
        @SerialName("id") val id: Int?
    )

    @Serializable
    data class PurchaseLineId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class RefCompanyId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class SaleOrderId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class UserId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class VisitorId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class WriteUid(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )
}