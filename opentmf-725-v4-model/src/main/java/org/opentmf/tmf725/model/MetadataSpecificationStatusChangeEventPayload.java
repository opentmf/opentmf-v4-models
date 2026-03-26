package org.opentmf.tmf725.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class MetadataSpecificationStatusChangeEventPayload implements IMetadataSpecificationStatusChangeEventPayload {

  /**
   * MetadataSpecification is a class that describes the specification of a
   * specific metadata asset.
   */
  private @Valid MetadataSpecification metadataSpecification;
}