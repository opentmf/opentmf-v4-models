package org.opentmf.tmf699.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A Sales Lead is the identification of a person or organization that has an
 * interest in the goods and/or services provided in the prospect of them
 * becoming Customers with one or more Subscriptions.
 * <br/>Skipped properties: id,href,creationDate.
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
    defaultImpl = SalesLeadUpdate.class
)
public class SalesLeadUpdate extends SalesLeadCreate implements ISalesLeadUpdate {

  /**
   * Valid values for the lifecycle state of a salesLead resource
   * <br/><p>Recommended values: accepted, acknowledged, cancelled, inProgress,
   * pending, rejected.
   *
   * @see org.opentmf.tmf699.model.SalesLeadStateType
   */
  private @SafeText String status;

  /**
   * Date and time of the last update.
   */
  private OffsetDateTime statusChangeDate;
}