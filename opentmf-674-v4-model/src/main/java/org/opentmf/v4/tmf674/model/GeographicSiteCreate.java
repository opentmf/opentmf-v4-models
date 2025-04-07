package org.opentmf.v4.tmf674.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.CalendarPeriod;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.GeographicSiteRelationship;
import org.opentmf.v4.common.model.PlaceRefOrValue;
import org.opentmf.v4.common.model.RelatedParty;

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
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = GeographicSiteCreate.class
)
public class GeographicSiteCreate extends Extensible {

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
   * The condition of the GeographicSite, such as planned, underConstruction,
   * cancelled, active, inactive, former.
   */
  private @SafeText String status;

  @JsonProperty("calendar")
  private List<@Valid CalendarPeriod> calendars;

  /**
   * List of: A place described by reference or by value linked to a specific
   * entity. The polymorphic attributes {@literal @}type, {@literal @}schemaLocation & {@literal @}referredType are
   * related to the place entity and not the PlaceRefOrValue class itself.
   */
  @JsonProperty("place")
  private List<@Valid PlaceRefOrValue> places;

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  @JsonProperty("siteRelationship")
  private List<@Valid GeographicSiteRelationship> siteRelationships;
}