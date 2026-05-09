package org.opentmf.tmf670.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.PaymentMethod;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A cash method of payment. It has no additional data, but it could be extended
 * to add information e.g.: the cashier who took the payment, the person who
 * paid, etc.
 *
 * <p><br/>
 * <strong>Required:</strong> @type, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-670: Payment Method Management API</li>
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
    defaultImpl = Cash.class
)
@Required(fields = {"atType", "name"})
public class Cash extends PaymentMethod implements ICash {
}