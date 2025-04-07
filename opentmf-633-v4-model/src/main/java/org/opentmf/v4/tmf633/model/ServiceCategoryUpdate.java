package org.opentmf.v4.tmf633.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;
import org.opentmf.v4.common.model.ServiceCandidateRef;
import org.opentmf.v4.common.model.TimePeriod;

/**
 * The (service) category resource is used to group service candidates in
 * logical containers. Categories can contain other categories.
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
    defaultImpl = ServiceCategoryUpdate.class
)
public class ServiceCategoryUpdate extends Extensible {

  /**
   * Description of the category.
   */
  private @SafeText String description;

  /**
   * If true, this Boolean indicates that the category is a root of categories.
   */
  private Boolean isRoot;

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;

  /**
   * Name of the category.
   */
  private @SafeText String name;

  /**
   * Unique identifier of the parent category.
   */
  @SafeId
  @Size(max = 100)
  private String parentId;

  /**
   * ServiceCategory version.
   */
  private @SafeText String version;

  /**
   * List of child categories in the tree for in this category.
   */
  @JsonProperty("category")
  private List<@Valid ServiceCategoryRef> categories;

  /**
   * List of service candidates associated with this category.
   */
  @JsonProperty("serviceCandidate")
  private List<@Valid ServiceCandidateRef> serviceCandidates;

  /**
   * The period for which the category is valid.
   */
  private @Valid TimePeriod validFor;
}