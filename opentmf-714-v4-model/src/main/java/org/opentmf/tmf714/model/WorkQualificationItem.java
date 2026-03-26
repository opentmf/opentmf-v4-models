package org.opentmf.tmf714.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EligibilityUnavailabilityReason;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.WorkRefOrValue;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * A WorkQualificationItem relates to a specific unit of work being checked in a
 * qualification operation.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-714: Work Qualification Management</li>
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
    defaultImpl = WorkQualificationItem.class
)
public class WorkQualificationItem extends Extensible implements IWorkQualificationItem {

  /**
   * List of: Reason for eligibility result if the productOfferingQualification
   * result is no (meaning the productOffering or productSpec is not available).
   */
  @JsonProperty("eligibilityUnavailabilityReason")
  private List<@Valid EligibilityUnavailabilityReason> eligibilityUnavailabilityReasons;

  /**
   * The date when the work is expected to take place.
   */
  private OffsetDateTime expectedWorkDate;

  /**
   * Date when the qualification item response expires.
   */
  private OffsetDateTime expirationDate;

  /**
   * Id of the Work Qualification Item.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * A Unit of Work defined by value or existing defined by reference. The
   * polymorphic attributes {@literal @}type, {@literal @}schemaLocation &amp; {@literal @}referredType are related
   * to the work entity and not the related WorkRefOrValue class itself.
   */
  private @Valid WorkRefOrValue work;
}