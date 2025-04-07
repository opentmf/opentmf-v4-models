package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.ResourceSpecificationRef;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * ResourceCandidate is an entity that makes a resource specification available
 * to a catalog. A ResourceCandidate and its associated resource specification
 * may be published - made visible - in any number of resource catalogs, or in
 * none.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = ResourceCandidateUpdate.class
)
public class ResourceCandidateUpdate extends Extensible {

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * Date and time of the last update of this REST resource.
   */
  private OffsetDateTime lastUpdate;

  /**
   * Used to indicate the current lifecycle status of the resource candidate.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name given to this REST resource.
   */
  private @SafeText String name;

  /**
   * the version of resource candidate.
   */
  private @SafeText String version;

  /**
   * The categories in which this candidate is exposed.
   */
  @JsonProperty("category")
  private List<@Valid ResourceCategoryRef> categories;

  /**
   * The detailed specification for this candidate.
   */
  private @Valid ResourceSpecificationRef resourceSpecification;

  /**
   * The period for which this REST resource is valid.
   */
  private @Valid TimePeriod validFor;
}