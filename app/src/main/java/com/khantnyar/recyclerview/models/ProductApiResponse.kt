package com.khantnyar.recyclerview.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductApiResponse(
    @SerializedName("data") var products: ArrayList<Products> = arrayListOf(),
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
data class Products(
    @SerialName("active") val active: Boolean?,
    @SerialName("can_be_expensed") val can_be_expensed: Boolean?,
    @SerialName("can_image_1024_be_zoomed") val can_image_1024_be_zoomed: Boolean?,
    @SerialName("categ_id") val categ_id: List<CategId?>?,
    @SerialName("color") val color: Int?,
//        @SerialName("company_id") val companyId: List<Any?>?,
//        @SerialName("country_of_origin") val countryOfOrigin: List<Any?>?,
    @SerialName("create_date") val create_date: String?,
    @SerialName("create_uid") val create_uid: List<CreateUid?>?,
    @SerialName("default_code") val default_code: String?,
    @SerialName("description") val description: Boolean?,
    @SerialName("description_picking") val description_picking: Boolean?,
    @SerialName("description_pickingin") val description_pickingin: Boolean?,
    @SerialName("description_pickingout") val description_pickingout: Boolean?,
    @SerialName("description_purchase") val description_purchase: Boolean?,
    @SerialName("description_sale") val description_sale: Boolean?,
    @SerialName("detailed_type") val detailed_type: String?,
    @SerialName("expense_policy") val expense_policy: String?,
    @SerialName("has_configurable_attributes") val has_configurable_attributes: Boolean?,
    @SerialName("hs_code") val hs_code: String?,
    @SerialName("id") val id: Int?,
    @SerialName("image_1024") val image_1024: String?,
    @SerialName("image_128") val image_128: String?,
    @SerialName("image_1920") val image_1920: String?,
    @SerialName("image_256") val image_256: String?,
    @SerialName("image_512") val image_512: String?,
    @SerialName("invoice_policy") val invoice_policy: String?,
    @SerialName("list_price") val list_price: Double?,
    @SerialName("message_follower_ids") val message_follower_ids: List<MessageFollowerId?>?,
    @SerialName("message_ids") val message_ids: List<MessageId?>?,
//        @SerialName("message_main_attachment_id") val messageMainAttachmentId: List<Any?>?,
    @SerialName("name") val name: String?,
    @SerialName("priority") val priority: String?,
    @SerialName("product_variant_ids") val product_variant_ids: List<ProductVariantId?>?,
    @SerialName("purchase_line_warn") val purchase_line_warn: String?,
    @SerialName("purchase_line_warn_msg") val purchase_line_warn_msg: Boolean?,
    @SerialName("purchase_method") val purchase_method: String?,
    @SerialName("purchase_ok") val purchase_ok: Boolean?,
    @SerialName("sale_delay") val sale_delay: Double?,
    @SerialName("sale_line_warn") val sale_line_warn: String?,
    @SerialName("sale_line_warn_msg") val sale_line_warn_msg: Boolean?,
    @SerialName("sale_ok") val sale_ok: Boolean?,
    @SerialName("seller_ids") val seller_ids: List<SellerId?>?,
    @SerialName("sequence") val sequence: Int?,
    @SerialName("service_type") val service_type: String?,
    @SerialName("tracking") val tracking: String?,
    @SerialName("type") val type: String?,
    @SerialName("uom_id") val uom_id: List<UomId?>?,
    @SerialName("uom_po_id") val uom_po_id: List<UomPoId?>?,
    @SerialName("variant_seller_ids") val variant_seller_ids: List<VariantSellerId?>?,
    @SerialName("volume") val volume: Double?,
    @SerialName("weight") val weight: Double?,
    @SerialName("write_date") val write_date: String?,
    @SerialName("write_uid") val write_uid: List<WriteUid?>?
) {
    @Serializable
    data class CategId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class CreateUid(
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
    data class ProductVariantId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class SellerId(
        @SerialName("id") val id: Int?
    )

    @Serializable
    data class UomId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class UomPoId(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )

    @Serializable
    data class VariantSellerId(
        @SerialName("id") val id: Int?
    )

    @Serializable
    data class WriteUid(
        @SerialName("id") val id: Int?,
        @SerialName("name") val name: String?
    )
}