package org.opentmf.tmf725.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.NamedEntity;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A type of MetadataSpecification that belongs to a grouping of
 * MetadataSpecifications. It inherits of all attributes of
 * MetadataSpecification.
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
    defaultImpl = CompositeMetadataSpecification.class
)
public class CompositeMetadataSpecification extends NamedEntity implements ICompositeMetadataSpecification {

  /**
   * Used to indicate the current lifecycle status.
   */
  private @SafeText String lifecycleStatus;
}