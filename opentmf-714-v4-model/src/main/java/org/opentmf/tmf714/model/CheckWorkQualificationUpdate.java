package org.opentmf.tmf714.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * CheckWorkQualification is used to validate specific units of work
 * <br/>Skipped properties: id,href,checkWorkQualificationDate.
 *
 * <p><br/>
 * <strong>Required:</strong> workQualificationItem<br/>
 * </p>
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
    defaultImpl = CheckWorkQualificationUpdate.class
)
@Required(fields = {"workQualificationItem"})
public class CheckWorkQualificationUpdate extends CheckWorkQualificationCreate implements ICheckWorkQualificationUpdate {

  /**
   * Effective date to qualification completion.
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
   * Qualification result for this workQualification. It could be: qualified (all
   * qualification item are qualified), alternate (At least one item alternate and
   * no item with unqualified), unqualified (At least one item unqualified).
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