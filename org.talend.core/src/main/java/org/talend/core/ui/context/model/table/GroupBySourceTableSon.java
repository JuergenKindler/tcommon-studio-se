// ============================================================================
//
// Copyright (C) 2006-2009 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.ui.context.model.table;

import org.talend.core.model.process.IContextParameter;

/**
 * cli class global comment. Detailled comment
 */
public class GroupBySourceTableSon extends ContextTableSon {

    private IContextParameter parameter;

    public IContextParameter getParameter() {
        return this.parameter;
    }

    public void setParameter(IContextParameter parameter) {
        this.parameter = parameter;
    }

}
