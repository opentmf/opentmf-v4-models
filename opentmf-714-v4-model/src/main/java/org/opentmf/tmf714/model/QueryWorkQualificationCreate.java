package org.opentmf.tmf714.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.PlaceRefOrValue;
import org.opentmf.common.model.QualificationCreateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;

/**
 * QueryWorkQualification is used to retrieve a list of units of work that are
 * valid in the context of the interaction
 * <br/>Skipped properties:
 * id,href,workQualificationItem,state,effectiveQualificationDate,expirationDate,estimatedResponseDate,queryWorkQualificationDate.
 *
 * <p><br/>
 * <strong>Required:</strong> searchCriteria<br/>
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
    defaultImpl = QueryWorkQualificationCreate.class
)
@Required(fields = {"searchCriteria"})
public class QueryWorkQualificationCreate extends QualificationCreateBase implements IQueryWorkQualificationCreate {

  /**
   * A place described by reference or by value linked to a specific entity. The
   * polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are related to
   * the place entity and not the PlaceRefOrValue class itself.
   */
  private @Valid PlaceRefOrValue place;

  /**
   * A list of related party references, defines party or party role linked to
   * this request.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * A WorkQualificationItem relates to a specific unit of work being checked in a
   * qualification operation.
   */
  private @Valid WorkQualificationItem searchCriteria;
}