package org.opentmf.tmf728.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The DunningCase represents a type of cases open for a customer. Whenever a
 * customer enters the dunning process, a dunning case is linked to his customer
 * account debt and it contains all details pertaining to the debt, such as
 * dunning case rules, interactions… The status of a dunning case evolves
 * according to internal or external events (payments made by the customer,
 * payment schedule granted…).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-728: Dunning Case Management</li>
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
    defaultImpl = DunningCase.class
)
public class DunningCase extends DunningCaseUpdate implements IDunningCase {

  /**
   * Hyperlink, a reference to the dunning case.
   */
  private URI href;

  /**
   * Unique identifier for the dunning case.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}