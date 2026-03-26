package org.opentmf.tmf686.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * The event data structure.
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
public class EdgeSpecificationChangeEventPayload implements IEdgeSpecificationChangeEventPayload {

  /**
   * A directed Edge connects Vertices in a Graph.
   * <br/>An EdgeSpecification is a base class that represents a generic means for
   * implementing a particular type of Edge. In essence, an EdgeSpecification
   * defines the common attributes and relationships of a set of related Edges,
   * while Edge defines a specific instance that is based on a particular
   * EdgeSpecification.
   */
  private @Valid EdgeSpecification edgeSpecification;
}