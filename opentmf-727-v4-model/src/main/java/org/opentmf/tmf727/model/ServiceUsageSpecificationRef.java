package org.opentmf.tmf727.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * UsageSpecification reference. UsageSpecification is a detailed description of
 * a service usage event that are of interest to the business. It is comprised
 * of characteristics, which define all attributes known for a particular type
 * of usage.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-727: Service Usage Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = ServiceUsageSpecificationRef.class
)
@Required(fields = {"id"})
public class ServiceUsageSpecificationRef extends EntityRef implements IServiceUsageSpecificationRef {
}