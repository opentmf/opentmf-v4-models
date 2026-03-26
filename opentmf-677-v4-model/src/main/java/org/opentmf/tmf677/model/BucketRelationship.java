package org.opentmf.tmf677.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.Extensible;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Linked bucket to the one instantiate, such as [isAggregated] if the bucket is
 * a part of other or [aggregator] is the bucket holds others.
 *
 * <p><br/>
 * <strong>Required:</strong> bucketRefOrValue, relationshipType<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-677: Usage Consumption Management API</li>
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
    defaultImpl = BucketRelationship.class
)
@Required(fields = {"relationshipType", "bucketRefOrValue"})
public class BucketRelationship extends Extensible implements IBucketRelationship {

  /**
   * A bucket (called UsageVolumProduct in the SID Model) represents and tracks a
   * quantity of usage (remaining or consumed). It could be either a quantity or
   * an amount in a currency. It can represent a fixed number of SMS,MMS, call
   * minutes, quantity of data and so on.
   */
  private @Valid BucketRefOrValue bucketRefOrValue;

  /**
   * Type of the bucket relationship, such as [isAggregated] if the bucket is a
   * part of other or [aggregator] is the bucket holds others.
   */
  private @SafeText String relationshipType;
}