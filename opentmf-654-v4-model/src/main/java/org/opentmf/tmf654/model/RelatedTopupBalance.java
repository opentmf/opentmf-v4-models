package org.opentmf.tmf654.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.RelatedEntityRefOrValue;
import org.opentmf.commons.validation.constraints.Required;

/**
 * Related Entity reference. A related balance topup defines a relationship via
 * a role to another balance topup. Used in the PrepayBalanceManagement API to
 * track child topups that are related to the parent (initiating balance topup
 * resource). PrepayBalanceManagement defines the child role.
 *
 * <p><br/>
 * <strong>Required:</strong> @referredType, id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-654: Prepay Balance Management API</li>
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
    defaultImpl = RelatedTopupBalance.class
)
@Required(fields = {"atReferredType", "id"})
public class RelatedTopupBalance extends RelatedEntityRefOrValue implements IRelatedTopupBalance {
}