package org.opentmf.tmf677.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * The ReserveBalance resource allows adjustments to be made to the original
 * BalanceTopup eg increment the amount, alter the recharge periodicity.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-677: Usage Consumption Management API</li>
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
    defaultImpl = ReserveBalanceRef.class
)
@Required(fields = {"id"})
public class ReserveBalanceRef extends EntityRef implements IReserveBalanceRef {
}