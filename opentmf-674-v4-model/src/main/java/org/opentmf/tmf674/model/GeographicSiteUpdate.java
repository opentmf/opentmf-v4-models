package org.opentmf.tmf674.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.common.model.PlaceRefOrValue;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-674: Geographic Site Management API</li>
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
    defaultImpl = GeographicSiteUpdate.class
)
public class GeographicSiteUpdate extends Extensible implements IGeographicSiteUpdate {

  @JsonProperty("calendar")
  private List<@Valid CalendarPeriod> calendars;

  /**
   * A code that may be used for some addressing schemes eg: [ANSI T1.253-1999].
   */
  private @SafeText String code;

  /**
   * Text describing additional information regarding the site.
   */
  private @SafeText String description;

  /**
   * A user-friendly name for the place, such as [Paris Store], [London Store],
   * [Main Home].
   */
  private @SafeText String name;

  /**
   * List of: A place described by reference or by value linked to a specific
   * entity. The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are
   * related to the place entity and not the PlaceRefOrValue class itself.
   */
  @JsonProperty("place")
  private List<@Valid PlaceRefOrValue> places;

  /**
   * List of: Related Party reference. A related party defines party or party role
   * linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  @JsonProperty("siteRelationship")
  private List<@Valid GeographicSiteRelationship> siteRelationships;

  /**
   * The condition of the GeographicSite, such as planned, underConstruction,
   * cancelled, active, inactive, former.
   */
  private @SafeText String status;
}