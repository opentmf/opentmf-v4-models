package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.Setter;

/**
 * An attachment by value or by reference. An attachment complements the
 * description of an element, for example through a document, a video, a
 * picture.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-633: Service Catalog Management API</li>
 *   <li>TMF-634: Resource Catalog Management API</li>
 *   <li>TMF-639: Resource Inventory Management API</li>
 *   <li>TMF-648: Quote Management API</li>
 *   <li>TMF-651: Agreement</li>
 *   <li>TMF-652: Resource Order Management API</li>
 * </ul>
 * </p>
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = AttachmentRefOrValue.class
)
@JsonTypeName("Attachment")
public class AttachmentRefOrValue extends Attachment {
}