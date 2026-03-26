package org.opentmf.tmf699.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A Sales Lead is the identification of a person or organization that has an
 * interest in the goods and/or services provided in the prospect of them
 * becoming Customers with one or more Subscriptions.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-699: Sales Management API</li>
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
    defaultImpl = SalesLead.class
)
public class SalesLead extends SalesLeadUpdate implements ISalesLead {

  /**
   * Date and time of the salesLead creation.
   */
  private OffsetDateTime creationDate;

  /**
   * Reference of the salesLead.
   */
  private URI href;

  /**
   * Unique identifier of the salesLead.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}