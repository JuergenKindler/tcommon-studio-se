// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006 Talend - www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.commons.ui.utils;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;


/**
 * DOC amaumont  class global comment. Detailled comment
 * <br/>
 *
 * $Id$
 *
 */
public class TableUtils {

    public static int getColumnIndex(Table table, Point pointCursor) {
        
        // searching current column index
        int currentColumnIndex = -1;
        TableColumn[] columns = table.getColumns();
        for (int i = 0, width = 0; i < columns.length; i++) {
            TableColumn column = columns[i];
            int widthColumn = column.getWidth();
            if (pointCursor.x >= width 
                    && pointCursor.x <= width + widthColumn 
                    && pointCursor.y > table.getHeaderHeight() 
                    && pointCursor.y < table.getHeaderHeight() + table.getItemCount() * table.getItemHeight()) {
                currentColumnIndex = i;
                break;
            }
            width += widthColumn;
        }

        return currentColumnIndex;
    }

    public static TableColumn getTableColumn(Table table, Point pointCursor) {
        // searching current column index
        TableColumn[] columns = table.getColumns();
        int columnIndex = getColumnIndex(table, pointCursor);
        if (columnIndex != -1) {
            return columns[columnIndex];
        }
        return null;
    }
    
    public static int getItemIndex(Table table, Point pointCursor) {
        // searching current item index
        TableItem tableItemUnderCursor = table.getItem(pointCursor);
        TableItem[] tableItems = table.getItems();
        int currentItemIndex = -1;
        for (int i = 0; i < tableItems.length; i++) {
            if (tableItemUnderCursor == tableItems[i]) {
                currentItemIndex = i;
                break;
            }
        }
        return currentItemIndex;
    }

    public static TableItem getTableItem(Table table, Point pointCursor) {
        // searching current column index
        TableItem[] items = table.getItems();
        int itemIndex = getItemIndex(table, pointCursor);
        if (itemIndex != -1) {
            return items[itemIndex];
        }
        return null;
    }
    
    
    /**
     * DOC amaumont Comment method "getCursorPositionFromTableOrigin".
     * @param event
     * @return
     */
    public static Point getCursorPositionFromTableOrigin(Table table, Event event) {
        Point pointCursor = new Point(event.x, event.y);
        
        Widget widget = event.widget;
        if (widget instanceof TableItem) {
            widget = ((TableItem) widget).getParent();
        }
        
        if (widget != table && widget instanceof Control) {
            pointCursor = table.getDisplay().map((Control) widget, table, pointCursor);
        }
        return pointCursor;
    }


    
}
