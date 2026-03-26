package org.opentmf.tmf645.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * CheckServiceQualification is used to perform a technical eligibility on
 * service configuration(s). It allows to retrieve services that are technically
 * available in the context of the interaction (place, party, service
 * characteristics, ...).
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-645: Service Qualification Management API</li>
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
    defaultImpl = CheckServiceQualification.class
)
public class CheckServiceQualification extends CheckServiceQualificationUpdate implements ICheckServiceQualification {

  /**
   * Date when the serviceQualification was submitted.
   */
  private OffsetDateTime checkServiceQualificationDate;

  /**
   * Hyperlink to access the serviceQualification.
   */
  private URI href;

  /**
   * Unique identifier of the serviceQualification resource.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}