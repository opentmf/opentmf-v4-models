package org.opentmf.v4.tmf633.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * The root entity for service catalog management.
 * <br/>A service catalog is a group of service specifications made available
 * through service candidates that an organization provides to the consumers
 * (internal consumers like its employees or B2B customers or B2C customers). 
 * <br/>A service catalog typically includes name, description and time period
 * that is valid for. It will have a list of ServiceCandidate catalog items. A
 * ServiceCandidate is an entity that makes a ServiceSpecification available to
 * a catalog.
 * <br/>A ServiceCandidate and its associated ServiceSpecification may be
 * "published" - made visible -in any number of ServiceCatalogs, or in none.
 * <br/>Skipped properties: id,href,lastUpdate.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-633: Service Catalog Management API</li>
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
    defaultImpl = ServiceCatalogUpdate.class
)
public class ServiceCatalogUpdate extends Extensible {

  /**
   * Description of this catalog.
   */
  private @SafeText String description;

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name of the service catalog.
   */
  private @SafeText String name;

  /**
   * ServiceCatalog version.
   */
  private @SafeText String version;

  /**
   * List of service categories associated with this catalog.
   */
  @JsonProperty("category")
  private List<@Valid ServiceCategoryRef> categories;

  /**
   * List of parties or party roles related to this category.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * The period for which the service catalog is valid.
   */
  private @Valid TimePeriod validFor;
}