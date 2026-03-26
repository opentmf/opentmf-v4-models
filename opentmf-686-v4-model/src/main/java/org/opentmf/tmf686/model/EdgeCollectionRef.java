package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;

/**
 * Graph edge collection reference.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-686: Topology API</li>
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
    defaultImpl = EdgeCollectionRef.class
)
public class EdgeCollectionRef extends Extensible implements IEdgeCollectionRef {

  /**
   * The type of the referred entity.
   */
  @JsonProperty("@referredType")
  private URI atReferredType;

  /**
   * Hyperlink reference.
   */
  private URI href;
}