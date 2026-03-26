package org.opentmf.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A detailed description of when to initiate a billing cycle and the various
 * sub steps of a billing cycle.
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
    defaultImpl = BillingCycleSpecification.class
)
@Required(fields = {"name"})
public class BillingCycleSpecification extends BillingCycleSpecificationUpdate implements IBillingCycleSpecification {

  /**
   * Reference of the billing cycle specification.
   */
  private URI href;

  /**
   * Unique identifier of the billing cycle specification.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}