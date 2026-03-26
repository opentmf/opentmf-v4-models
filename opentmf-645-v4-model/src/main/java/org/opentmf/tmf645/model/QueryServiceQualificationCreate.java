package org.opentmf.tmf645.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.QualificationCreateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;

/**
 * QueryServiceQualification is used to retrieve a list of services that are
 * technically available in the context of the interaction (place, party,
 * service characteristics, ...).
 * <br/>Skipped properties:
 * id,href,serviceQualificationItem,state,effectiveQualificationDate,expirationDate,estimatedResponseDate,queryServiceQualificationDate.
 *
 * <p><br/>
 * <strong>Required:</strong> searchCriteria<br/>
 * </p>
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
    defaultImpl = QueryServiceQualificationCreate.class
)
@Required(fields = {"searchCriteria"})
public class QueryServiceQualificationCreate extends QualificationCreateBase implements IQueryServiceQualificationCreate {

  /**
   * A list of related party references, defines party or party role linked to
   * this request.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A ServiceQualificationItem relates to a specific service being checked in a
   * qualification operation.
   */
  private @Valid ServiceQualificationItem searchCriteria;
}