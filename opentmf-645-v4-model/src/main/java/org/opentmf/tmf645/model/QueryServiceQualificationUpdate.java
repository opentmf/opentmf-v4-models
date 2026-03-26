package org.opentmf.tmf645.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * QueryServiceQualification is used to retrieve a list of services that are
 * technically available in the context of the interaction (place, party,
 * service characteristics, ...).
 * <br/>Skipped properties: id,href,queryServiceQualificationDate.
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
    defaultImpl = QueryServiceQualificationUpdate.class
)
public class QueryServiceQualificationUpdate extends QueryServiceQualificationCreate implements IQueryServiceQualificationUpdate {

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
   * A list of service qualification items.
   */
  @JsonProperty("serviceQualificationItem")
  private List<@Valid ServiceQualificationItem> serviceQualificationItems;

  /**
   * Possible values for the state of a task
   * <br/><p>Recommended values: acknowledged, terminatedWithError, inProgress,
   * done.
   *
   * @see org.opentmf.common.model.TaskStateType
   */
  private @SafeText String state;
}