package org.opentmf.tmf634.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;

/**
 * The (resource) category resource is used to group resource candidates in
 * logical containers. Categories can contain other categories.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-634: Resource Catalog Management API</li>
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
    defaultImpl = ResourceCategory.class
)
public class ResourceCategory extends ResourceCategoryUpdate implements IResourceCategory {

  /**
   * Hyperlink reference to the category.
   */
  private URI href;

  /**
   * Unique identifier of the category.
   */
  @SafeId
  @Size(max = 100)
  private String id;
}