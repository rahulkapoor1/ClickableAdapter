package com.rasi.clickablerecyclerviewadapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2017 Rasi Mobile
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/**
 * This class is use to generate dummy data which is going to display on UI.
 *
 * create by Rasi Mobile
 */

public class DummyDataGenerator {

    public static List<CustomItem> getItems() {
        final List<CustomItem> items = new ArrayList<>();
        items.add(new CustomItem("Eldora", "Dacus"));
        items.add(new CustomItem("Hunter", "Cogdell"));
        items.add(new CustomItem("Angelina", "Neill"));
        items.add(new CustomItem("Eusebia", "Keagle"));
        items.add(new CustomItem("Leisa", "Kinnaird"));
        items.add(new CustomItem("Celina", "Adan"));
        items.add(new CustomItem("Carri", "Whitley"));
        items.add(new CustomItem("Kizzie", "Bartholow"));
        items.add(new CustomItem("Gwendolyn", "Hudgens"));
        items.add(new CustomItem("Kory", "Zellers"));
        items.add(new CustomItem("Vicky", "Bartlow"));
        items.add(new CustomItem("Tricia", "Farinas"));
        return items;
    }

}
