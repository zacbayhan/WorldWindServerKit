/*
 * Copyright (C) 2017 NASA World Wind
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package gov.nasa.worldwind.gs.geopkg.web;

import java.awt.Color;
import org.geoserver.web.GeoServerWicketTestSupport;
import static org.geoserver.web.GeoServerWicketTestSupport.tester;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Bruce Schubert
 */
public class ExportGeoPackagePageTest extends GeoServerWicketTestSupport {

    public ExportGeoPackagePageTest() {
    }

    /**
     * Smoke test to make sure the page structure was correctly set up.
     */
    @Test
    public void testStructure() {
        // Opening the selected page using the WicketTester 
        tester.startPage(new ExportGeoPackagePage());
        tester.assertRenderedPage(ExportGeoPackagePage.class);
        tester.assertNoErrorMessage();

    }
    @Test
    public void testDecodeColor() {
        ExportGeoPackagePage page = new ExportGeoPackagePage();
        
        Color rgbWhiteHex = page.decodeColor("#ffffff");
        assertEquals(Color.white, rgbWhiteHex);

        Color rgbWhite = page.decodeColor("ffffff");
        assertEquals(Color.white, rgbWhite);

        Color rgbaWhite = page.decodeColor("ffffffff");
        assertEquals(Color.white, rgbaWhite);

        Color empty = page.decodeColor("");
        assertNull(empty);
        
        Color tooShort = page.decodeColor("ff");
        assertNull(tooShort);

        Color tooBig = page.decodeColor("ffffffffff");
        assertNull(tooBig);

        Color invalid = page.decodeColor("not a color string");
        assertNull(invalid);
    }

}
