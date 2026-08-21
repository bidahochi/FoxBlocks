package com.bidahochi.BlockMod.blocks.props.configurable.client;

import java.util.List;

/**
 * Optional model capability for independently textured named groups. Group IDs
 * are stable definition-facing identifiers rather than Java field names.
 */
public interface IConfigurablePropGroupedModel
{

    /**
     * Returns stable group IDs in deterministic render order.
     *
     * @return ordered group IDs recognized by {@link #renderTextureGroup(String, float)}
     */
    public List<String> getTextureGroups();

    /**
     * Renders only one named group. Unknown IDs should render nothing so an old
     * model can tolerate a newer optional texture binding.
     *
     * @param groupId stable ID returned by {@link #getTextureGroups()}
     * @param scale TMT model scale supplied by the active renderer
     */
    public void renderTextureGroup(String groupId, float scale);
}
