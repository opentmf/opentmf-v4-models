package org.opentmf.tmf645.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * CheckServiceQualification is used to perform a technical eligibility on
 * service configuration(s). It allows to retrieve services that are technically
 * available in the context of the interaction (place, party, service
 * characteristics, ...).
 * <br/>Skipped properties: id,href,checkServiceQualificationDate.
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
    defaultImpl = CheckServiceQualificationUpdate.class
)
public class CheckServiceQualificationUpdate extends CheckServiceQualificationCreate implements ICheckServiceQualificationUpdate {

  /**
   * Effective date to serviceQualification completion.
   */
  private OffsetDateTime effectiveQualificationDate;

  /**
   * Date when the requester expect to provide an answer for the qualification
   * request.
   */
  private OffsetDateTime estimatedResponseDate;

  /**
   * Date when the qualification response expires.
   */
  private OffsetDateTime expirationDate;

  /**
   * Qualification result for this serviceQualification. It could be: qualified
   * (all qualification item are qualified), alternate (At least one item
   * alternate and no item with unqualified), unqualified (At least one item
   * unqualified).
   */
  private @SafeText String qualificationResult;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}