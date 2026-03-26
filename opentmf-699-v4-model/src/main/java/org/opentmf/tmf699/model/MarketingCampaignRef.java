package org.opentmf.tmf699.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.EntityRef;
import org.opentmf.commons.validation.constraints.Required;

/**
 * MarketingCampaign reference. Marketing campaign represents the
 * carrier-initiated marketing activity which aims at the better recognition
 * about its brand and offerings by the market.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-699: Sales Management API</li>
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
    defaultImpl = MarketingCampaignRef.class
)
@Required(fields = {"id"})
public class MarketingCampaignRef extends EntityRef implements IMarketingCampaignRef {
}