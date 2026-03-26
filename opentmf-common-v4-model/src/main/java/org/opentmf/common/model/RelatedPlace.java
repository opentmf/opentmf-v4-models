package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * A Place and an associated role as installation adress, delivery address,
 * etc....
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-658: Loyalty</li>
 *   <li>TMF-670: Payment Method Management API</li>
 *   <li>TMF-696: Risk Management API</li>
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
    defaultImpl = RelatedPlace.class
)
public class RelatedPlace extends RelatedEntityRefOrValue implements IRelatedPlace {
}