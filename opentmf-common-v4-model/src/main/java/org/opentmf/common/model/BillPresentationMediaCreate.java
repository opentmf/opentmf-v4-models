package org.opentmf.common.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A mean of communicating a bill, supported by the associated bill format. For
 * example, post mail, email, web page.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
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
    defaultImpl = BillPresentationMediaCreate.class
)
@Required(fields = {"name"})
public class BillPresentationMediaCreate extends Extensible implements IBillPresentationMediaCreate {

  /**
   * An explanatory text describing this bill presentation media.
   */
  private @SafeText String description;

  /**
   * A short descriptive name.
   */
  private @SafeText String name;
}