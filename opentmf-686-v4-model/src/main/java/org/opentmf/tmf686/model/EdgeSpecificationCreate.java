package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.AssociationCreateBase;
import org.opentmf.common.model.RelatedParty;
import org.opentmf.commons.validation.constraints.Required;

/**
 * A directed Edge connects Vertices in a Graph.
 * <br/>An EdgeSpecification is a base class that represents a generic means for
 * implementing a particular type of Edge. In essence, an EdgeSpecification
 * defines the common attributes and relationships of a set of related Edges,
 * while Edge defines a specific instance that is based on a particular
 * EdgeSpecification.
 * <br/>Skipped properties: id,href.
 *
 * <p><br/>
 * <strong>Required:</strong> name<br/>
 * </p>
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
    defaultImpl = EdgeSpecificationCreate.class
)
@Required(fields = {"name"})
public class EdgeSpecificationCreate extends AssociationCreateBase implements IEdgeSpecificationCreate {

  /**
   * A characteristic quality or distinctive feature of an EdgeSpecification.
   */
  @JsonProperty("edgeSpecCharacteristic")
  private List<@Valid EdgeSpecificationCharacteristic> edgeSpecCharacteristics;

  /**
   * A related party defines party or party role linked to a specific entity.
   */
  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}