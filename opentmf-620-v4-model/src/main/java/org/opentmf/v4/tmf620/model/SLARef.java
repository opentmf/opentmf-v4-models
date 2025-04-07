package org.opentmf.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.v4.common.model.EntityRef;

/**
 * ServiceLevelAgreement reference: A service level agreement (SLA) is a type of
 * agreement that represents a formal negotiated agreement between two parties
 * designed to create a common understanding about products, services,
 * priorities, responsibilities, and so forth. The SLA is a set of appropriate
 * procedures and targets formally or informally agreed between parties in order
 * to achieve and maintain specified Quality of Service.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-620: Product Catalog Management API</li>
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
    defaultImpl = SLARef.class
)
@Required(fields = {"id"})
public class SLARef extends EntityRef {
}