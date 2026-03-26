package org.opentmf.tmf634.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AssociationCreateBase;
import org.opentmf.common.model.RelatedParty;

/**
 * The root entity for resource catalog management.
 * <br/>A resource catalog is a group of resource specifications made available
 * through resource candidates that an organization provides to the consumers
 * (internal consumers like its employees or B2B customers or B2C customers).
 * <br/>Skipped properties: id,href.
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
    defaultImpl = ResourceCatalogUpdate.class
)
public class ResourceCatalogUpdate extends AssociationCreateBase implements IResourceCatalogUpdate {

  /**
   * List of root categories contained in this catalog.
   */
  @JsonProperty("category")
  private List<@Valid ResourceCategoryRef> categories;

  /**
   * List of parties involved in this catalog.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}