package org.opentmf.tmf686.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Merges two or more Graphs into a single graph.
 * <br/>Skipped properties: id,href.
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
    defaultImpl = MergeTopologyGraphJobUpdate.class
)
public class MergeTopologyGraphJobUpdate extends TopologyDiscoveryJobUpdate implements IMergeTopologyGraphJobUpdate {

  private @Valid GraphRef graphResult;

  /**
   * URI with query string of the Topology GraphIds to be merged.
   */
  @JsonProperty("mergeTopologyGraph")
  private List<@Valid GraphRef> mergeTopologyGraphs;
}