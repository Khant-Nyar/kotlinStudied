package com.khantnyar.recyclerview.models


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderApiResponse(
    @SerialName("success") val success: Boolean?,
    @SerialName("message") val message: String?,
    @SerialName("responseCode") val responseCode: Int?,
    @SerialName("limit") val limit: String?,
    @SerialName("order") val order: String?,
    @SerialName("object_name") val objectName: String?,
    @SerialName("permisssions") val permisssions: Permisssions?,
    @SerialName("model_id") val modelId: Int?,
    @SerializedName("data") val orders: ArrayList<Orders> = arrayListOf(),

) {
    @Serializable
    data class Permisssions(
        @SerialName("read") val read: Boolean?,
        @SerialName("write") val write: Boolean?,
        @SerialName("delete") val delete: Boolean?,
        @SerialName("create") val create: Boolean?
    )

    @Serializable
    data class Orders(
//        @SerialName("campaign_id") val campaignId: List<Any?>?,
//        @SerialName("source_id") val sourceId: List<Any?>?,
//        @SerialName("medium_id") val mediumId: List<Any?>?,
        @SerialName("message_follower_ids") val messageFollowerIds: List<MessageFollowerId?>?,
        @SerialName("message_ids") val messageIds: List<MessageId?>?,
//        @SerialName("message_main_attachment_id") val messageMainAttachmentId: List<Any?>?,
        @SerialName("access_token") val accessToken: Boolean?,
        @SerialName("name") val name: String?,
        @SerialName("company_id") val companyId: List<CompanyId?>?,
        @SerialName("partner_id") val partner_id: List<PartnerId?>?,
        @SerialName("state") val state: String?,
        @SerialName("client_order_ref") val clientOrderRef: Boolean?,
        @SerialName("create_date") val createDate: String?,
        @SerialName("commitment_date") val commitmentDate: Boolean?,
        @SerialName("date_order") val dateOrder: String?,
        @SerialName("origin") val origin: Boolean?,
        @SerialName("reference") val reference: Boolean?,
        @SerialName("require_signature") val requireSignature: Boolean?,
        @SerialName("require_payment") val requirePayment: Boolean?,
        @SerialName("signature") val signature: Boolean?,
        @SerialName("signed_by") val signedBy: Boolean?,
        @SerialName("signed_on") val signedOn: Boolean?,
        @SerialName("validity_date") val validityDate: Boolean?,
        @SerialName("note") val note: Boolean?,
        @SerialName("partner_invoice_id") val partnerInvoiceId: List<PartnerInvoiceId?>?,
        @SerialName("partner_shipping_id") val partnerShippingId: List<PartnerShippingId?>?,
//        @SerialName("fiscal_position_id") val fiscalPositionId: List<Any?>?,
        @SerialName("payment_term_id") val paymentTermId: List<PaymentTermId?>?,
        @SerialName("pricelist_id") val pricelistId: List<PricelistId?>?,
        @SerialName("currency_id") val currencyId: List<CurrencyId?>?,
        @SerialName("currency_rate") val currencyRate: Double?,
        @SerialName("user_id") val userId: List<UserId?>?,
        @SerialName("team_id") val teamId: List<TeamId?>?,
        @SerialName("order_line") val orderLine: List<OrderLine?>?,
        @SerialName("amount_untaxed") val amountUntaxed: Double?,
        @SerialName("amount_tax") val amountTax: Double?,
        @SerialName("amount_total") val amountTotal: Double?,
        @SerialName("invoice_status") val invoice_status: String?,
//        @SerialName("analytic_account_id") val analyticAccountId: List<Any?>?,
        @SerialName("id") val id: Int?,
        @SerialName("create_uid") val createUid: List<CreateUid?>?,
        @SerialName("write_uid") val writeUid: List<WriteUid?>?,
        @SerialName("write_date") val writeDate: String?,
        @SerialName("has_due") val hasDue: Boolean?,
        @SerialName("is_warning") val isWarning: Boolean?,
//        @SerialName("sale_order_template_id") val saleOrderTemplateId: List<Any?>?,
//        @SerialName("incoterm") val incoterm: List<Any?>?,
        @SerialName("incoterm_location") val incotermLocation: Boolean?,
        @SerialName("picking_policy") val pickingPolicy: String?,
        @SerialName("warehouse_id") val warehouseId: List<WarehouseId?>?,
        @SerialName("picking_ids") val pickingIds: List<PickingId?>?,
        @SerialName("delivery_status") val deliveryStatus: String?,
        @SerialName("procurement_group_id") val procurementGroupId: List<ProcurementGroupId?>?,
        @SerialName("effective_date") val effectiveDate: Boolean?,
//        @SerialName("carrier_id") val carrierId: List<Any?>?,
        @SerialName("delivery_message") val deliveryMessage: Boolean?,
        @SerialName("delivery_rating_success") val deliveryRatingSuccess: Boolean?,
        @SerialName("recompute_delivery_price") val recomputeDeliveryPrice: Boolean?
    ) {
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
        data class CompanyId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class PartnerId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class PartnerInvoiceId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class PartnerShippingId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class PaymentTermId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class PricelistId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class CurrencyId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class UserId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class TeamId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class OrderLine(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class CreateUid(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class WriteUid(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class WarehouseId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class PickingId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )

        @Serializable
        data class ProcurementGroupId(
            @SerialName("id") val id: Int?,
            @SerialName("name") val name: String?
        )
    }
}