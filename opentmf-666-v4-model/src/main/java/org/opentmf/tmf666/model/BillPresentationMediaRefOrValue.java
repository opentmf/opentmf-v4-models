package org.opentmf.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AccountRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * An attachment by value or by reference.
 *
 * <p><br/>
 * <strong>Required:</strong> isRef, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = BillPresentationMediaRefOrValue.class
)
@Required(fields = {"isRef", "name"})
public class BillPresentationMediaRefOrValue extends AccountRef implements IBillPresentationMediaRefOrValue {

  private Boolean isRef;
}