/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.app.rest.model;

import org.dspace.app.rest.RestResourceController;

/**
 * The WorkspaceItem REST Resource
 *
 * @author Andrea Bollini (andrea.bollini at 4science.it)
 */
@LinksRest(links = {
    @LinkRest(name = WorkspaceItemRest.SUPERVISION_ORDERS, method = "getSupervisionOrders"),
    @LinkRest(name = WorkspaceItemRest.SUBMITTER, method = "getWorkspaceItemSubmitter"),
    @LinkRest(name = WorkspaceItemRest.ITEM, method = "getWorkspaceItemItem"),
    @LinkRest(name = WorkspaceItemRest.COLLECTION, method = "getWorkspaceItemCollection")
})
public class WorkspaceItemRest extends AInprogressSubmissionRest {
    public static final String NAME = "workspaceitem";
    public static final String CATEGORY = RestAddressableModel.SUBMISSION;

    public static final String SUPERVISION_ORDERS = "supervisionOrders";
    public static final String SUBMITTER = "submitter";
    public static final String ITEM = "item";
    public static final String COLLECTION = "collection";

    @Override
    public String getCategory() {
        return CATEGORY;
    }

    @Override
    public String getType() {
        return NAME;
    }

    @Override
    public Class getController() {
        return RestResourceController.class;
    }
}
