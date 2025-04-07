package org.opentmf.v4.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.RelatedEntityRefOrValue;

/**
 * An attachment by value or by reference.
 *
 * <p><br/>
 * <strong>Required:</strong> name, isRef<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = BillPresentationMediaRefOrValue.class
)
@Required(fields = {"isRef", "name"})
public class BillPresentationMediaRefOrValue extends RelatedEntityRefOrValue {

  /**
   * An explanatory text describing this bill presentation media.
   */
  private @SafeText String description;

  private Boolean isRef;
}