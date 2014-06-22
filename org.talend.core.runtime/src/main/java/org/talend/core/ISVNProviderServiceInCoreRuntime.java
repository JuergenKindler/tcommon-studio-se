// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core;

import java.util.List;

/**
 * DOC zwzhao class global comment. Detailled comment
 */
public interface ISVNProviderServiceInCoreRuntime extends IService {

    public boolean isSvnLibSetupOnTAC();

    public boolean deployNewJar(List jars);

    public boolean isInSvn(String filePath);

    public void doUpdateAndCommit(String filePath);

    public void createFolderAndLinkToSvn(String filePath);

    public void synToSvn(String filePath);

    public void synProjectLib(String filePath);

    public void update();

}
