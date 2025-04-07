package org.opentmf.v4.tmf633.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.ServiceSpecificationRef;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * ServiceCandidate is an entity that makes a service specification available to
 * a catalog. A
 * <br/>ServiceCandidate and its associated service specification may be
 * published - made visible - in any number of service catalogs, or in none. One
 * service specification can be composed of other service specifications.
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
    defaultImpl = ServiceCandidateUpdate.class
)
public class ServiceCandidateUpdate extends Extensible {

  /**
   * Description of this REST resource.
   */
  private @SafeText String description;

  /**
   * Used to indicate the current lifecycle status of the service candidate.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name given to this REST resource.
   */
  private @SafeText String name;

  /**
   * the version of service candidate.
   */
  private @SafeText String version;

  /**
   * List of categories for this candidate.
   */
  @JsonProperty("category")
  private List<@Valid ServiceCategoryRef> categories;

  /**
   * The service specification implied by this candidate.
   */
  private @Valid ServiceSpecificationRef serviceSpecification;

  /**
   * The period for which this REST resource is valid.
   */
  private @Valid TimePeriod validFor;
}