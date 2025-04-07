package org.opentmf.v4.tmf634.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.v4.common.model.ResourceCandidateRef;

/**
 * The (resource) category resource is used to group resource candidates in
 * logical containers. Categories can contain other categories.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
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
    defaultImpl = ResourceCategoryCreate.class
)
@Required(fields = {"name"})
public class ResourceCategoryCreate extends ResourceCatalogCreate {

  /**
   * If true, this Boolean indicates that the category is a root of categories.
   */
  private Boolean isRoot;

  /**
   * Unique identifier of the parent category.
   */
  @SafeId
  @Size(max = 100)
  private String parentId;

  /**
   * List of resource candidates accessible via this category.
   */
  @JsonProperty("resourceCandidate")
  private List<@Valid ResourceCandidateRef> resourceCandidates;
}