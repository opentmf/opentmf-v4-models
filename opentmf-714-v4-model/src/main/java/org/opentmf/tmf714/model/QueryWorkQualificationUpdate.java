package org.opentmf.tmf714.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * QueryWorkQualification is used to retrieve a list of units of work that are
 * valid in the context of the interaction
 * <br/>Skipped properties: id,href,queryWorkQualificationDate.
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
    defaultImpl = QueryWorkQualificationUpdate.class
)
public class QueryWorkQualificationUpdate extends QueryWorkQualificationCreate implements IQueryWorkQualificationUpdate {

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
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;

  /**
   * List of: A WorkQualificationItem relates to a specific unit of work being
   * checked in a qualification operation.
   */
  @JsonProperty("workQualificationItem")
  private List<@Valid WorkQualificationItem> workQualificationItems;
}