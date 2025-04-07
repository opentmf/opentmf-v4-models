package org.opentmf.v4.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A manually introduced base object for all TM-Forum orders.
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = OrderBase.class
)
public class OrderBase extends Extensible {

  /**
   * A free-text description of the service order.
   */
  private @SafeText String description;

  /**
   * ID given by the consumer to facilitate searches.
   */
  @SafeId
  @Size(max = 100)
  private String externalId;

  /**
   * Requested delivery date from the requesters perspective.
   */
  private OffsetDateTime requestedCompletionDate;

  /**
   * Order start date wished by the requester.
   */
  private OffsetDateTime requestedStartDate;

  /**
   * Extra-information about the order; e.g. useful to add extra delivery
   * information that could be useful for a human process.
   */
  @JsonProperty("note")
  private List<@Valid Note> notes;

  /**
   * A list of parties which are involved in this order and the role they are
   * playing.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}