package org.opentmf.tmf725.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Reference to Metadata Category object. The metadata category resource is used
 * to group entity catalog items in logical containers. Categories can contain
 * other categories.
 * <br/>Resource IDs for categories are strings and are defined by the catalog
 * application.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-725: Metadata Catalog Management API</li>
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
    defaultImpl = MetadataCategoryRef.class
)
@Required(fields = {"id"})
public class MetadataCategoryRef extends EntityRef implements IMetadataCategoryRef {

  /**
   * Category version.
   */
  private @SafeText String version;
}